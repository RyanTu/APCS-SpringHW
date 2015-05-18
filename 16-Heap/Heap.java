import java.util.*;

public class Heap{

    private ArrayList<Integer> heap;
    private int root;
    private int last;

    public Heap(int t){
	heap = new ArrayList<Integer>();
	heap.add(t);
	root = heap.get(0);
	last = 0;
    }

    public void insert(int i){
	heap.add(i);
	last++;
	int index = last;
	while(index-1 >= 0 && heap.get((index-1)/2) > i){ 
	    int temp = heap.get((index-1)/2);
	    heap.set((index-1/2),i);
	    heap.set(last,temp);
	    index = (index-1)/2;
	}
    }

    public String toString(){
	String s = "";
	for (int i = 0; i<heap.size(); i++){
	    s += heap.get(i) + " ";
	}
	return s;
    }
    
    public static void main(String[] args){
	Heap h = new Heap(5);
	h.insert(6);
	System.out.println(h);
    }
    
}
