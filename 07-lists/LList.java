public class LList{

    private Node l = null;

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
    }

    public String find(int n){
	Node tmp = l;
	for (int i = 0; i < n; i++){
	    tmp = tmp.getNext();
	}
	return tmp.getData();
    }
		
    public String toString(){
	String s = "";
	Node tmp;;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

    public void insertAfter(int n, String s){
	Node stuff = l;
	for (int i = 0; i<n; i++){
	    stuff = stuff.getNext();
	}
	Node tmp = new Node(s);
	tmp.setNext(stuff.getNext());
	stuff.setNext(tmp);
    }

    public void insertBefore(int n, String s){
	Node stuff = l;
	Node tmp = new Node(s);
	if (n == 0){
	    tmp.setNext(stuff);
	    l = tmp;
	}
	else {
	    for (int i = 0; i<n-1; i++){
		stuff = stuff.getNext();
	    }
	    tmp.setNext(stuff.getNext());
	    stuff.setNext(tmp);
	}
    }
}
