public class Driver {
    
    public int fact (int n){
    int ans = 0 ;
	if (n==0) return 1;
	else return n * fact(n-1);     
    }
    
    public int fibonacci(int n) {
	if (n==0) return 0; 
	else {

	    if (n<2) return 1;
	    else return fibonacci(n-1) + fibonacci (n-2);
	}
    }
    
    public int len(String s) {
	if (s.equals("")) return 0;
	else return 1 + len(s.substring(1));
    }
    
    public int numx (String s){
	if (s.equals("")) return 0;
	else if (s.substring(0,1).equals("x")) return 1+numx(s.substring(1));
	else return numx(s.substring(1));
    }

    public static void main (String args[]){
	Driver d = new Driver();
	System.out.println(d.fact(5));
	System.out.println(d.len("hello"));
	System.out.println(d.numx("   xasdxcx"));
    }
}
