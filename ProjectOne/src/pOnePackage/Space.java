package pOnePackage;

public class Space implements Cloneable{
	int status;
	//0 = empty
	//1 = white piece
	//2 = black piece
	
	int pieceContainedID;
	//reference to piece in player list of pieces
	
	int[] location;
	
	public Space (int[] l) {
		this.location = l;
		this.status = 0;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void printStatus() {
		System.out.println("Row: " + this.location[0]);
		System.out.println("Column: " + this.location[1]);
		
		if (this.status == 0) {
			System.out.println("Status: Empty");
		}
		else if (this.status == 1) {
			System.out.println("Status: White Piece");
		}
		else if (this.status == 2) {
			System.out.println("Status: Black Piece");
		}
		return;
	}
	
	public void updateStatus(Player p1, Player p2) {
		for (int i = 0; i < p1.currentPieces.size(); i++) {
			if ((p1.currentPieces.get(i).location[0] == location[0])&&(p1.currentPieces.get(i).location[1] == location[1])) {
				status = 1;
				return;
			}
			else if ((p2.currentPieces.get(i).location[0] == location[0])&&(p2.currentPieces.get(i).location[1] == location[1])) {
				status = 2;
				return;
			}
		}
		return;
	}
	
	//returns whether a space has a piece on it or not
	public boolean isEmpty() {
		if (this.status != 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
