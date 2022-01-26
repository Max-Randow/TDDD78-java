package se.liu.maxra518.calendar;

public class TimePoint
{
    private int hour;
    private int minute;

    public TimePoint(final int hour, final int minute) {
	this.hour = hour;
	this.minute = hour;
    }

    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }

    public int compareTo(TimePoint other) {
	if(getHour()*60 + getMinute() > other.getHour()*60 + other.getMinute()) {return 1;}
	if(getHour()*60 + getMinute() < other.getHour()*60 + other.getMinute()) {return -1;}

	return 0;
    }

    @Override public String toString() {return String.format("%02d:%02d", getHour(),getMinute());}
}


