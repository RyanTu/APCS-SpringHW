public class Knights{

    int[][] board;
    
    public Knights(int n){
	board = new int[n+4][n+4];
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

    /*
    public void canIPrint(){
	for (int y=0; y<board.length; y++){
	    for (int x=0; x<board[y].length; x++){
		System.out.printf("%2d", board[x][y]);
	    }
	    System.out.println();
	}
    }
    */

    public void 
    
    public static void main(String[] args){
	Knights k = new Knights();
    }
}
