package pOnePackage;
import java.util.ArrayList;

public class Piece implements Cloneable{
	String name;
	PieceType type;
	int[] location;
	int side;
	boolean hasMoved;
	boolean underAttack;
	//0 = white
	//1 = black
	
	ArrayList<int[]> legalMoves = new ArrayList<int[]>();
	
	int pieceID;
	
	public Piece (String name1, PieceType type1) {
		this.name = name1;
		this.type = type1;
		this.hasMoved = false;
		this.underAttack = false;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//p1 is player moving
	public void updateLegalMoves(Board board, Player p1, Player p2) throws CloneNotSupportedException {
		this.legalMoves.clear();
		for (int i = 0; i < this.type.potentialMoves.size(); i++) {
			if (((this.location[0] + this.type.potentialMoves.get(i)[0] >= 0) && (this.location[0] + this.type.potentialMoves.get(i)[0] < 8)) && ((this.location[1] + this.type.potentialMoves.get(i)[1] >= 0) && (this.location[1] + this.type.potentialMoves.get(i)[1] < 8))) {
				System.out.println("Passed inbounds test");
				int j = this.location[0] + this.type.potentialMoves.get(i)[0];
				int k = this.location[1] + this.type.potentialMoves.get(i)[1];
				if (board.spaces[j][k].status != this.side + 1) {
					System.out.println("Passed not taking allied space test");
					if (this.type.isMoveBlocked(board, i, location) == false) {
						System.out.println("Passed is move blocked test");
						int t = 0;
						boolean thisPieceFound = false;
						while (thisPieceFound == false) {
							if ((p1.currentPieces.get(t).location[0] == this.location[0]) && (p1.currentPieces.get(t).location[1] == this.location[1])) {
								thisPieceFound = true;
							}
							t++;
						}
						if (this.type.movingIntoCheck(this, board, p1, p2, t, this.location) == false) {
							System.out.println("Passed moving into check test");
							if(this.type.movingOutOfCheck(this, board, p1, p2, t, location) == true) {
								System.out.println("Passed moving out of check test");
								this.legalMoves.add(this.type.potentialMoves.get(i));
							}
						}
					}
				}
			}
		}
	}
	
	public void printPieceStatus() {
		System.out.println("Location: " + this.location[0] + ", " + this.location[1]);
		if (this.side == 0) {
			System.out.println("Side: White");
		}
		else {
			System.out.println("Side: Black");
		}
		System.out.println("Piece type: " + this.type.name);
		System.out.println("Possible moves for piece type: " + this.type.potentialMoves.size());
		System.out.println("Current legal moves for this piece: " + this.legalMoves.size());
		System.out.println("");
	}
	
	public void printCurrentLegalMoves() {
		for (int i = 0; i < this.legalMoves.size(); i++) {
			System.out.println("Move " + i + ": " + this.legalMoves.get(i)[0] + " " + this.legalMoves.get(i)[1]);
		}
		System.out.println("");
	}
	
	public boolean underAttack(Player p) {
		for (int i = 0; i < p.currentPieces.size(); i++) {
			for (int j = 0; j < p.currentPieces.get(i).legalMoves.size(); j++) {
				if ((p.currentPieces.get(i).legalMoves.get(j)[0] == this.location[0]) && (p.currentPieces.get(i).legalMoves.get(j)[1] == this.location[1])) {
					return true;
				}
			}
		}
		return false;
	}
	
	//moves a piece, capturing any enemy piece on destination. Updates board and player piece lists accordingly
	public void movePiece(int[] m, Board b, Player p1, Player p2) {
		if (p1.playerID == 0) {
			int[] destination = {0,0};
			destination[0] = this.location[0] + m[0];
			destination[1] = this.location[1] + m[1];
			for (int i = 0; i < p2.currentPieces.size(); i++) {
				if ((p2.currentPieces.get(i).location[0] == destination[0]) && (p2.currentPieces.get(i).location[1] == destination[1])) {
					p2.currentPieces.remove(i);
				}
			}
			this.location[0] = destination[0];
			this.location[1] = destination[1];
			b.updateBoardSpaces(p1, p2);
			return;
		}
		else {
			int[] destination = {0,0};
			destination[0] = this.location[0] + m[0];
			destination[1] = this.location[1] + m[1];
			for (int i = 0; i < p2.currentPieces.size(); i++) {
				if ((p2.currentPieces.get(i).location[0] == destination[0]) && (p2.currentPieces.get(i).location[1] == destination[1])) {
					p2.currentPieces.remove(i);
				}
			}
			this.location[0] = destination[0];
			this.location[1] = destination[1];
			b.updateBoardSpaces(p2, p1);
			return;
		}
	}
	
}
