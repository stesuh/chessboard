import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChessBoard {

	public static BufferedWriter out;
	
	public static void printCheckmate() {
		try {
			if (LinkedList.whiteCheckmate) {
				out.write("White checkmated ");
			} else if (LinkedList.blackCheckmate) {
				out.write("Black checkmated ");
			} 
			if (!LinkedList.whiteCheckmate && !LinkedList.blackCheckmate && LinkedList.whiteCheck) {
				out.write("White in check ");
			} 
			if (!LinkedList.whiteCheckmate && !LinkedList.blackCheckmate && LinkedList.blackCheck) {
				out.write("Black in check ");
			} else if (!LinkedList.whiteCheck && !LinkedList.blackCheck){
				out.write("All kings safe ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printValidity(int n) {
		try {
			if (n == 0) {
				out.write("Valid ");
			}
			if (n == 1) {
				out.write("Invalid ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws IOException {
		try {
			out = new BufferedWriter(new FileWriter("analysis.txt"));
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			String line;
			int countLine = 0;
			LinkedList linkedlist = new LinkedList();
			while ((line = br.readLine()) != null) {
				String[] read = line.split(" ");
				if ((countLine % 2)==0) {
					linkedlist = new LinkedList();
					linkedlist.boardSize(Integer.parseInt(read[0]));
					for (int i=1; i < read.length; i+=3) {
						linkedlist.insert(read[i].charAt(0), Integer.parseInt(read[i+1]), Integer.parseInt(read[i+2]));
					}
					linkedlist.executeCheckmate();
					//System.out.println(LinkedList.whiteCheck + " " + LinkedList.whiteCheckmate + " " + LinkedList.blackCheck + " " + LinkedList.blackCheckmate);
				} else {
					int[] query = new int[read.length];
					for (int i=0; i < read.length; i+=2) {
						query[i] = Integer.parseInt(read[i]);
						query[i+1] = Integer.parseInt(read[i+1]);
					}
					for (int i=0; i<read.length; i+=4) {
						if (!linkedlist.checkQuery(query[i], query[i+1], query[i+2], query[i+3])) {
							printValidity(1);
							break;
						} else {
							printValidity(0);
						}
						
					}
					out.write("\n");
					printCheckmate();
					out.write("\n");
				}
				++countLine;
			}
			out.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
