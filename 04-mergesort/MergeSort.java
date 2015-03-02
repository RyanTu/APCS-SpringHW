import java.util.*;

public class MergeSort{

    ArrayList<Integer> list = new ArrayList<Integer>();

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
	//System.out.println(data);
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

    public static void main(String[] args){
	MergeSort m = new MergeSort();
	Random r = new Random();
	ArrayList<Integer> data = new ArrayList<Integer>();
	for (int i = 0; i<20; i++){
	    data.add(r.nextInt(30));
	}
	System.out.println(data);
	System.out.println(m.mergeSort(data));
    }

}
