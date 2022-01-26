package se.liu.maxra518.calendar;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Cal
{
    private List<Appointment> appointments = new ArrayList<>();

    public Cal(){
        appointments = new ArrayList<>();
    }

    public void show(){
        for( Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public void book(int year, String month, int day, int startHour, int startMinute, int endHour, int endMinute, String subject){

        if(year < 1970)                                     { throw new IllegalArgumentException("Year given was before 1970, enter a new start year");}
        if( startHour < 0 && startHour > 23)                { throw new IllegalArgumentException("Bad start times");}
        if( endHour < 0 && endHour > 23)                    { throw new IllegalArgumentException("Bad end times");}
        if( startMinute < 0 && startMinute > 59)            { throw new IllegalArgumentException("Bad start times");}
        if( endMinute < 0 && endMinute > 59)                { throw new IllegalArgumentException("Bad end times");}
        if( day > Month.getMonthDays(month) || day < 1)     { throw new IllegalArgumentException("Day is not in month");}


        Month month1 = new Month(month, Month.getMonthNumber(month), Month.getMonthDays(month));
        TimePoint startTimePoint = new TimePoint(startHour, startMinute);
        TimePoint endTimePoint = new TimePoint(endHour, endMinute);
        TimeSpan appTimeSpan = new TimeSpan(startTimePoint,endTimePoint);
        SimpleDate bookedDate = new SimpleDate(year,month1, day);
        Appointment appointment = new Appointment(subject, bookedDate, appTimeSpan);
        appointments.add(appointment);




    }


}
