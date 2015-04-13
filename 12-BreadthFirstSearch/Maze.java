import java.io.*;
import java.util.*;

public class Maze 
{
    private char[][] board;
    private int maxX;
    private int maxY;

    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;
		
    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }
		
    public Maze() 
    {
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];
				
	try {
						
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j=0;
	    while (sc.hasNext())
		{
		    String line = sc.nextLine();
		    for (int i=0;i<maxX;i++)
			{
			    board[i][j] = line.charAt(i);
			}
		    j++;
		}
	}
	catch (Exception e)
	    {
	    }
				
    }
		
    public String toString()
    {
	String s = "[2J\n";
				
	for (int y=0;y<maxY;y++)
	    {
		for (int x=0;x<maxX;x++)
		    s = s +board[x][y];
		s=s+"\n";
	    }
	return s;
    }

    /*
      solved - instance variable to indicate we're done
			
    */
    
    public void solve(int x, int y){

        Queue q = new Queue();	
	Queue qBack = new Queue();
	boolean done = false;
	if (q.empty()){
	    q.enqueue(new Node(board[x][y],x,y));
	}

	while(!q.empty()){
	    Node p = q.dequeue();
	    if (p.getData() == exit) {
		solved = true;
	    }

	    if (path == board[p.getX()+1][p.getY()] || exit == board[p.getX()+1][p.getY()]){
		q.enqueue(new Node(board[p.getX()+1][p.getY()],p.getX()+1,p.getY(),p));
	    }
	    if (path == board[p.getX()][p.getY()+1] || exit == board[p.getX()][p.getY()+1]){
		q.enqueue(new Node(board[p.getX()][p.getY()+1],p.getX(),p.getY()+1,p));
	    }
	    if (path == board[p.getX()-1][p.getY()] || exit == board[p.getX()-1][p.getY()]){
		q.enqueue(new Node(board[p.getX()-1][p.getY()],p.getX()-1,p.getY(),p));
	    }
	    if (path == board[p.getX()][p.getY()-1] || exit == board[p.getX()][p.getY()-1]){
		q.enqueue(new Node(board[p.getX()][p.getY()-1],p.getX(),p.getY()-1,p));
	    }	    
	    if (!solved){
		board[p.getX()][p.getY()]=visited;
	    } else {
		qBack.enqueue(p);
	        break;
	    }
	}
	int prevX;
	int prevY;
	while (!done){
	    Node point = qBack.dequeue();
	    if (point.getBefore() == null){
		done = true;
	    }
	    else {
		qBack.enqueue(point.getBefore());
	    }
	    prevX = point.getX();
	    prevY = point.getY();
	    board[prevX][prevY] = me;
	    System.out.println(this);
	}
    }
	
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.solve(1,1);
	System.out.println(m);
    }
}

