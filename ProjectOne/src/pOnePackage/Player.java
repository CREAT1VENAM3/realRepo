package pOnePackage;
import java.util.ArrayList;

public class Player implements Cloneable{
	int playerID;
	ArrayList<Piece> currentPieces = new ArrayList<>();
	boolean inCheck;
	
	public Player(int p) throws CloneNotSupportedException {
		this.playerID = p;
		this.inCheck = false;
	}
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	public void updateAllPieces(Board b, Player p2) throws CloneNotSupportedException {
		for (int i = 0; i < this.currentPieces.size(); i++) {
			this.currentPieces.get(i).updateLegalMoves(b, this, p2);
		}
	}
	
	//checks in player is in check
	//(I have no idea if this actually works properly)
	public void updateCheck(Player p) {
		boolean kingFound = false;
		int a = 0;
		while (kingFound == false) {
			if (this.currentPieces.get(a).type.pieceTypeID == 5) {
				
				kingFound = true;
			}
			else {
				a++;
			}
		}
		for (int i = 0; i < p.currentPieces.size(); i++) {
			for (int j = 0; j < p.currentPieces.get(i).legalMoves.size(); j++) {
				if ((p.currentPieces.get(i).location[0] + p.currentPieces.get(i).legalMoves.get(j)[0] == this.currentPieces.get(a).location[0]) && (p.currentPieces.get(i).location[1] + p.currentPieces.get(i).legalMoves.get(j)[1] == this.currentPieces.get(a).location[1])) {
					this.inCheck = true;
					return;
				}
			}
		}
		this.inCheck = false;
		return;
	}
	
}
