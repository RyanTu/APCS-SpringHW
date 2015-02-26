import java.util.*;

public class MergeSort{

    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Integer> blank = new ArrayList<Integer>();

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

    public ArrayList<Integer> half(ArrayList<Integer> data){
	ArrayList<Integer> half = new ArrayList<Integer>();
	int cut = data.size()/2;
	for (int i = 0; i<cut; i++){
	    half.add(data.remove(0));
	}
	return half;
    }

    public ArrayList<Integer> mergeSort(ArrayList<Integer> data, boolean split){
	ArrayList<Integer> result = new ArrayList<Integer>();
	if (data.size() <= 1){
	    merge(data,blank);
	} else if (!split) {
	    mergeSort(half(data, false));
	    mergeSort(data, false);
	} else {
	    
	}
	return result;
    }

    public static void main(String[] args){
	ArrayList<Integer> data = new ArrayList<Integer>();
	//ArrayList<Integer> set1 = new ArrayList<Integer>();
	//ArrayList<Integer> set2 = new ArrayList<Integer>();
	for (int i = 0; i<20; i++){
	    data.add(r.nextInt(30));
	    //set1.add(r.nextInt(10) + (i*10));
	    //set2.add(r.nextInt(10) + (i*10));
	}
	MergeSort m = new MergeSort();
	Random r = new Random();
	//System.out.println(set1);
	//System.out.println(set2);
	//System.out.println(m.merge(set1,set2));
	System.out.println(m.mergeSort(data));
    }

}
