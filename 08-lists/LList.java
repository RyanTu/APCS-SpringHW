public class LList{

    private Node l;
    private int len = 0;

    public LList(){
	l = new Node("");
	len = 0;
    }
		
    public String toString(){
	String s = "";
	Node tmp;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	//s = s + "null";
	return s;
    }
    
    public String get(int n){
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
	if (n<=len){
	    Node tmp = new Node(s);
	    Node after = l;
	    int i = 0;
	    while (i<n && i<=len){
		after = after.getNext();
		i++;
	    }
	    tmp.setNext(after.getNext());
	    after.setNext(tmp);
	    len++;
	}
    }

    public Node remove(int n){
	Node before = null;
	Node tmp = l;
	if (n<=len){
	    for (int i = 0; i<=n ; i++){
		before = tmp;
		tmp = tmp.getNext();
	    }
	    before.setNext(tmp.getNext());
	    len--;
	    return tmp;
	}
	return null;
    }
}
