import java.util.*;

public class Tree{

    private Node root;

    public Tree(Node n){
	root = n;
    }

    public Tree(){
	root = null;
    }
    
    public Node search (int i){
	Node ret = search(root,i);
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
	Node n = new Node(i);
	Node lead = root;
	if (root == null){
	    root = n;
	}
	else {
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

   public Node rsearch(Node t, int i){
	if (t==null || t.getData()==i){
	    return t;
	}
	else if (i<t.getData()){
	    return search(t.getLeft(),i);
	} else {
	    return search(t.getRight(),i);
	}
    }

    public String rsearch(int i){
	Node n = search(root,i);
	if (n==null){
	    return "NOT FOUND";
	}else{
	    return n.toString();
	}
    }


    public void rinsert(int i){
	rinsert(root,i);
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
    
    public String toString(){
	return root.getData() + traverse(root.getLeft()) + traverse(root.getRight());
    }

    public String traverse(Node t){
	if (t == null)
	    return " ";
	else
	    return t.getData() + " L:" + traverse(t.getLeft()) + " R:" + traverse(t.getRight());
    }
    
    public static void main(String[] args){
	Node tree = new Node(5);
	Tree t = new Tree(tree);
	Random r = new Random();
	for (int i = 0; i < 5; i++){
	    t.rinsert(r.nextInt(20));
	}
	System.out.println(t);
	System.out.println(t.rsearch(20));
	System.out.println(tree.getRight().getData());
    }
}


