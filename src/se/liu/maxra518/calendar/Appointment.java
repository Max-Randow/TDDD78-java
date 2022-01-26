package se.liu.maxra518.calendar;

public class Appointment
{
    private String subject;
    private SimpleDate date;
    private TimeSpan timespan;

    public Appointment(final String subject, final SimpleDate date, final TimeSpan timespan) {
        this.subject = subject;
        this.date = date;
        this.timespan = timespan;
    }

    public String getSubject(){return subject;}
    public SimpleDate getDate() {return date;}
    public TimeSpan getTimespan() {return timespan;}

    @Override public String toString() {return "DATE : " + getDate() + " TIMESPAN : " + getTimespan() + " " + getSubject();}
}
