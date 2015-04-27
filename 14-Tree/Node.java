public class Node {
    private Integer data;
    private Node parent,left,right;

    public Node(Integer d){
	data = d;
	left = null;
	right = null;
    }
    
    public Node(){
        data = null;
    }

    public Integer getData(){
	return data;
    }

    public void setData(Integer i){
	data = i;
    }
    
    public Node getParent() {
	return parent;
    }

    public void setParent(Node n){
	parent = n;
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

    public String toString() {
	return ""+data;
    }
}










