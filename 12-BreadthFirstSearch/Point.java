import java.io.*;
import java.util.*;
public class Point
{
    private int x;
    private int y;
    private boolean visited;
    public Point(int a, int b) {
	x = a;
	y = b;
	visited = true;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public boolean isVisited(){
	return visited;
    }

    public void visit(){
	visited = true;
    }

    public String toString() {
	return "[" + getX() + " , " + getY() + "]";
    }
}
