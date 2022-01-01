package pOnePackage;
import java.util.ArrayList;
import java.lang.Math;


public class PieceType {
	String name;
	int pieceTypeID;
	//pawn - 0
	//knight - 1
	//bishop - 2
	//rook - 3
	//queen - 4
	//king - 5
	
	ArrayList<int[]> potentialMoves = new ArrayList<int[]>();
	
	public PieceType(String n, int pType) {
		this.name = n;
		this.pieceTypeID = pType;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public boolean isMoveLinear (int m) {
		if ((this.potentialMoves.get(m)[0] == 0) || (this.potentialMoves.get(m)[1] == 0)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//dear fucking lord what a mess of a function
	//tests if a move is blocked from a location based on piece
	public boolean isMoveBlocked (Board b, int i, int[] l) {
		if((Math.abs(l[0]) > 1) || (Math.abs(l[1]) > 1)) { 
			if (this.pieceTypeID != 1) {
			if (this.isMoveLinear(i)) {
				//horizontal movement
				if (this.potentialMoves.get(i)[0] == 0) {
					if (this.potentialMoves.get(i)[1] < 0) {
						for (int j = -1; j > this.potentialMoves.get(i)[1]; j--) {
							int x = l[0];
							int y = l[1] + j;
							if (b.spaces[x][y].status != 0) {
								return true;
							}
						}
					}
					else {
						for (int j = 1; j < this.potentialMoves.get(i)[1]; j++) {
							int x = l[0];
							int y = l[1] + j;
							if (b.spaces[x][y].status != 0) {
								return true;
							}
						}
					}
					
					return false;
					
				}
				//vertical movement
				else {
					if (this.potentialMoves.get(i)[0] < 0) {
						for (int j = -1; j > this.potentialMoves.get(i)[0]; j--) {
							int x = l[0] + j;
							int y = l[1];
							if (b.spaces[x][y].status != 0) {
								return true;
							}
						}
					}
					else {
						for (int j = 1; j < this.potentialMoves.get(i)[0]; j++) {
							int x = l[0] + j;
							int y = l[1];
							if (b.spaces[x][y].status != 0) {
								return true;
							}
						}
					}
					return false;
				}
			}
			
			//diagonal movement
			else {
				if (this.potentialMoves.get(i)[0] > 0) {
					for (int j = 1; j < this.potentialMoves.get(i)[0]; j++) {
						int x = l[0] + j;
						int y;
						if (this.potentialMoves.get(i)[1] > 0) {
							y = l[1] + j;
						}
						else {
							y = l[1] - j;
						}
						if (b.spaces[x][y].status != 0) {
							return true;
						}
					}
				}
				else if (this.potentialMoves.get(i)[0] < 0) {
					for (int j = -1; j > this.potentialMoves.get(i)[0]; j--) {
						int x = l[0] + j;
						int y;
						if (this.potentialMoves.get(i)[1] > 0) {
							y = l[1] - j;
						}
						else {
							y = l[1] + j;
						}
						if (b.spaces[x][y].status != 0) {
							return true;
						}
					}
				}
				return false;
			}
		}
		else {
			return false;
		}
		}
		else {
			return false;
		}
		
	}
	
	
	//Checks if a move will result in illegally moving the player into check
	//p1 is player moving piece
	public boolean movingIntoCheck(Piece p, Board b, Player playerOne, Player playerTwo, int pieceIndex, int[] l) throws CloneNotSupportedException {
		Board hBoard = new Board();
		Player p1 = new Player(0);
		Player p2 = new Player(0);
		hBoard = (Board)b.clone();
		p1 = (Player)playerOne.clone();
		p2 = (Player)playerTwo.clone();
		
		p1.currentPieces.get(pieceIndex).movePiece(l, hBoard, p1, p2);
		p1.updateCheck(p2);
		if (p1.inCheck == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//checks to see if a player is moving out of check (to be used when a player is in check and must move out)
	//very similar to movingIntoCheck, p1 is player moving piece
	public boolean movingOutOfCheck(Piece p, Board b, Player playerOne, Player playerTwo, int pieceIndex, int[] l) throws CloneNotSupportedException {
		Board hBoard = new Board();
		Player p1 = new Player(0);
		Player p2 = new Player(0);
		hBoard = (Board)b.clone();
		p1 = (Player)playerOne.clone();
		p2 = (Player)playerTwo.clone();
		
		p1.currentPieces.get(pieceIndex).movePiece(l, hBoard, p1, p2);
		p1.updateCheck(p2);
		if (p1.inCheck == false) {
			return true;
		}
		else {
			return false;
		}
	}
}
