public class myStackA {

    private int[] s;
    private int len;

    public myStackA() {
	len = 0;
	s = new int[len];
    }

    public void push(int data){
	// add something to the top
	len++;
	int[] tmp = new int[len];
	tmp[0] = data;
	for (int i = 0; i<s.length; i++){
	    tmp[i+1] = s[i];
	}
	s = tmp;
    }

    public int pop(){
        // remove and return the top item from the stack
	int retval = s[0];
	len--;
	int[] tmp = new int[len];
	for (int i = 1; i<s.length; i++){
	    tmp[i-1] = s[i];
	}
	s = tmp;
	return retval;
    }

    public boolean empty(){
	return len == 0;
    }

    public int top() {
        // return the top item from the stack
	return s[0];
    }

    public String toString() {
	String ret = "[";
	for (int i = 0; i < s.length; i++) {
	    ret = ret + s[i] + ", ";
	}
	ret = ret + "]";
	return ret;
    }

    public static void main(String[] args) {
	myStackA a = new myStackA();
	System.out.println(a.empty());
	a.push(2);
	a.push(3);
	System.out.println(a.pop());
	a.push(4);
	a.push(5);
	System.out.println(a.empty());
	System.out.println(a);
	System.out.println(a.top());
    }
}
