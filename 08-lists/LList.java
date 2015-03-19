public class LList{

    private Node l;
    private int len = 0;

    public LList(){
	l = new Node(0);
	len = 0;
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
    
    public int get(int n){
	Node tmp = l;
	int i = 0;
	while (i < n+1 && i < len){
	    tmp = tmp.getNext();
	    i++;
	}
	return tmp.getData();
    }   
        
    public void add(int s){
	Node tmp = new Node(s);
	tmp.setNext(l.getNext());
	l.setNext(tmp);
	len++;
    }

    public void add(int n, int s){
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

    public int remove(int n){
	Node before = null;
	Node tmp = l;
	if (n<=len){
	    for (int i = 0; i<=n ; i++){
		before = tmp;
		tmp = tmp.getNext();
	    }
	    before.setNext(tmp.getNext());
	    len--;
	    return tmp.getData();
	}
	return -1;
    }

    public boolean removeFirstOccur(int i){
	Node tmp = l;
	boolean removed = false;
	for (int n = 0; n < len && !removed; n++){
	    if (tmp.getNext().getData() == i){
		tmp.setNext(tmp.getNext().getNext());
		removed = true;
		len--;
	    }
	    else
		tmp = tmp.getNext();
	}
	return removed;
    }
}
