package se.liu.maxra518.tetris;

public class BoardToTextConverter
{


    public String convertToText(Board board){
	StringBuilder builder = new StringBuilder();
	for(int i = 0; i < board.getHeight(); i++){
	    for(int j = 0; j < board.getWidth(); j++){
		switch (board.getVisableSquareAt(j, i))
		{
		    case I -> builder.append("I");
		    case J -> builder.append("J");
		    case L -> builder.append("L");
		    case O -> builder.append("O");
		    case S -> builder.append("S");
		    case T -> builder.append("T");
		    case Z -> builder.append("Z");
		    case EMPTY -> builder.append("-");
		    case OUTSIDE -> builder.append("OUT");
		}
	    }
	    builder.append("\n");
	}
	return builder.toString();
    }
}

