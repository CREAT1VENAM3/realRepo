package pOnePackage;

public class Board implements Cloneable {
	Space[][] spaces;
	
	public Board () throws CloneNotSupportedException {
		int[] locationAssigner = {0,0};
		Space baseSpace = new Space(locationAssigner);
		this.spaces = new Space[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.spaces[i][j] = (Space)baseSpace.clone();
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				locationAssigner[0] = i; locationAssigner[1] = j;
				this.spaces[i][j].location = (int[])locationAssigner.clone();
			}
		}
	}
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	public void printSpaceInfo(int row, int column) {
		spaces[row][column].printStatus();
	}
	
	public void updateBoardSpaces(Player p1, Player p2) {
		for (int g = 0; g < 8; g++) {
			for (int h = 0; h < 8; h++) {
				for (int i = 0; i < p1.currentPieces.size(); i++) {
					if ((p1.currentPieces.get(i).location[0] == this.spaces[g][h].location[0]) && (p1.currentPieces.get(i).location[1] == this.spaces[g][h].location[1])) {
						this.spaces[g][h].status = 1;
						this.spaces[g][h].pieceContainedID = p1.currentPieces.get(i).pieceID;
					}
				}
				
				for (int i = 0; i < p2.currentPieces.size(); i++) {
					if ((p2.currentPieces.get(i).location[0] == this.spaces[g][h].location[0]) && (p2.currentPieces.get(i).location[1] == this.spaces[g][h].location[1])) {
						this.spaces[g][h].status = 2;
						this.spaces[g][h].pieceContainedID = p2.currentPieces.get(i).pieceID;
					}
				}
			}
		}
		return;
	}
}
