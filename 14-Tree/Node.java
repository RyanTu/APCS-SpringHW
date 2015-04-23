public class Node {
    private int data;
    private Node parent,left,right;
		
    public Node(int d){
        data = d;
    }

    public int getData(){
	return data;
    }

    public void setParent(Node n){
	parent = n;
    }
	
    public Node getParent() {
	return parent;
    }

    public Node getLeft(){
	return left;
    }

    public void setLeft(Node n){
	left = n;
    }

    public Node getRight(){
	return right;
    }

    public void setRight(Node n){
	right = n;
    }
		
}










