class Node {
	int col;
	int row;
	char type;

	Node next;
	
	public Node() {
		this.next = null;
	}
	
	public Node(char t, int c, int r) {
		this.type = t;
		this.col = c;
		this.row = r;
	}
	public static boolean checkColor(char t, char t1) {
		int check = 0;
		int check1 = 0;
		if (t == 'k' || t == 'q' || t == 'r' || t == 'b' || t == 'n' || t == 'p') {
			check++;
		}
		if (t1 == 'K' || t1 == 'Q' || t1 == 'R' || t1 == 'B' || t1 == 'N' || t1 == 'P') {
			check1++;
		}
		if (check == check1) {
			return false;
		}
		return true;
	}
	
	public void setCol(int c) {
		this.col = c;
	}
	public void setRow(int r) {
		this.row = r;
	}
	
	public int[][] setMove(int c, int r, int c2, int r2) {
		int[][] path = new int[10][10];
		return path;
	}
	public boolean canAttack(Node node, Node node1, int c2, int r2) {
		//placer
		return false;
	}
}
