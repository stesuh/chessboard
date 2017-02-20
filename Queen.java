
class Queen extends Node {

	//constructor
	public Queen(char type, int row, int col) {
		super(type, row, col);
	}

	public int[][] setMove(int c, int r, int c2, int r2) {
		int[][] path = new int[10][10];;
		if (c == c2) {
			path = new int[Math.abs(r2-r)-1][2];
			for (int i=1; i<Math.abs(r2-r); i++) {
				path[i-1][0] = 0;
				path[i-1][1] = (r2<r) ? -i: i;
				System.out.println(path[0][0]);
			}
		} else if (r == r2) {
			path = new int[Math.abs(c2-c)-1][2];
			for (int i=1; i<Math.abs(c2-c); i++) {
				path[i-1][0] = (c2<c) ? -i: i;
				path[i-1][1] = 0;
			}
		} else if (c < c2 && r < r2) { //diagonals
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
		if (from.col == c2 || from.row == r2) {
			if (from.col == c2 && from.row == r2) {
				return false;
			}
			return true;
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