package se.liu.maxra518.calendar;

public class TimeSpan
{
    public TimePoint start;
    public TimePoint end;

    public TimeSpan(TimePoint start, TimePoint end) {
	this.start = start;
	this.end = end;
    }

    public TimePoint getStart(){
	return start;
    }

    public TimePoint getEnd(){
	return end;
    }
    @Override public String toString() {return getStart() + " - " + getEnd();}


}
