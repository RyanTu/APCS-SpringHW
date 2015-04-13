public class Queue{
    Node first;
    Node last;
    int length;
    
    public Queue(){
	first = null;
	last = null;
    }

    public void enqueue(Node n){
	Node tmp = n;
	if(first != null){
	    last.setNext(tmp);
	} else {
	    first = tmp;	
	}
	
	last = tmp;
	length++;
    }

    public Node dequeue(){
	if(empty()){
	    return null;
	}
	Node data = first;
	first = first.getNext();
	length--;
	return data;
    }

    public boolean empty(){	
	return first == null;
    }

    public Node head(){
	if(empty()){
	    return null;
	}
	return first;
    }

    public String toString(){
	String s = "";
	Node tmp = first;
	for (int i = 0; i<length; i++){
	    s += tmp + " ";
	    tmp = tmp.getNext();
	}
	return s;
    }

    public static void main(String[] args) {
	Queue q = new Queue();
	/*
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);
	System.out.println(q);
	System.out.println(q.dequeue());
	System.out.println(q);
	System.out.println(q.empty());
	System.out.println(q.head());
	*/
    }
}
