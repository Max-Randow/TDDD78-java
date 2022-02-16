package se.liu.maxra518.tetris;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Board
{
    private SquareType[][] squares;
    private int height;
    private int width;
    private final static Random RND = new Random();
    private Poly falling;
    private Point fallingPos;
    private List<BoardListener> boardListeners = new ArrayList<>();
    private static final int MARGIN = 2;
    private static final int DOUBLE_MARGIN = MARGIN * 2;
    private boolean isGameOver = false;

    public Board(final int height, final int width) {
	this.height = height;
	this.width = width;
	this.squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];
	falling = new TetrominoMaker().getPoly(1);
	fallingPos = new Point(0, 0);

	for (int i = 0; i < height + DOUBLE_MARGIN; i++) {
	    for (int j = 0; j < width + DOUBLE_MARGIN; j++) {
		if (i == 0 || i == 1 || i == squares.length - MARGIN || i == squares.length - 1) {
		    squares[i][j] = SquareType.OUTSIDE;
		} else if (j == 0 || j == 1 || j == squares[i].length - MARGIN || j == squares[i].length - 1) {
		    squares[i][j] = SquareType.OUTSIDE;
		} else {
		    squares[i][j] = SquareType.EMPTY;
		}
	    }
	}


    }

    public int getHeight() {
	return height;
    }

    public int getWidth() {
	return width;
    }

    public SquareType getSquareType(int y, int x) {
	return squares[y + MARGIN][x + MARGIN];
    }

    public void scrambleBoard() {
	for (int i = 0; i < getHeight(); i++) {
	    for (int j = 0; j < getWidth(); j++) {
		squares[i][j] = SquareType.values()[RND.nextInt(SquareType.values().length)];
	    }

	}
	notifyListeners();
    }

    //xxx
    //xxx
    //xxx


    public SquareType getVisableSquareAt(int x, int y) {
	if (falling == null) {
	    return getSquareType(y, x);
	}
	int fallingPosX = (int) fallingPos.getX();
	int fallingPosY = (int) fallingPos.getY();

	// Look at board
	if (x > fallingPosX + falling.getWidth() - 1) {
	    return getSquareType(y, x);
	}
	if (x < fallingPosX) {
	    return getSquareType(y, x);
	}
	if (y > fallingPosY + falling.getHeight() - 1) {
	    return getSquareType(y, x);
	}
	if (y < fallingPosY) {
	    return getSquareType(y, x);
	}

	// Look at tetromino
	else {
	    if (falling.getSquareType(y - fallingPosY, x - fallingPosX) == SquareType.EMPTY) {
		return getSquareType(y, x);
	    } else {
		return falling.getSquareType(y - fallingPosY, x - fallingPosX);
	    }
	}
    }

    public void addBoardListener(BoardListener bl) {
	boardListeners.add(bl);
    }

    private void notifyListeners() {
	for (BoardListener boardListener : boardListeners) {
	    boardListener.boardChanged();
	}
    }

    public void tick() {
	if (falling == null) {
	    setFalling();
	    if (hasCollision()) {
		isGameOver = true;
	    }
	}
	if (!isGameOver) {

	    if (falling != null) {
		moveFalling(0, 1);
		if (hasCollision()) {
		    moveFalling(0, -1);

		    System.out.println("Falling is null");

		    addToBoard();
		    falling = null;

		}

	    } else {
		setFalling();
	    }
	    clearRows();


	    notifyListeners();
	}

    }

    public void setFalling() {

	falling = new TetrominoMaker().getPoly(RND.nextInt(1,7));
	fallingPos = new Point(getWidth() / 2 - falling.getWidth() / 2, 0);
    }

    public void moveFalling(int x, int y) {
	if (falling != null){
		fallingPos.setLocation(fallingPos.getX() + x, fallingPos.getY() + y);
		if (hasCollision()) {
	    	fallingPos.setLocation(fallingPos.getX() - x, fallingPos.getY());
		}
	}
    }

    public void move(Direction direction) {
	switch (direction) {
	    case LEFT -> moveFalling(-1, 0);
	    case RIGHT -> moveFalling(1, 0);
	}
	notifyListeners();
    }

    public boolean hasCollision() {
	int fallingPosX = (int) fallingPos.getX();
	int fallingPosY = (int) fallingPos.getY();
	for (int i = 0; i < falling.getHeight(); i++) {
	    for (int j = 0; j < falling.getWidth(); j++) {
		if (getSquareType(i + fallingPosY, j + fallingPosX) != SquareType.EMPTY && falling.getSquareType(i, j) != SquareType.EMPTY) {
		    System.out.println("hejhej");
		    return true;
		}
	    }
	}
	return false;
    }

    public void addToBoard() {
	int fallingPosX = (int) fallingPos.getX();
	int fallingPosY = (int) fallingPos.getY();

	for (int i = fallingPosY; i < fallingPosY + falling.getHeight(); i++) {
	    for (int j = fallingPosX; j < fallingPosX + falling.getWidth(); j++) {
		squares[i + MARGIN][j + MARGIN] = getVisableSquareAt(j, i);
	    }

	}
    }

    public void rotate(Direction dir) {
	Poly fallingCopy = falling;
	Poly rotatedPoly = null;

	switch (dir) {

	    case RIGHT -> rotatedPoly = falling.rotate(true);
	    case LEFT -> rotatedPoly = falling.rotate(false);
	}
	falling = rotatedPoly;
	if (hasCollision()) {
	    // Roation is prohibited, revert rotation
	    falling = fallingCopy;
	}


    }

    public boolean isFullRow(int y) {
	for (int x = MARGIN; x < getWidth()+MARGIN; x++) {
	    if (squares[y][x] == SquareType.EMPTY) {
		return false;
	    }

	}
	return true;
    }

    public void clearRows() {
	int i = getHeight()+MARGIN-1;
	while(i >= MARGIN) {
	    	if(isFullRow(i)){

		for (int y = i; y >= MARGIN; y--) {
		    if (y == MARGIN) {
			squares[y] = makeEmptyRow(y);

		    } else {
			squares[y] = squares[y-1];
		    }



		    }
		}
		    else {
			i--;
		}

	}
    }

    private SquareType[] makeEmptyRow(int y){
	SquareType[] row = new SquareType[width + DOUBLE_MARGIN];

	for (int i = 0; i < row.length; i++) {
	    if(y < MARGIN || i < MARGIN || i >= width + MARGIN || y >= height + MARGIN){
		row[i] = SquareType.OUTSIDE;
	    } else {
		row[i] = SquareType.EMPTY;
	    }
	    
	}
	return row;
    }


}
