package se.liu.maxra518.tetris;

public class BoardTester
{
    public static void main(String[] args) {
	BoardToTextConverter boardToText = new BoardToTextConverter();

	Board testBoard = new Board(7,4);
	TetrisViewer tetrisViewer = new TetrisViewer(testBoard);
	testBoard.scrambleBoard();
	tetrisViewer.showBoard();
    }
}
