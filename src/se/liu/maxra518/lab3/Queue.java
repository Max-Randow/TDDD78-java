package se.liu.maxra518.lab3;

import se.liu.maxra518.lab1.Person;

import java.util.Iterator;

public class Queue extends ListManipulator
{




    public void enqueue(Person person){
	elements.add(person);
    }

    public Person dequeue(){
	Person reVal = elements.get(0);		// Get first elem
	elements.remove(0);		// remove it
	return reVal;				// return it
    }

}
