package se.liu.maxra518.lab1;

import javax.swing.*;

public class Excercise3
{

    private static final String PLEASE_INPUT_A_VALUE =  JOptionPane.showInputDialog("Please input a value");
    private static int tabell = Integer.parseInt(PLEASE_INPUT_A_VALUE);


    public static void main(String[] args) {

        for(int i = 1; i <= 12; i++){
            System.out.println(i * tabell);
        }
    }

}
