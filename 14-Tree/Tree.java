public class Tree{

    Node tree = new Node();

    public Node search(Node t, int i){
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

    public void insert(Node t, int i){
	Node n = new Node(i);
	if (t == null){
	    t = n;
	}
	Node lead = t;
	Node follow = null;
	while (lead != null){
	    follow = lead;
	    int c = i.compareTo(lead.getData());
	    if (c<0)
		lead = lead.getLeft();
	    else
		lead = lead.getRight();
	}
	if (i.compareTo(follow.getData())<0)
	    follow.setLeft(n);
	else
	    follow.setRight(n);
    }
    
}
