package se.liu.maxra518.calendar;


import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {





        Cal cal1 = new Cal();
        cal1.book(1999, "april", 13, 14, 14, 14,14, "jälva skit java");
        cal1.book(1993,"oktober", 50, 23, 53, 24, 20, "hej");

        cal1.show();

    }
}
