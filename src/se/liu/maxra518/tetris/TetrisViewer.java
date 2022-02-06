package se.liu.maxra518.tetris;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TetrisViewer
{
    private JFrame frame = new JFrame("Hello guyse");

    private Board board;

    public TetrisViewer(Board board){
	this.board = board;
    }
    private JTextArea textArea;
    public void showBoard(){
	textArea = new JTextArea(board.getWidth(), board.getHeight());
	textArea.setText(new BoardToTextConverter().convertToText(board));
	textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	frame.setLayout(new BorderLayout());
	frame.add(textArea, BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);


    }
    public void updateBoard(Board board){
	textArea.setText(new BoardToTextConverter().convertToText(board));
	this.frame.revalidate();


    }

}
