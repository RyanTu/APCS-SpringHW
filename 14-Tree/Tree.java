public class Tree{

    private Node data;

    public Tree(Node n){
	data = n;
    }

    public Tree(){
	data = null;
    }

    public Node search (int i){
	Node ret = search(data,i);
	return ret;
    }

    public Node search(Node t, int i){
	Node n = t;
	while (n != null){
	    int c = n.getData().compareTo(i);
	    if (c>0)
		n = n.getLeft();
	    else if (c<0)
		n = n.getRight();
	    else
		return n;
	}
	return null;
    }

    public void insert(int i){
	insert(data,i);
    }

    public void insert(Node t, int i){
	Node n = new Node(i);
	if (t == null){
	    t = n;
	}
	else {
	    Node lead = t;
	    Node follow = null;
	    while (lead != null){
		follow = lead;
		if (lead.getData()>i)
		    lead = lead.getLeft();
		else
		    lead = lead.getRight();
	    }
	    if (i<follow.getData())
		follow.setLeft(n);
	    else
		follow.setRight(n);
	}
    }

    public Node rsearch(int i){
	Node ret = rsearch(data,i);
	return ret;
    }

    public Node rsearch(Node t, int i){
	if (t == null){
	    return null;
	}
	else {
	    if (i < t.getData()){
		t = t.getLeft();
		rsearch(t,i);
	    }
	    else if (i > t.getData()){
		t = t.getRight();
		rsearch(t,i);
	    }
	    else {}
	}
	return t;
    }

    public void rinsert(int i){
	rinsert(data,i);
    }

    public void rinsert(Node t, int i){
	Node n = new Node(i);
	if (t == null){
	    t = n;
	}
	else {
	    if (i < t.getData()){
		if (t.getLeft() == null){
		    t.setLeft(n);
		    return;
		}
		else{
		    t = t.getLeft();
		}
	    }
	    else {
		if (t.getRight() == null){
		    t.setRight(n);
		    return;
		}
		else{
		    t = t.getRight();
		}
	    }
	}
	rinsert(t,i);
    }

    public static void main(String[] args){
	Node tree = new Node(5);
	Tree t = new Tree(tree);
	t.rinsert(20);
	System.out.println(t.rsearch(20));
	System.out.println(tree.getData());
    }
}


