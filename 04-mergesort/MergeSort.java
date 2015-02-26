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

    public static void main(String[] args){
	MergeSort m = new MergeSort();
	Random r = new Random();
	ArrayList<Integer> set1 = new ArrayList<Integer>();
	ArrayList<Integer> set2 = new ArrayList<Integer>();
	for (int i = 0; i<5; i++){
	    set1.add(r.nextInt(10) + (i*10));
	    set2.add(r.nextInt(10) + (i*10));
	}
	System.out.println(set1);
	System.out.println(set2);
	System.out.println(m.merge(set1,set2));
    }

}
