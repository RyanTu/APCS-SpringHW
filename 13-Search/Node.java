public class Node {
    private int x,y,priority,step;
    private Node prev;
		
    public Node(int x, int y){
	this.x = x;
	this.y = y;
    }

    public Node getPrev() {
	return prev;
    }

    public void setPrev(Node n){
	prev = n;
    }
		
    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public int getPriority(){
	return priority;
    }

    public void setPriority(int n){
	priority = n;
    }

    public int getStep(){
	return step;
    }

    public void setStep(int n){
	step = n;
    }
		
}










