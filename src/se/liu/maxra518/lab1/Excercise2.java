package se.liu.maxra518.lab1;

public class Excercise2
{
    public static void main(String[] args) {
	final int min = 10;
	final int max = 20;

	System.out.println(sumFor(min,max));
	System.out.println(sumWhile(min,max));


	
    }
    public static int sumFor(int min, int max) {
	int summa = 0;
	for(int i = min; i <= max;  i++){
	    summa += i;
	}
	return summa;
    }
    public static int sumWhile(int min, int max) {
	int summa = 0;
	int min_copy = min;

	while(min_copy <= max){

	    summa += min_copy;
	    min_copy++;
	}
	return summa;
    }
}
