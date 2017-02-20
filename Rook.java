
class Rook extends Node {
	
	public Rook(char type, int row, int col) {
		super(type, row, col);
	}
	
	public int[][] setMove(int c, int r, int c2, int r2) {
		int[][] path = new int[10][10];
		
		if (c == c2) {
			path = new int[Math.abs(r2-r)-1][2];
			for (int i=1; i<Math.abs(r2-r); i++) {
				path[i-1][0] = 0;
				path[i-1][1] = (r2<r) ? -i: i;
			}
		} else if (r == r2) {
			path = new int[Math.abs(c2-c)-1][2];
			for (int i=1; i<Math.abs(c2-c); i++) {
				path[i-1][0] = (c2<c) ? -i: i;
				path[i-1][1] = 0;
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
		return false;
	}
}