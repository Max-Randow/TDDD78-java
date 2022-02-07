package se.liu.maxra518.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTester
{




    public static void main(String[] args) {
	BoardToTextConverter boardToText = new BoardToTextConverter();

	Board testBoard = new Board(7,4);
	TetrisViewer tetrisViewer = new TetrisViewer(testBoard);
	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		testBoard.scrambleBoard();
		System.out.println((new BoardToTextConverter().convertToText(testBoard)));
		tetrisViewer.updateBoard(testBoard);


	    }
	};

	final Timer clockTimer = new Timer(500, doOneStep);
	clockTimer.setCoalesce(true);






	testBoard.scrambleBoard();
	clockTimer.start();
	tetrisViewer.showBoard();



    }
}
