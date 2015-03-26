import java.util.*;

public class myStack<E>{

    // You decide how the node(s) are declared
    private Node<E> l;
    
    // make whatever constructor(s) you need    
    public myStack() {
	l = new Node<E>();
    }
    
    public void push(E data){
        // add something to the top
	Node<E> tmp = new Node<E>(data);
	tmp.setNext(l.getNext());
	l.setNext(tmp);	
    }
    
    public E pop(){
        // remove and return the top item from the stack
	if (l.getNext() == null){
	    throw new EmptyStackException();
	}
	E retval = l.getNext().getData();
	l.setNext(l.getNext().getNext());
	return retval;
    }

    public boolean empty(){
	return l.getNext() == null;
    }

    public E top() {
	if (empty()){
	    throw new EmptyStackException();
	}
	return l.getNext().getData();
    }
    
    public String toString(){
	String s = "";
	Node<E> tmp;;
	for (tmp=l.getNext() ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }
    
    public static void main(String[] args) {
	myStack<Integer> s = new myStack<Integer>();
	s.push(4);
	s.push(3);
	System.out.println(s);
	System.out.println(s.pop());
	s.push(15);
	System.out.println(s);
	System.out.println(s.empty());
	System.out.println(s.pop());
	System.out.println(s.empty());
	for (int i = 0; i<5; i++){
	    s.push(i);
	}
	System.out.println(s.top());
	System.out.println(s);
    }
}
