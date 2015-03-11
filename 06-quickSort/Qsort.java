import java.util.*;
import java.io.*;

public class Qsort{
    private int[] a,b;
    Random rnd = new Random();

    public Qsort(){
        this(20);
    }

    public Qsort(int n){
        Random r = new Random();
        a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }
    }

    public String toString(){
        return Arrays.toString(a);
    }

    public int partition(int[] a, int l, int r) {
        int tmp;
        //int pivotIndex = l+rnd.nextInt(r-l);
        int pivotIndex=l;
        int pivot = a[pivotIndex];
        tmp = a[r];
        a[r] = a[pivotIndex];
        a[pivotIndex]=tmp;

        int wall=l;
        int pcount=1;
        for (int i=l;i<r;i++) {
            if (a[i]<pivot) {
                tmp = a[i];
                a[i]=a[wall];
                a[wall]=tmp;
                wall++;
            }
            if (a[i]==pivot)
                pcount++;
        }
        // now copy over all the pivots
        int rwall=wall;
        tmp = a[rwall];
        a[wall]=a[r];
        a[r]=tmp;
        rwall++;
        for (int i=rwall+1;i<=r;i++) {
            if (a[i]==pivot) {
                tmp = a[rwall];
                a[rwall]=a[i];
                a[i]=tmp;
                rwall++;
            }
        }
        return (wall+rwall)/2;
    }

    public void qsort(int[] a, int l, int h){
        if (l<h){
	    int pi = partition(a,l,h);
	    qsort(a,pi+1,h);
	    qsort(a,l,pi-1);
	}
    }

    public void sort(){
        qsort(a,0,a.length-1);
    }

    public static void main(String[] args) {
        Qsort q = new Qsort();
        System.out.println(q);
	/*
        for (int i=0;i<5;i++) {
            System.out.print(q.sort(i)+" ");
        }
        System.out.println();
	*/
        q.sort();
        System.out.println(q);
    }
}
