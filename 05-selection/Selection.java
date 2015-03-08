public class Selection{

    public int select(int[] A, int k, int l, int h){
	int lowIndex = l;
	int highIndex = h-1;
	int pivot = A[l];
	int pivotIndex = 0;
	A[l] = A[h];
	A[h] = pivot;
        while (lowIndex < highIndex){
	    if (A[lowIndex] < pivot){
		lowIndex++;
	    }
	    else {
		int temp = A[lowIndex];
		A[lowIndex] = A[highIndex];
		A[highIndex] = temp;
		highIndex--;
	    }
	}
	if (A[lowIndex] < pivot){
	    A[h] = A[lowIndex+1];
	    A[lowIndex+1] = pivot;
	    pivotIndex = lowIndex+1;
	}
	else {
	    A[h] = A[lowIndex];
	    A[lowIndex] = pivot;
	    pivotIndex = lowIndex;
	}
	if (pivotIndex > k){
	    select(A,k,l,pivotIndex-1);
	}
        if (pivotIndex < k){
	    select(A,k,pivotIndex+1,h);
	}
	return A[k];
    }

    public static void main(String[] args){
	Selection s = new Selection();
	int[] data = {4,7,2,9,3,1,2,1,5,6,8};
        System.out.println(s.select(data,3,0,data.length-1));
    }
}
