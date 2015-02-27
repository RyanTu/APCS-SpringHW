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
	ArrayList<Integer> ans = new ArrayList<Integer>();
	ArrayList<Integer> halfA = new ArrayList<Integer>();
	ArrayList<Integer> halfB = new ArrayList<Integer>();
	int restSize = stuff.size() - stuff.size()/2;
	if (stuff.size() <= 1){
	    return stuff;
	}
	else {
	    //System.out.println(stuff.size());
	    for (int i = 0; i<stuff.size()/2; i++){
		halfA.add(stuff.remove(0));
		//System.out.print(halfA);
		//System.out.println(stuff);
	    }
	    System.out.println(stuff.size());
	    for (int i = 0; i<restSize; i++){
		halfB.add(stuff.remove(0));
		//System.out.print(halfB);
		//System.out.println(stuff);
	    }
	    ans = merge(mergeSort(halfA),mergeSort(halfB));
	}
	return ans;
    }

    public static void main(String[] args){
	MergeSort m = new MergeSort();
	Random r = new Random();
	ArrayList<Integer> data = new ArrayList<Integer>();
	//ArrayList<Integer> set1 = new ArrayList<Integer>();
	//ArrayList<Integer> set2 = new ArrayList<Integer>();
	for (int i = 0; i<8; i++){
	    data.add(r.nextInt(30));
	    //set1.add(r.nextInt(10) + (i*10));
	    //set2.add(r.nextInt(10) + (i*10));
	}
	//System.out.println(set1);
	//System.out.println(set2);
	//System.out.println(m.merge(set1,set2));
	System.out.println(data);
	System.out.println(m.mergeSort(data));
    }

}
