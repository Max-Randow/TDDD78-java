package se.liu.maxra518.tetris;

import java.awt.*;

public class Poly
{
    private final SquareType[][] poly;
    private int height;
    private int width;





    public Poly(final SquareType[][] poly){
	this.poly = poly;
	this.height = poly.length;
	this.width = poly[0].length;


    }

    public int getHeight(){return height;}
    public int getWidth(){return width;}





    public SquareType getSquareType(int y, int x) {return poly[y][x];}
}
