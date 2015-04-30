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
	return traverse(root.getLeft()) + root.getData() + traverse(root.getRight());
    }

    public String traverse(Node t){
	if (t == null)
	    return " ";
	else
	    return traverse(t.getLeft()) + t.getData() + traverse(t.getRight());
    }

    public Node remove(int t){
	Node lead = root;
	Node follow = null;
	boolean wentLeft = true;
	if (t == lead.getData()){
	    if (lead.getLeft() == null && lead.getRight() == null){
		root = null;
	    }
	    else if (lead.getLeft() == null){
		root = lead.getRight();
	    }
	    else if (lead.getRight() == null){
		root = lead.getLeft();
	    }
	    else{
	        Node begin = lead.getLeft();
		Node beginFollow = lead;
		boolean movePointer = false;
		while (begin.getRight() != null){
		    beginFollow = lead;
		    begin = begin.getRight();
		    movePointer = true;
		}
		begin.setRight(lead.getRight());
		if (!movePointer)
		    beginFollow.setLeft(begin.getLeft());
		else 
		    beginFollow.setRight(begin.getLeft());
		begin.setLeft(lead.getLeft());
		root = begin;
	    }
	}
	else {
	    while (t != lead.getData() && (lead.getLeft() != null || lead.getRight() != null)){
		follow = lead;
		if (t > lead.getData()){
		    lead = lead.getRight();
		    wentLeft = false;
		} else {
		    lead = lead.getLeft();
		    wentLeft = true;
		}
	    }
	    if (lead.getData() != t){
		return null;
	    }
	    else {
		if (lead.getLeft() == null && lead.getRight() == null){
		    if (wentLeft) {
			follow.setLeft(null);
		    } else {				      
			follow.setRight(null);
		    }
		}
		else if (lead.getLeft() == null || lead.getRight() == null){
		    if (wentLeft) {
			if (lead.getLeft() == null){
			    follow.setLeft(lead.getRight());
			}
			else{
			    follow.setLeft(lead.getLeft());
			}
		    }
		    else{
			if (lead.getLeft() == null){
			    follow.setRight(lead.getRight());
			}
			else{
			    follow.setRight(lead.getLeft());
			}
		    }
		}
		else{
		    Node replaceFollow = lead;
		    Node replace = lead.getLeft();
		    while (replace.getRight() != null){
			replaceFollow = replace;
			replace = replace.getRight();
		    }
		    replace.setRight(lead.getRight());
		    replaceFollow.setRight(replace.getLeft());
		    if (replace.getLeft() != null)
			replace.setLeft(lead.getLeft());		
		    if (wentLeft){
			follow.setLeft(replace);
		    }
		    else{
			follow.setRight(replace);
		    }	    
		}
	    }
	}
	return lead;
    }
    
    public static void main(String[] args){
	Node tree = new Node(10);
	Tree t = new Tree(tree);
	System.out.println(t);
        t.insert(20);
	t.insert(5);
	t.insert(15);
	t.insert(30);
	t.insert(17);
	t.insert(25);
	t.insert(8);
	System.out.println(t);
	t.remove(17);
	System.out.println(t);
    }
}


