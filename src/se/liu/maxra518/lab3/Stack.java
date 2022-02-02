package se.liu.maxra518.lab3;

import se.liu.maxra518.lab1.Person;

public class Stack extends ListManipulator
{


    public void push(Person person){
	elements.add(0, person);
    }

    public Person pop(){
	Person reVal = elements.get(0);		// Get first elem
	elements.remove(0);		// remove it
	return reVal;				// return it
    }

}
