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
    
    /*
    public void insertAfter(int n, String s){
	Node after = l;
	for (int i = 0; i<n-1; i++){
	    after = after.getNext();
	    System.out.print(after);
	    System.out.println(after.getNext());
	}
	Node tmp = new Node(s);
	tmp.setNext(after.getNext());
        after.setNext(tmp);
    }
    */

    public void insert(int n, String s){
	Node tmp = new Node(s);
	Node after = l;
	if (n == 0){
	    tmp.setNext(l);
	    l = tmp;
	}
	else {
	    try {
		for (int i = 0; i<n-1; i++){
		    after = after.getNext();
		}
		tmp.setNext(after.getNext());
		after.setNext(tmp);
	    }
	    catch (NullPointerException e) {
		System.out.println("Try a different index");
	    }
	}
    }
}
