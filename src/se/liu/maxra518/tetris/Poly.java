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

    public Poly rotate(boolean right){
	Poly rotatedPoly = new Poly(new SquareType[this.getHeight()][this.getWidth()]);
	if (right) {
	    for (int r = 0; r < this.getHeight(); r++) {
		for (int c = 0; c < this.getWidth(); c++) {
		    rotatedPoly.poly[c][rotatedPoly.getWidth() - 1 - r] = this.poly[r][c];
		}
	    }
	}
	// Rotate 3 times to the right to rotate the poly left
	else {
	    for (int i = 0; i < 3; i++) {
		for (int r = 0; r < this.getHeight(); r++) {
		    for (int c = 0; c < this.getWidth(); c++) {
			rotatedPoly.poly[c][rotatedPoly.getWidth() - 1 - r] = this.poly[r][c];
		    }
		}
	    }
	}
	return rotatedPoly;
    }



    public SquareType getSquareType(int y, int x) {return poly[y][x];}
}
