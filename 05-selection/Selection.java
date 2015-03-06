public class Selection{

    public int[] partition(int[] L, int start, int end){
	int[] D = new int[end-start+1];
	int pivot = L[start];
	int startD = 0;
	int endD = end-start;
        int i = start;
	while(startD != endD){
	    if (L[i] == pivot){
	    }
	    else if (L[i]<pivot){
		D[startD] = L[i];
		startD++;
	    }
	    else{
		D[endD] = L[i];
		endD--;
	    }
	    i++;
	}
	D[startD]=pivot;
	return D;
    }

    public static void main(String[] args){
	Selection s = new Selection();
	int[] data = {5,2,43,27,3,12,15,7,14,23,45,37,25,34,32,24};
	int[] ans = s.partition(data,0,data.length-1);
	for (int i = 0; i<ans.length; i++){
	    System.out.print(" " + ans[i]);
	}
	System.out.println();
    }
}
