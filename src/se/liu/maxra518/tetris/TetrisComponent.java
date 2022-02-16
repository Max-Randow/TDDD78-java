package se.liu.maxra518.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EnumMap;
import java.util.Map;

public class TetrisComponent extends JComponent implements BoardListener
{
    private final Board board;


    public TetrisComponent(Board board, JFrame frame) {
	this.board = board;
	JComponent pane = frame.getRootPane();

	final InputMap in = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("LEFT"), "left");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "right");

	final ActionMap act = pane.getActionMap();
	act.put("left", new MoveAction(Direction.LEFT));
	act.put("right", new MoveAction(Direction.RIGHT));
    }


    public Dimension getPreferredSize() {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	screenSize.height = (int) (screenSize.getHeight() * 0.8); // Scale down abit so components can fit
	screenSize.width = (int) (screenSize.getWidth() * 0.8);
	return screenSize;
    }

    private static EnumMap<SquareType, Color> createColorMap() {

	EnumMap<SquareType, Color> colorMap = new EnumMap<>(
		Map.ofEntries(Map.entry(SquareType.EMPTY, Color.black), Map.entry(SquareType.Z, Color.red), Map.entry(SquareType.J, Color.blue),
			      Map.entry(SquareType.I, Color.cyan), Map.entry(SquareType.L, Color.orange), Map.entry(SquareType.O, Color.yellow),
			      Map.entry(SquareType.S, Color.green), Map.entry(SquareType.T, Color.pink)));

	return colorMap;
    }


    @Override protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	EnumMap<SquareType, Color> colors = createColorMap();

	for (int i = 0; i < board.getHeight(); i++) {
	    for (int j = 0; j < board.getWidth(); j++) {
		SquareType type = board.getVisableSquareAt(j, i);


		    g2d.setColor(colors.get(type));
		    g2d.fillRect(j * 50, i * 50, 50, 50);

	    }

	}
    }

    @Override public void boardChanged() {
	repaint();
    }



    private class MoveAction extends AbstractAction {

	private final Direction direction;

	private MoveAction(Direction direction) {
	    this.direction = direction;
	}

	@Override public void actionPerformed(final ActionEvent e) {
	    board.move(direction);
	}
    }
}
