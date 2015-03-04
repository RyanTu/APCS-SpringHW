import java.util.*;

public class ArrayMergeSort{

    public int[] merge(int[] a, int[] b){
	int[] data = new int[a.length + b.length];
	int aIndex = 0;
	int bIndex = 0;
	int dataIndex = 0;
	while (aIndex < a.length && bIndex < b.length){
	    if (a[aIndex] > b[bIndex]){
		data[dataIndex] = b[bIndex];
		bIndex++;
	    }
	    else{
		data[dataIndex] = a[aIndex];
		aIndex++;
	    }
	    dataIndex++;
	}
	while (aIndex < a.length){
	    data[dataIndex] = a[aIndex];
	    aIndex++;
	    dataIndex++;
	} 
	while (bIndex < b.length){
	    data[dataIndex] = b[bIndex];
	    bIndex++;
	    dataIndex++;
	}
	return data;
    }

    public int[] mergeSort(int[] stuff){
	if (stuff.length <= 1){
	    return stuff;
	}
	int[] halfA = new int[stuff.length/2];
	int[] halfB = new int[stuff.length - (stuff.length/2)];
	int i = 0;
	while (i<stuff.length/2){
	    halfA[i] = stuff[i];
	    i++;
	}
	for (int j = 0; i<stuff.length; j++){
	    halfB[j] = stuff[i];
	    i++;
	}
	return merge(mergeSort(halfA),mergeSort(halfB));
    }

    public static void main(String[] args){
	int[] data = new int[20];
	ArrayMergeSort m = new ArrayMergeSort();
	Random r = new Random();
	String stuff = "";
	for (int i = 0; i<20; i++){
	    data[i] = r.nextInt(30);
	    stuff += " " + data[i];
	}
        System.out.println(stuff);
	String ans = "";
	int[] merged = m.mergeSort(data);
	for (int i = 0; i<merged.length; i++){
	    ans += " " + merged[i];
	}
	System.out.println(ans);
    }

}
