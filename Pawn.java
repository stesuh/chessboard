
class Pawn extends Node {
	
	int[] whiteColMoves = new int[]{1, -1};
	int[] whiteRowMoves = new int[]{1, 1};
	
	int[] blackColMoves = new int[]{1, -1};
	int[] blackRowMoves = new int[]{-1, -1};
	
	//int[] whiteColMoves = new int[]{0};
	//int[] whiteRowMoves = new int[]{1};
	//int[] blackColMoves = new int[]{0};
	//int[] blackRowMoves = new int[]{-1};
	
	public Pawn(char type, int row, int col) {
		super(type, row, col);
	}
	
	public int[][] setMove(int c, int r, int c2, int r2) {
		int[][] path = new int[10][10];
		return path;
	}
	
	//Pawn has special rule, so I just added its moving rule in this method along with attack.
	public boolean canAttack(Node from, Node to, int c2, int r2) {
		if (to != null) {
			if (checkColor(from.type, to.type)) {
				return false;
			}
		} else {
			if (from.type == 'p') {
				if (from.col == c2 && from.row+1 == r2) {
					return true;
				}
			} else if (from.type == 'P') {
				if (from.col == c2 && from.row-1 == r2) {
					return true;
				}
			}
		}
		if (from.type == 'p') {
			for (int i=0; i<2; i++) {
				if (from.col+whiteColMoves[i] == to.col && from.row+whiteRowMoves[i] == to.row) {
					return true;
				}
			}
		}
		if (from.type == 'P') {
			for (int i=0; i<2; i++) {
				if (from.col+blackColMoves[i] == to.col && from.row+blackRowMoves[i] == to.row) {
					return true;
				}
			}
		}
		return false;
	}
	//no need for block
}