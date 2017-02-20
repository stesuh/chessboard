
class King extends Node {
	
	int[] colMoves = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
	int[] rowMoves = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
	
	public King(char type, int col, int row) {
		super(type, col, row);
	}
	
	public int[][] setMove(int c, int r, int c2, int r2) {
		int[][] path = new int[10][10];
		return path;
	}
	
	public boolean canAttack(Node from, Node to, int c2, int r2) {
		if (to != null) {
			if (checkColor(from.type, to.type)) {
				return false;
			}
		}
		for (int i=0; i<8; i++) {
			if (from.col+colMoves[i] == c2 && from.row+rowMoves[i] == r2) {
				return true;
			}
		}
		return false;
	}
	//no need to check path
}
