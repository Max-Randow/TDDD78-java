package se.liu.maxra518.lab1;

import javax.swing.*;

public class Excercise3
{

    static String input =  JOptionPane.showInputDialog("Please input a value");
    static int tabell = Integer.parseInt(input);


    public static void main(String[] args) {

        for(int i = 1; i <= 12; i++){
            System.out.println(i * tabell);
        }
    }

}
