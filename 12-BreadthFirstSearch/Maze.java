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

        Queue<Integer> qX = new Queue<Integer>();
        Queue<Integer> qY = new Queue<Integer>();
        Queue<Integer> solveX = new Queue<Integer>();
        Queue<Integer> solveY = new Queue<Integer>();	

	if (qX.empty()){
	    qX.enqueue(x);
	    qY.enqueue(y);
	}

	while(!qX.empty()){
	    int currentX = qX.dequeue();
	    int currentY = qY.dequeue();
	    if (exit == board[currentX+1][currentY]){
		solveX.enqueue(currentX+1);
		solveY.enqueue(currentY);
		board[currentX][currentY]=visited;
	        return;
	    }
	    if (exit == board[currentX][currentY+1]){
		solveX.enqueue(currentX);
		solveY.enqueue(currentY+1);
		board[currentX][currentY]=visited;
		return;
	    }
	    if (exit == board[currentX-1][currentY]){
		solveX.enqueue(currentX-1);
		solveY.enqueue(currentY);
		board[currentX][currentY]=visited;
		return;
	    }
	    if (exit == board[currentX][currentY-1]){
		solveX.enqueue(currentX);
		solveY.enqueue(currentY-1);
		board[currentX][currentY]=visited;
		return;
	    }  

	    if (path == board[currentX+1][currentY]){
		qX.enqueue(currentX+1);
		qY.enqueue(currentY);
	    }
	    if (path == board[currentX][currentY+1]){
		qX.enqueue(currentX);
		qY.enqueue(currentY+1);
	    }
	    if (path == board[currentX-1][currentY]){
		qX.enqueue(currentX-1);
		qY.enqueue(currentY);
	    }
	    if (path == board[currentX][currentY-1]){
		qX.enqueue(currentX);
		qY.enqueue(currentY-1);
	    }	   
	    if (!solved){
		board[currentX][currentY]=visited;
	    }
	}
    }
	
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.solve(1,1);
	System.out.println(m);
    }
}

