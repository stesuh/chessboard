
class Knight extends Node {
	
	int[] colMoves = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
	int[] rowMoves = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
	
	public Knight(char type, int row, int col) {
		super(type, row, col);
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
	//No need to check path
}