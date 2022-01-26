package se.liu.maxra518.tetris;

public class TetrominoMaker
{
    public int getNumberOfTypes(){
	return SquareType.values().length - 1;
    }
    public Poly getPoly(int n){
	SquareType[][] out = new SquareType[2][2];
	if( n>0 && n<= getNumberOfTypes() ){
	    SquareType selectedPoly = SquareType.values()[n];

	    switch (selectedPoly) {
		case O -> out = new SquareType[][]{ {SquareType.O,SquareType.O}, {SquareType.O,SquareType.O} };

		case S -> out = new SquareType[][]{	{SquareType.EMPTY,SquareType.EMPTY,SquareType.EMPTY},
							{SquareType.EMPTY, SquareType.S, SquareType.S},
							{SquareType.S, SquareType.S, SquareType.EMPTY}};

		case T -> out = new SquareType[][]{	{SquareType.EMPTY,SquareType.T,SquareType.EMPTY},
							{SquareType.T, SquareType.T, SquareType.T},
							{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};

		case Z -> out = new SquareType[][]{	{SquareType.Z,SquareType.Z,SquareType.EMPTY},
							{SquareType.EMPTY, SquareType.Z, SquareType.Z},
							{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};

		case L -> out = new SquareType[][]{	{SquareType.EMPTY,SquareType.EMPTY,SquareType.L},
							{SquareType.L, SquareType.L, SquareType.L},
							{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};

		case J -> out = new SquareType[][]{	{SquareType.J,SquareType.EMPTY,SquareType.EMPTY},
							{SquareType.J, SquareType.J, SquareType.J},
							{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};

		case I -> out = new SquareType[][]{	{SquareType.EMPTY,SquareType.EMPTY,SquareType.EMPTY},
							{SquareType.I, SquareType.I, SquareType.I},
							{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
	    }


	}
	else { throw new IllegalArgumentException("Invalid index: " + n);}
	
	return new Poly(out);
    }
}
