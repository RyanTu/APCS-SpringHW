public class Node {
    private Integer data;
    private Node parent,left,right;

    public Node(){
	data = null;
    }
    
    public Node(Integer d){
        data = d;
    }

    public Integer getData(){
	return data;
    }

    public void setData(Integer i){
	data = i;
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










