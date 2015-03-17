public class LList{

    private Node l;
    private int len = 0;

    public LList(){
	l = new Node("dummy");
	len = 1;
    }
		
    public String toString(){
	String s = "";
	Node tmp;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }
    
    public String find(int n){
	Node tmp = l;
	int i = 0;
	while (i < n+1 && i < len){
	    tmp = tmp.getNext();
	    i++;
	}
	return tmp.getData();
    }   
        
    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len++;
    }

    public void add(int n, String s){
	Node tmp = new Node(s);
	Node after = l;
	if (n == 0){
	    tmp.setNext(l);
	    l = tmp;
	}
	else {
	    for (int i = 0; i<n-1; i++){
		after = after.getNext();
	    }
	    tmp.setNext(after.getNext());
	    after.setNext(tmp);
	}
    }
}
