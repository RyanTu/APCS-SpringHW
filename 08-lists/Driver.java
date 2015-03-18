import java.util.*;
import java.io.*;
import java.lang.System;

public class Driver{
    public static void main(String[] args) {
	/*
	LList l = new LList();
	l.add("hello");
	l.add("world");
	for (int i=0;i<5;i++){
	    l.add(""+i);
	}
	System.out.println(l);
	*/

	Random r = new Random();
	int n = 10; // Controls number of elements
	
	ArrayList<Integer> data = new ArrayList<Integer>();
	for (int i = 0; i<n; i++){
	    data.add(r.nextInt(10));
	}
	int arrayListSum = 0;
	long t = System.currentTimeMillis();
	long startAL = t;
	for (int i = 0; i<n; i++){
	    arrayListSum += data.get(n);
	}
	long elapsedAL = t - startAL;

	LList data2 = new LList();
	for (int i = 0; i<n; i++){
	    data2.add(data.get(n));
	}
	int LListSum = 0;
	long startLL = t;
	for (int i = 0; i<n; i++){
	    LListSum += data2.get(n);
	}
	long elapsedLL = t - startLL;

	LinkedList data3 = new LinkedList();
	for (int i = 0; i<n; i++){
	    data3.add(data.get(n));
	}
	int LinkedSum = 0;
	long startBuiltIn = t;
	for (int i = 0; i<n-1; i++){
	    LinkedSum += (int)data3.get(n);
	}
	long elapsedBuiltIn = t - startBuiltIn;
    }
}
