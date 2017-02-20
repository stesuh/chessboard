
class Bishop extends Node {
	
	public Bishop(char type, int row, int col) {
		super(type, row, col);
	}
	
	public int[][] setMove(int c, int r, int c2, int r2) {
		int[][] path = new int[10][10];
		
		if (c < c2 && r < r2) { //diagonals
			path = new int[Math.abs(c2-c)-1][2];
			for (int i=1; i<Math.abs(c2-c); i++) {
				path[i-1][0] = i;
				path[i-1][1] = i;
			}
		} else if (c > c2 && r < r2) { //diagonals
			path = new int[Math.abs(c2-c)-1][2];
			for (int i=1; i<Math.abs(c2-c); i++) {
				path[i-1][0] = -i;
				path[i-1][1] = i;
			}
		} else if (c > c2 && r > r2) { //diagonals
			path = new int[Math.abs(c2-c)-1][2];
			for (int i=1; i<Math.abs(c2-c); i++) {
				path[i-1][0] = -i;
				path[i-1][1] = -i;
			}
		} else if (c < c2 && r > r2) { //diagonals
			path = new int[Math.abs(c2-c)-1][2];
			for (int i=1; i<Math.abs(c2-c); i++) {
				path[i-1][0] = i;
				path[i-1][1] = -i;
			}
		}
		return path;
	}

	public boolean canAttack(Node from, Node to, int c2, int r2) {
		if (to != null) {
			if (checkColor(from.type, to.type)) {
				return false;
			}
		}
		for (int n=1; n < LinkedList.boardSize; n++) {
			if ((from.col-n) == c2 && (from.row-n) == r2) {
				return true;
			}
			if ((from.col-n) == c2 && (from.row+n) == r2) {
				return true;
			}
			if ((from.col+n) == c2 && (from.row+n) == r2) {
				return true;
			}
			if ((from.col+n) == c2 && (from.row-n) == r2) {
				return true;
			}
		}
		return false;
	}
}