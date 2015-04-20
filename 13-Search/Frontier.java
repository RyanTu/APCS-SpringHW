import java.util.*;

public class Frontier {
    public LinkedList<Node> l = new LinkedList<Node>();

    public void add(Node n){
	int index = 0;
	boolean lowCheck = false;
	if (isEmpty()){
	    l.add(n);
	}
	for (Node tmp = l.getFirst(); !lowCheck; tmp = l.get(index)){
	    if (tmp.getPriority()<n.getPriority()){
		index++;
	    }
	    else {
		lowCheck = !lowCheck;
	    }
	}
	l.add(index,n);
    }

    public Node remove() {
	return l.remove(0);
    }

    public boolean isEmpty(){
	return l.isEmpty();
    }
}










