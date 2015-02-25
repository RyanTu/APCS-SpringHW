import java.util.Random;

public class Knights{

    private int[][] board;
    private int size;
    private int me = 0;
    private boolean solved = false;
    private int startX;
    private int startY;
    
    public Knights(int n){
	size = n;
	board = new int[size+4][size+4];
	for (int y=0; y<board.length; y++){
	    for (int x=0; x<board[y].length; x++){
		if ((y<2||y>=board.length-2)||(x<2||x>=board[y].length-2)){
		    board[x][y]=-1;
		}
		else
		    board[x][y]=0;
	    }
	}
    }

    public Knights(){
	this(5);
    }

    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }

    public String toString(){
	String s = "[2J\n";
	for (int y=0; y<board.length; y++){
	    for (int x=0; x<board[y].length; x++){
		if ((x>1 && x<board[y].length-2)&&(y>1 && y<board.length-2))
		s += String.format("%3d", board[x][y]);
	    }
	    s += "\n";
	}
	return s;
    }

    public void solve(int x, int y){
	startX = x+1;
	startY = y+1;
	solveHelper(x+1,y+1);
	errorCheck(x,y);
    }
    
    public void solveHelper(int x, int y){
	if (board[x][y]!=0){
	    return;
	}
	if (board[x][y]==0){
	    me+=1;
	    board[x][y]=me;
	}
	if (me==size*size){
	    solved = true;
	}
	//delay(1000);
	//System.out.print(this);
	solveHelper(x+1,y-2);
	solveHelper(x+2,y-1);
	solveHelper(x+2,y+1);
	solveHelper(x+1,y+2);
	solveHelper(x-1,y+2);
	solveHelper(x-2,y+1);
	solveHelper(x-2,y-1);
	solveHelper(x-1,y-2);
	if (!solved){
	    me--;
	    board[x][y]=0;
	}
    }

    public void errorCheck(int x, int y){
	if (board[startX][startY]==0){
	    System.out.println("No solution at (" + x + "," + y + ")");
	}
    }
    
    public static void main(String[] args){
	int n = 8;
	Knights k = new Knights(n);
	Random r = new Random();
	int x = r.nextInt(n)+1;
	int y = r.nextInt(n)+1;
	k.solve(x,y);
	System.out.print(k);
    }
}
