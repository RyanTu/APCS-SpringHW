import java.util.*;
import java.io.*;
import java.lang.System;

public class Driver2{

    public static void main(String[] args){
	
	Random r = new Random();
	int n = 100000; // Controls number of elements
	
	// ArrayList
	ArrayList<Integer> data = new ArrayList<Integer>();
	for (int i = 0; i<n; i++){
	    data.add(r.nextInt(10));
	}
	int arrayListSum = 0;
	long t = System.currentTimeMillis();
	long startAL = System.currentTimeMillis();
	for (int i = 0; i<data.size(); i++){
	    arrayListSum += data.get(i);
	}
	long elapsedAL = System.currentTimeMillis() - startAL;

	System.out.println(arrayListSum);
	System.out.println(elapsedAL);

	System.out.println();
	
	// LList
	LList data2 = new LList();
	for (int i = 0; i<n; i++){
	    data2.add(data.get(i));
	}
	int LListSum = 0;
	long startLL = System.currentTimeMillis();
	for (int i = 0; i<n; i++){
	    LListSum += data2.get(i);
	}
	long elapsedLL = System.currentTimeMillis() - startLL;

	System.out.println(LListSum);
	System.out.println(elapsedLL);

	System.out.println();

	// LinkedList
	LinkedList<Integer> data3 = new LinkedList<Integer>();
	for (int i = 0; i<n; i++){
	    data3.add(data.get(i));
	}
	int LinkedSum = 0;
	long startBuiltIn = System.currentTimeMillis();
	for (int i = 0; i<n; i++){
	    LinkedSum += data3.get(i);
	}
	long elapsedBuiltIn = System.currentTimeMillis() - startBuiltIn;

	System.out.println(LinkedSum);
	System.out.println(elapsedBuiltIn);
	
    }

}
