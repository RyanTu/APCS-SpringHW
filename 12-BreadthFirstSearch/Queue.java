public class Queue<E>{
    Node<E> first;
    Node<E> last;
    int length;
    
    public Queue(){
	first = null;
	last = null;
    }

    public void enqueue(E data){
	Node<E> tmp = new Node<E>(data);
	if(first != null){
	    last.setNext(tmp);
	} else {
	    first = tmp;	
	}
	
	last = tmp;
	length++;
    }

    public E dequeue(){
	if(empty()){
	    return null;
	}
	E data = first.getData();
	first = first.getNext();
	length--;
	return data;
    }

    public boolean empty(){	
	return first == null;
    }

    public E head(){
	if(empty()){
	    return null;
	}
	return first.getData();
    }

    public String toString(){
	String s = "";
	Node<E> tmp = first;
	for (int i = 0; i<length; i++){
	    s += tmp + " ";
	    tmp = tmp.getNext();
	}
	return s;
    }

    public static void main(String[] args) {
	Queue q = new Queue();
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);
	System.out.println(q);
	System.out.println(q.dequeue());
	System.out.println(q);
	System.out.println(q.empty());
	System.out.println(q.head());
    }
}
