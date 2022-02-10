package se.liu.maxra518.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BoardTester
{




    public static void main(String[] args) {
	Board testBoard = new Board(24,16);
	BoardToTextConverter boardToText = new BoardToTextConverter();


	TetrisViewer tetrisViewer = new TetrisViewer(testBoard);
	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		testBoard.tick();
		tetrisViewer.updateBoard();


	    }
	};

	final Timer clockTimer = new Timer(500, doOneStep);
	clockTimer.setCoalesce(true);







	clockTimer.start();
	tetrisViewer.showBoard();



    }
}
