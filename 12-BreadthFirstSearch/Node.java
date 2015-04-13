public class Node{

    private char data;    
    private int xcor;
    private int ycor;
    private Node before;
    private Node next;

    public Node(){
	before = null;
	next = null;
    }

    public Node(char d, int x, int y){
	data = d;
        xcor = x;
	ycor = y;
	before = null;
	next = null;
    }
    public Node(char d, int x, int y, Node prev){
	data = d;
        xcor = x;
	ycor = y;
	before = prev;
	next = null;
    }

    public void setData(int x, int y){
        xcor = x;
	ycor = y;
    }

    public int getX(){
	return xcor;
    }

    public int getY() {
	return ycor;
    }

    public char getData(){
	return data;
    }

    public void setBefore(Node n){
	before = n;
    }

    public Node getBefore(){
	return before;
    }

    public void setNext(Node n){
	next = n;
   }

    public Node getNext(){
	return next;
    }

    public String toString(){
	return "[" + xcor + ", " + ycor + "]";
    }
}
