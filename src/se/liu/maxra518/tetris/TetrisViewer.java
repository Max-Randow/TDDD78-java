package se.liu.maxra518.tetris;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TetrisViewer
{
    private JFrame frame = new JFrame("Hello guyse");

    private Board board;
    private TetrisComponent tetrisComponent;

    public TetrisViewer(Board board){
	this.board = board;
    }
    private JTextArea textArea;
    public void showBoard(){
	tetrisComponent = new TetrisComponent(board, frame);
	frame.add(tetrisComponent);
	frame.pack();
	frame.setVisible(true);


    }
    public void updateBoard(){
	tetrisComponent.boardChanged();
	frame.revalidate();


    }

}
