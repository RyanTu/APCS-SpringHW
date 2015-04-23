public class Tree{

    Node tree = new Node();

    public Node search(Node t, Integer i){
	while (t != null){
	    int c = t.getData().compareTo(i);
	    if (c>0)
		t = t.getRight();
	    else if (c<0)
		t = t.getLeft();
	    else
		return t;
	}
	return null;
    }

    public void insert(Node n)
    
}
