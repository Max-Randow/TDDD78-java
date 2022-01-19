package se.liu.maxra518.tetris;

import java.util.Random;

public enum SquareType
{
    EMPTY, I, O, T, S, Z, J, L;


    public static void main(String[] args) {
	Random rnd = new Random();
	for(int i = 0; i <= 25; i++) {
	    System.out.println(SquareType.values()[rnd.nextInt(SquareType.values().length)]);

	}

    }
}

