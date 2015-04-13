import java.util.*;

public class Stack{

    // You decide how the node(s) are declared
    private Node l;
    
    // make whatever constructor(s) you need    
    public Stack() {
	l = new Node();
    }
    
    public void push(Node data){
        // add something to the top
	Node tmp = data;
	tmp.setNext(l.getNext());
	l.setNext(tmp);	
    }
    
    public Node pop(){
        // remove and return the top item from the stack
	if (l.getNext() == null){
	    throw new EmptyStackException();
	}
	Node retval = l.getNext();
	l.setNext(l.getNext().getNext());
	return retval;
    }

    public boolean empty(){
	return l.getNext() == null;
    }

    public Node top() {
	if (empty()){
	    throw new EmptyStackException();
	}
	return l.getNext();
    }
    
    public String toString(){
	String s = "";
	Node tmp;;
	for (tmp=l.getNext() ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }
}
