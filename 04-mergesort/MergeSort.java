import java.util.*;

public class MergeSort{

    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
	ArrayList<Integer> data = new ArrayList<Integer>();
	while (a.size()>0 || b.size()>0){
	    if (a.size()>0 && b.size()>0){
		if (a.get(0)>b.get(0)){
		    data.add(b.remove(0));
		}
		else {
		    data.add(a.remove(0));
		}
	    } else if (a.size()==0){
		data.add(b.remove(0));
	    } else {
		data.add(a.remove(0));
	    }
	}
	return data;
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> stuff){
	ArrayList<Integer> halfA = new ArrayList<Integer>();
	ArrayList<Integer> halfB = new ArrayList<Integer>();
	if (stuff.size() <= 1){
	    return stuff;
	}
	else {
	    int len = stuff.size();
	    for (int i = 0; i<len/2; i++){
		halfA.add(stuff.remove(0));
	    }
	    for (int i = 0; i<stuff.size(); ){
		halfB.add(stuff.remove(0));
	    }
	}
	return merge(mergeSort(halfA),mergeSort(halfB));
    }

    /*
    public int[] arrayMerge(int[] a, int[] b){
	int[] data = new int[a.length + b.length];
	int aLength = a.length;
	int bLength = b.length;
	int index = 0;
	while (aLength > 0 || bLength > 0){
	    if (aLength>0 && bLength>0){
		if (a[0]>b[0]){
		    data[index] = b[b.length-bLength];
		    bLength--;
		}
		else {
		    data[index] = a[a.length-aLength];
		    aLength--;
		}
	    } else if (aLength==0){
		data[index] = b[b.length-bLength];
		bLength--;
	    } else {
		data[index] = a[a.length-aLength];
		aLength--;
	    }
	    index++;
	}
	return data;
    }

    public int[] arrayMergeSort(int[] stuff){
	int len = stuff.length;
        int[] halfA = new int[len/2];
	int[] halfB = new int[len-(len/2)];
	if (stuff.length <= 1){
	    return stuff;
	}
	else {
	    for (int i = 0; i<len/2; i++){
		halfA[i] = stuff[i];
	    }
	    for (int i = 0; i<len-(len/2); i++){
		halfB[i] = stuff[i+len-(len/2)-1];
	    }
	}
	return arrayMerge(arrayMergeSort(halfA),arrayMergeSort(halfB));
    }
    */

    public static void main(String[] args){
	ArrayList<Integer> data = new ArrayList<Integer>();
	//int[] arrayData = new int[20];
	MergeSort m = new MergeSort();
	Random r = new Random();
	for (int i = 0; i<20; i++){
	    int n = r.nextInt(30);
	    data.add(n);
	    //arrayData[i] = n;
	}
	System.out.println(data);
	System.out.println(m.mergeSort(data));
	/*
	int[] ans = m.arrayMergeSort(arrayData);
	String s = "[";
	for (int i = 0; i<ans.length; i++){
	    if (i == 0){
		s += ans[i] + ",";
	    }
	    else if (i == ans.length-1){
		s += " " + ans[i];
	    }
	    else {
		s += " " + ans[i] + ",";
	    }
	}
	s += "]";
        System.out.println(s);
	*/
    }
}
