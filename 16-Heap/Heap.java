import java.util.*;

public class Heap{

    private ArrayList<Integer> heap;

    public Heap(int t){
	heap = new ArrayList<Integer>();
	heap.add(t);
    }

    public int removeMin(){
	heap.set(0,heap.get(heap.size()-1));
	int ret = heap.remove(heap.size()-1);
	pushDown(0);
	return ret;
    }

    public void insert(int n){
	heap.add(n);
	siftUp(heap.size()-1);
    }

    public void pushDown(int i){
	int value = heap.get(i);
	int index = i;
	int leftIndex = ((i+1)*2)-1;
	int rightIndex = (i+1)*2;
	while ((heap.size()>(index+1)*2)&&(heap.get(i)>heap.get(leftIndex) || heap.get(i)>heap.get(rightIndex))){
	    if (heap.get(leftIndex) < heap.get(rightIndex)){
		heap.set(index,heap.get(leftIndex));
		heap.set(leftIndex,value);
		index = leftIndex;
	    }
	    else {
		heap.set(index,heap.get(rightIndex));
		heap.set(rightIndex,value);
		index = rightIndex;
	    }
	    leftIndex = ((i+1)*2)-1;
	    rightIndex = (i+1)*2;
	}
    }

    public void siftUp(int i){
	int value = heap.get(i);
	int index = i;
	while(index-1 >= 0 && heap.get((index-1)/2) > value){ 
	    int temp = heap.get((index-1)/2);
	    heap.set((index-1)/2,value);
	    heap.set(index,temp);
	    index = (index-1)/2;
	}
    }

    public void heapSort(){
	heapSort(heap);
    }

    public void heapSort(ArrayList<Integer> data){
	for (int i = data.size()-1; i > 0; i--){
	    pushDown(i);
	}
    }

    public String toString(){
	return heap + "";
    }
    
    public static void main(String[] args){
	Heap h = new Heap(5);
	h.insert(3);
	h.insert(4);
	h.insert(6);
	h.insert(2);
	h.insert(15);
	h.insert(30);
	h.insert(13);
	System.out.println(h);
	h.removeMin();
	System.out.println(h);
	h.heapSort();
	System.out.println(h);
    }
    
}
