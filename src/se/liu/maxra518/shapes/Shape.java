package se.liu.maxra518.shapes;

import java.awt.*;

public interface Shape
{
	public void draw(final Graphics g);
	public int getX();
	public int getY();
	public Color getColor();

}
