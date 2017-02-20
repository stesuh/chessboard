class LinkedList {

	public static int boardSize;
	public int[][] path = new int[10][10];
	//private int check;

	public static boolean whiteCheck;
	public static boolean blackCheck;
	public static boolean whiteCheckmate;
	public static boolean blackCheckmate;

	Node head;

	LinkedList() {
		head = null;
	}

	void boardSize(int n) {
		boardSize = n;
	}
	
	void insert(char t, int c, int r) {
		if (t == 'k' || t == 'K') {
			addKing(t, c, r);
		}
		if (t == 'q' || t == 'Q') {
			addQueen(t, c, r);
		}
		if (t == 'r' || t == 'R') {
			addRook(t, c, r);
		}
		if (t == 'b' || t == 'B') {
			addBishop(t, c, r);
		}
		if (t == 'n' || t == 'N') {
			addKnight(t, c, r);
		}
		if (t == 'p' || t == 'P') {
			addPawn(t, c, r);
		}
	}
	
	void resetBooleans() {
		whiteCheck = false;
		whiteCheckmate = false;
		blackCheck = false;
		blackCheckmate = false;
	}
	
	public void identifyNode(Node node) {
		System.out.println(node.type + " " + node.col + " " + node.row);
	}

	public void addKing(char t, int c, int r) {
		if (head == null) {
			Node newNode = new King(t, c, r);
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new King(t, c, r);
		}
	}
	public void addQueen(char t, int c, int r) {
		if (head == null) {
			Node newNode = new Queen(t, c, r);
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Queen(t, c, r);
		}
	}
	public void addRook(char t, int c, int r) {
		if (head == null) {
			Node newNode = new Rook(t, c, r);
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Rook(t, c, r);
		}
	}
	public void addBishop(char t, int c, int r) {
		if (head == null) {
			Node newNode = new Bishop(t, c, r);
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Bishop(t, c, r);
		}
	}
	public void addKnight(char t, int c, int r) {
		if (head == null) {
			Node newNode = new Knight(t, c, r);
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Knight(t, c, r);
		}
	}
	public void addPawn(char t, int c, int r) {
		if (head == null) {
			Node newNode = new Pawn(t, c, r);
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Pawn(t, c, r);
		}
	}

	void delete(Node node) {
		Node temp = head;
		Node prev = null;

		while (temp != null) {
			prev = temp;
			temp = temp.next;

			if (temp == node) {
				prev.next = temp.next;
			}
		}
	}

	public boolean checkQuery(int c, int r, int c2, int r2) {
		Node temp = head;
		Node from = null;
		Node to = null;
		while (temp != null) {
			if (c == temp.col && r == temp.row) {
				from = temp;
			}
			if (c2 == temp.col && r2 == temp.row) {
				to = temp;
			}
			temp = temp.next;
		}
		return executeQuery(from, to, c2, r2);
	}

	public boolean checkNoBlock(Node from) {
		if (from.type == 'k' || from.type == 'n' || from.type == 'p' || from.type == 'K' || from.type == 'N' || from.type == 'P') {
			return true;
		}
		Node temp = head;
		int column, row;
		while (temp != null) {
			
			for (int i = 1; i < path.length+1; i++) {
				column = from.col + path[i-1][0];
				row = from.row + path[i-1][1];
				System.out.println(column + " " + row);
				if (temp.col == column && temp.row == row) {
					return false;
				}
			}
			temp = temp.next;
		}
		return true;
	}
	
	public int checkIntCheck(Node king, int check) {
		Node temp = head;
		
		while (temp != null) {
			if (temp.canAttack(temp, king, king.col, king.row)) {
				System.out.println("Dad I made it");
				if (temp.type != 'k' && temp.type != 'n' && temp.type != 'p' && temp.type != 'K' && temp.type != 'N' && temp.type != 'P') {
					System.out.println(temp.col - king.col);
					path = temp.setMove(temp.col, temp.row, king.col, king.row);
				} 
				if (checkNoBlock(temp)) {
					identifyNode(temp);
					System.out.println("fuck you bitch ass nigger");
					check++;
				}
			}
			if (temp.next == null && check == 0) {
				return 0;
			}
			identifyNode(temp);
			temp = temp.next;
		}
		System.out.println(check + "bitch assss");
		return check;
	}
	
	public boolean bodyBlock() {
		return false;
	}
	
	public boolean checkCheckmate(Node king, int check) {
		int[] colMoves = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
		int[] rowMoves = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
		check = 0;
		
		Node kingMove = new Node(king.type, king.col, king.row);
		
		//to record paths of pieces that put the king in check
		check = checkIntCheck(king, check);
		System.out.println(check + "fuck you coding");
		if (check > 0) {
			if (king.type == 'k') {
				whiteCheck = true;
			} else {
				blackCheck = true;
			}
			for (int i=0; i<8; i++) {
				check = 0;
				kingMove.col = king.col+colMoves[i];
				kingMove.row = king.row+rowMoves[i];
				identifyNode(kingMove);
				if (kingMove.col <= boardSize && kingMove.row <= boardSize && kingMove.col > 0 && kingMove.row > 0) {
					check = checkIntCheck(kingMove, check);
					System.out.println(check);
					if (check == 0) {
						System.out.println("Mad eit");
						break;
					} 
				}
				System.out.println(check);
				if (i == 7) {
					System.out.println("fuck you");
					return true;
				}
			}
			System.out.println(check);
			if (check == 0) {
				System.out.println("Nigga");
				return false;
			} else if (check > 0) {
				System.out.println("wtf?");
				return true;
			}
		} else if (king.type == 'k') {
			System.out.println("no white checkmate for u bitch");
			whiteCheck = false;
		} else {
			System.out.println("no checkmate for u bitch");
			blackCheck = false;
		}
		return false;
	}
		
		
	
	public void updatePosition(Node from, int c2, int r2) {
		from.col = c2;
		from.row = r2;
	}

	public void capture(Node to) {
		if (to == null) {
			return;
		} else {
			delete(to);
		}
	}
	
	public void executeCheckmate() {
		Node white = null;
		Node black = null;
		Node temp = head;
		int check = 0;
		resetBooleans();
		while (temp != null) {
			if (temp.type == 'k') {
				white = temp;
			}
			if (temp.type == 'K') {
				black = temp;
			}
			temp = temp.next;
		}		
		if (checkCheckmate(white, check)) {
			whiteCheckmate = true;
		} else {
			whiteCheckmate = false;
		}
		if (checkCheckmate(black, check)) {
			blackCheckmate = true;
		} else {
			blackCheckmate = false;
		}
		System.out.println(blackCheckmate);
	}
	
	
	public boolean executeQuery(Node from, Node to, int c2, int r2) {
		if (from == null) {
			return false;
		}
		if (to != null && to.type == 'k' || to != null && to.type == 'K') {
			return false;
			//put checkmate method here.
			/*
			if (from.canAttack(from, to, c2, r2)) {
				path = null;
				if (from.type != 'k' && from.type != 'n' && from.type != 'p' && from.type != 'K' && from.type != 'N' && from.type != 'P') {
					path = from.setMove(from.col, from.row, c2, r2);
				} 
				if (checkNoBlock(from)) {
					capture(to);
					updatePosition(from, c2, r2);
					return true;
				} else {
					return false;
				}
			}*/
		}
		if (from.canAttack(from, to, c2, r2)) {
			path = null;
			if (from.type != 'k' && from.type != 'n' && from.type != 'p' && from.type != 'K' && from.type != 'N' && from.type != 'P') {
				path = from.setMove(from.col, from.row, c2, r2);
			} 
			if (checkNoBlock(from)) {
				capture(to);
				updatePosition(from, c2, r2);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	public void printNodes() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.type + " " + temp.col + " " + temp.row);
			temp = temp.next;
		}
	}
}