package se.liu.maxra518.lab3;

import se.liu.maxra518.lab1.Person;

import java.time.LocalDate;

public class TestProg
{
    public static void main(String[] args) {
	Stack testStack = new Stack();
        Queue testQueue = new Queue();

        Person testPer1 = new Person("KalleKula", LocalDate.of(1999, 10, 4));
        Person testPer2 = new Person("Kalle", LocalDate.of(2002, 10, 4));
        Person testPer3 = new Person("Kula", LocalDate.of(2004, 1, 5));
        Person testPer4 = new Person("Dave", LocalDate.of(1965, 11, 8));
        Person testPer5 = new Person("Mike", LocalDate.of(2012, 7, 21));
        testStack.push(testPer1);
        testStack.push(testPer2);
        testStack.push(testPer3);
        testStack.push(testPer4);
        testStack.push(testPer5);
        testQueue.enqueue(testPer1);
        testQueue.enqueue(testPer2);
        testQueue.enqueue(testPer3);
        testQueue.enqueue(testPer4);
        testQueue.enqueue(testPer5);

        while(!testStack.isEmpty()){
            System.out.println(testStack.pop());

        }

        while(!testQueue.isEmpty()){
            System.out.println(testQueue.dequeue());
        }
    }

}
