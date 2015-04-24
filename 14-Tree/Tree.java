public class Tree{

    public Node search(Node t, int i){
	while (t.getData() != null){
	    int c = i-t.getData();
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
	if (t.getData() == null){
	    t.setData(i);
	}
	else {
	    Node lead = t;
	    Node follow = null;
	    while (lead != null){
		follow = lead;
		int c = i-lead.getData();
		if (c<0)
		    lead = lead.getLeft();
		else
		    lead = lead.getRight();
	    }
	    if (i-follow.getData()<0)
		follow.setLeft(n);
	    else
		follow.setRight(n);
	}
    }

    //public Node rsearch(Node n, int i){
	
    //}

    public static void main(String[] args){
	Tree t = new Tree();
	Node tree = new Node();
	t.insert(tree,20);
	t.search(tree,20);
	System.out.println(tree.getData());
    }
}


