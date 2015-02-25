public class makeLake {
    private int[] pasture1 = {28,25,20,32,34,36};
    private int[] pasture2 = {27,25,20,20,30,34};
    private int[] pasture3 = {24,20,20,20,20,30};
    private int[] pasture4 = {20,20,14,14,20,20};
    private int[][] lake = new int[4][6];
    private int elevation = 22;
    
    
    public makeLake() {
	for (int i = 0; i < 4; i++) {
	    for (int n = 0; n < 6; n++) {
		if (i == 0) lake[i][n] = pasture1[n];
		if (i == 1) lake[i][n] = pasture2[n];
		if (i == 2) lake[i][n] = pasture3[n];
		if (i == 3) lake[i][n] = pasture4[n];
	    }
	}
    }

    public String toString() {
	String s = "";
	for (int i = 0; i < 4; i++) {
	    for (int n = 0; n < 6; n++) {
		s = s + lake[i][n] + ", ";
	    }
	    s = s + "\n";
	}
	return s;
    }

    public void stomp(int r, int c, int d) {
	int max = 0;
	for (int i = r - 1; i < r + 2; i++) {
	    for (int n = c -1; n < c + 2; n++) {
		if (lake[i][n] > max) {
		    max = lake[i][n];
		}
	    }
	}
	max = max - d;;
	for (int i = r - 1; i < r + 2; i++) {
	    for (int n = c - 1; n < c + 2; n++) {
		if (lake[i][n] > max) {
		    lake[i][n] = max;
		}
	    }
	}
    }

    public int volume() {
	int totalDepth = 0;
	for (int i = 0; i < 4; i++) {
	    for (int n = 0; n < 6; n++) {
		lake[i][n] = elevation - lake[i][n];
		if (lake[i][n] >=0){
		    totalDepth+=lake[i][n];
		}
	    }
	}
	return totalDepth * 72 * 72;
    }

    public static void main(String[] args) {
	makeLake m = new makeLake();
	m.stomp(1, 4, 4);
	m.stomp(1, 1, 10);
	System.out.println(m.volume());
	System.out.println(m);
    }
}
