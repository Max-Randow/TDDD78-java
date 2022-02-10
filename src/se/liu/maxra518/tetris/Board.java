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

    public Board(final int height, final int width){
	this.height = height;
	this.width = width;
	this.squares = new SquareType[height][width];
	falling = new TetrominoMaker().getPoly(1);
	fallingPos = new Point(0, 0);

	for (int i = 0; i < height; i++) {
	    for (int j = 0; j < width; j++) {
		squares[i][j] = SquareType.EMPTY;
	    }

	}
    }

    public int getHeight()	{return height;}
    public int getWidth()	{return width;}

    public SquareType getSquareType(int y, int x) {return squares[y][x];}

    public void scrambleBoard(){
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



    public SquareType getVisiableSquareAt(int x, int y){
	int fallingPosX = (int) fallingPos.getX();
	int fallingPosY = (int) fallingPos.getY();

	// Look at board
	if(x > fallingPosX + falling.getWidth()-1 )	{return getSquareType(y,x);}
	if(x < fallingPosX) 				{return getSquareType(y,x);}
	if(y > fallingPosY + falling.getHeight()-1) 	{return getSquareType(y,x);}
	if(y < fallingPosY) 				{return getSquareType(y,x);}

	// Look at tetromino
	else {
	    if(falling.getSquareType(y-fallingPosY, x-fallingPosX) == SquareType.EMPTY){ return getSquareType(y,x); }
	    else { return falling.getSquareType(y-fallingPosY, x-fallingPosX); }
	}
    }

    public void addBoardListener(BoardListener bl){
	boardListeners.add(bl);
    }
    private void notifyListeners(){
	for (BoardListener boardListener : boardListeners) {
	    boardListener.boardChanged();
	}
    }
    public void tick(){
	if (falling != null) {moveFalling(0,1);}
	else {setFalling();}

	notifyListeners();
    }
    public void setFalling(){
	falling = new TetrominoMaker().getPoly(1);
	fallingPos = new Point(getWidth()/2-falling.getWidth()/2, 0);
    }

    public void moveFalling(int x,int y){
	fallingPos.setLocation(fallingPos.getX()+x, fallingPos.getY()+y);

    }
    public void move(Direction direction){
	switch (direction){
	    case LEFT -> moveFalling(-1,0);
	    case RIGHT -> moveFalling(1,0);
	}
	notifyListeners();
    }


}
