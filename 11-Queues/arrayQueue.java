public class arrayQueue{
    int[] q;
    int length;
    
    public arrayQueue(){
	length = 0;
        q = new int[length];
    }

    public void enqueue(int data){
	length++;
	int[] tmp = new int[length];
	for (int i = 0; i<q.length; i++){
	    tmp[i] = q[i];
	}
	tmp[length-1] = data;
	q = tmp;
    }

    public int dequeue(){
	if(empty()){
	    return 0;
	}
	length--;
        int ret = q[0];
	for (int i = 0; i<q.length-1; i++){
	    q[i] = q[i+1];
	}
	return ret;
    }

    public boolean empty(){	
	return length == 0;
    }

    public int head(){
	if(empty()){
	    return 0;
	}
	return q[length-1];
    }

    public String toString(){
	String s = "";	
	for (int i = 0; i<length; i++){
	    s += q[i] + " ";
	}
	return s;
    }
    
    public static void main(String[] args){
        arrayQueue q = new arrayQueue();
	System.out.println(q);
	System.out.println(q.dequeue());
	q.enqueue(7);
	System.out.println(q);
	q.enqueue(3);
	System.out.println(q);
	q.enqueue(4);
	System.out.println(q);
	System.out.println(q.empty());
	System.out.println(q.head());
	q.dequeue();
	System.out.println(q);
	System.out.println(q.head());
    }
}
