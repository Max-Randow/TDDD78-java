package se.liu.maxra518.calendar;

import java.util.Map;

public class Month
{
    private String name;
    private int number;
    private int days;

    private final static Map<String,Integer> MONTH_NAME_TO_LENGTH = Map.ofEntries(
	    Map.entry("january", 31),
	    Map.entry("february", 28),
	    Map.entry("mars", 31),
	    Map.entry("april", 30),
	    Map.entry("maj", 31),
	    Map.entry("juni", 30),
	    Map.entry("juli", 31),
	    Map.entry("augusti", 31),
	    Map.entry("september", 30),
	    Map.entry("oktober", 31),
	    Map.entry("november", 30),
	    Map.entry("december", 31)

    );
    private final static Map<String, Integer> MONTH_NAME_TO_NUMBER = Map.ofEntries(
	    Map.entry("january", 1),
	    Map.entry("february", 2),
	    Map.entry("mars", 3),
	    Map.entry("april", 4),
	    Map.entry("maj", 5),
	    Map.entry("juni", 6),
	    Map.entry("juli", 7),
	    Map.entry("augusti", 8),
	    Map.entry("september", 9),
	    Map.entry("oktober", 10),
	    Map.entry("november", 11),
	    Map.entry("december", 12)

    );




    public Month(final String name, final int number, final int days) {
	this.name = name;
	this.number = number;
	this.days = days;


    }

    public String getName() {
	return name;
    }

    public int getNumber() {
	return number;
    }

    public int getDays() {
	return days;
    }

    public static int getMonthNumber(String name){
	return MONTH_NAME_TO_NUMBER.getOrDefault(name, -1);
    }
    public static int getMonthDays(String name){
	return MONTH_NAME_TO_LENGTH.getOrDefault(name, -1);
    }


}
