package se.liu.maxra518.lab1;

import java.time.LocalDate;
import java.time.Period;

public class Person
{
    private String name;
    private LocalDate birthDay;

    public Person(String name,  LocalDate birthDay){
        this.name = name;
        this.birthDay = birthDay;

    }

    public static void main(String[] args){
        Person me = new Person("Max", LocalDate.of(2002,10,1) );
        Person test = new Person("KalleKula",LocalDate.of(1999,10,4));
        System.out.println(me.getAge());

        System.out.println(me);
        System.out.println(test);
    }
    public int getAge(){
        return Period.between(birthDay, LocalDate.now()).getYears();
    }

    @Override public String toString() {
        return name + " " + getAge();
    }
}
