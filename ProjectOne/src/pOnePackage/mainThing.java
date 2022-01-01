package pOnePackage;

public class mainThing implements Cloneable{

	public static void main(String[] args)
			throws CloneNotSupportedException
	{
		//building empty board
		Board newBoard = new Board();
		
		//building pawn type
		PieceType pawnType = new PieceType("Pawn", 0);
		
		int[] bokSnell = {1,0};
		pawnType.potentialMoves.add((int[])bokSnell.clone());
		
		
		//building knight type
		PieceType knightType = new PieceType("Knight", 1);
		
		bokSnell[0] = 2; bokSnell[1] = 1;
		knightType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = 1; bokSnell[1] = 2;
		knightType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = -2; bokSnell[1] = 1;
		knightType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = -1; bokSnell[1] = 2;
		knightType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = 2; bokSnell[1] = -1;
		knightType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = 1; bokSnell[1] = -2;
		knightType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = -2; bokSnell[1] = -1;
		knightType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = -1; bokSnell[1] = -2;
		knightType.potentialMoves.add((int[])bokSnell.clone());
		
		
		//building bishop type
		PieceType bishopType = new PieceType("Bishop", 2);
		
		for (int i = 1; i < 8; i++) {
			bokSnell[0] = i; bokSnell[1] = i;
			bishopType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = i; bokSnell[1] = -i;
			bishopType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = -i; bokSnell[1] = -i;
			bishopType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = -i; bokSnell[1] = i;
			bishopType.potentialMoves.add((int[])bokSnell.clone());
		}
		
		
		//building rook type
		
		PieceType rookType = new PieceType("Rook", 3);
		
		for (int i = 1; i < 7; i++) {
			bokSnell[0] = i; bokSnell[1] = 0;
			rookType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = -i; bokSnell[1] = 0;
			rookType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = 0; bokSnell[1] = i;
			rookType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = 0; bokSnell[1] = -i;
			rookType.potentialMoves.add((int[])bokSnell.clone());
		}
		
		
		//building queen type
		
		PieceType queenType = new PieceType("Queen", 4);
		
		for (int i = 1; i < 7; i++) {
			//straight line moves
			bokSnell[0] = i; bokSnell[1] = 0;
			queenType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = -i; bokSnell[1] = 0;
			queenType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = 0; bokSnell[1] = i;
			queenType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = 0; bokSnell[1] = -i;
			queenType.potentialMoves.add((int[])bokSnell.clone());
			
			//diagonal moves
			bokSnell[0] = i; bokSnell[1] = i;
			queenType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = i; bokSnell[1] = -i;
			queenType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = -i; bokSnell[1] = -i;
			queenType.potentialMoves.add((int[])bokSnell.clone());
			
			bokSnell[0] = -i; bokSnell[1] = i;
			queenType.potentialMoves.add((int[])bokSnell.clone());
		}
		
		
		//building king type
		
		PieceType kingType = new PieceType("King", 5);
		
		//straight moves
		bokSnell[0] = 1; bokSnell[1] = 0;
		kingType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = -1; bokSnell[1] = 0;
		kingType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = 0; bokSnell[1] = 1;
		kingType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = 0; bokSnell[1] = -1;
		kingType.potentialMoves.add((int[])bokSnell.clone());
		
		//diagonal moves
		bokSnell[0] = 1; bokSnell[1] = 1;
		kingType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = 1; bokSnell[1] = -1;
		kingType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = -1; bokSnell[1] = -1;
		kingType.potentialMoves.add((int[])bokSnell.clone());
		
		bokSnell[0] = -1; bokSnell[1] = 1;
		kingType.potentialMoves.add((int[])bokSnell.clone());
		
		
		//creating players
		
		Player playerOne = new Player(0);
		Player playerTwo = new Player(1);
		
		
		//creating and placing starting pieces for players
		bokSnell[0] = 0; bokSnell[1] = 0;
		Piece basePawn = new Piece("basePawn", pawnType);
		for (int i = 0; i < 8; i++) {
			basePawn.side = 0;
			basePawn.pieceID = i;
			bokSnell[0] = 1; bokSnell[1] = i;
			basePawn.location = (int[])bokSnell.clone();
			playerOne.currentPieces.add((Piece)basePawn.clone());
			basePawn.side = 1;
			bokSnell[0] = 6; bokSnell[1] = i;
			basePawn.location = (int[])bokSnell.clone();
			playerTwo.currentPieces.add((Piece)basePawn.clone());
		}
		
		Piece baseKnight = new Piece("baseKnight", knightType);
		for (int i = 0; i < 2; i++) {
			baseKnight.side = 0;
			baseKnight.pieceID = i + 8;
			bokSnell[0] = 0;
			if (i == 0) {
				bokSnell[1] = 1;
			}
			else {
				bokSnell[1] = 6;
			}
			baseKnight.location = (int[])bokSnell.clone();
			playerOne.currentPieces.add((Piece)baseKnight.clone());
			baseKnight.side = 1;
			bokSnell[0] = 7;
			if (i == 0) {
				bokSnell[1] = 1;
			}
			else {
				bokSnell[1] = 6;
			}
			baseKnight.location = (int[])bokSnell.clone();
			playerTwo.currentPieces.add((Piece)baseKnight.clone());
		}
		
		Piece baseBishop = new Piece("baseBishop", bishopType); 
		for (int i = 0; i < 2; i++) {
			baseBishop.side = 0;
			baseBishop.pieceID = i + 10;
			bokSnell[0] = 0;
			if (i == 0) {
				bokSnell[1] = 2;
			}
			else {
				bokSnell[1] = 5;
			}
			baseBishop.location = (int[])bokSnell.clone();
			playerOne.currentPieces.add((Piece)baseBishop.clone());
			baseBishop.side = 1;
			bokSnell[0] = 0;
			if (i == 0) {
				bokSnell[1] = 2;
			}
			else {
				bokSnell[1] = 5;
			}
			baseBishop.location = (int[])bokSnell.clone();
			playerTwo.currentPieces.add((Piece)baseBishop.clone());
		}
		
		Piece baseRook = new Piece("baseRook", rookType);
		for (int i = 0; i < 2; i++) {
			baseRook.side = 0;
			baseRook.pieceID = i + 12;
			bokSnell[0] = 0;
			if (i == 0) {
				bokSnell[1] = 0;
			}
			else {
				bokSnell[1] = 7;
			}
			baseRook.location = (int[])bokSnell.clone();
			playerOne.currentPieces.add((Piece)baseRook.clone());
			baseRook.side = 1;
			bokSnell[0] = 0;
			if (i == 0) {
				bokSnell[1] = 0;
			}
			else {
				bokSnell[1] = 7;
			}
			baseRook.location = (int[])bokSnell.clone();
			playerTwo.currentPieces.add((Piece)baseRook.clone());
		}
		
		Piece baseQueen = new Piece("baseQueen", queenType);
		baseQueen.side = 0;
		baseQueen.pieceID = 14;
		bokSnell[0] = 0; bokSnell[1] = 3;
		baseQueen.location = (int[])bokSnell.clone();
		playerOne.currentPieces.add((Piece)baseQueen.clone());
		baseQueen.side = 1;
		baseQueen.pieceID = 15;
		bokSnell[0] = 7;
		baseQueen.location = (int[])bokSnell.clone();
		playerTwo.currentPieces.add((Piece)baseQueen.clone());
		
		Piece baseKing = new Piece("baseKing", kingType);
		baseKing.side = 0;
		baseKing.pieceID = 16;
		bokSnell[0] = 0; bokSnell[1] = 4;
		baseKing.location = (int[])bokSnell.clone();
		playerOne.currentPieces.add((Piece)baseKing.clone());
		baseKing.side = 1;
		baseKing.pieceID = 17;
		bokSnell[0] = 7;
		baseKing.location = (int[])bokSnell.clone();
		playerTwo.currentPieces.add((Piece)baseKing.clone());
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 8; j++) {
				newBoard.spaces[i][j].status = 1;
			}
		}
		for (int i = 6; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				newBoard.spaces[i][j].status = 2;
			}
		}
		
		
		for (int i = 0; i < playerOne.currentPieces.size(); i++) {
			bokSnell = playerOne.currentPieces.get(i).location;
			newBoard.spaces[bokSnell[0]][bokSnell[1]].pieceContainedID = playerOne.currentPieces.get(i).pieceID;
		}
		for (int i = 0; i < playerTwo.currentPieces.size(); i++) {
			bokSnell = playerTwo.currentPieces.get(i).location;
			newBoard.spaces[bokSnell[0]][bokSnell[1]].pieceContainedID = playerTwo.currentPieces.get(i).pieceID;
		}
		
		newBoard.updateBoardSpaces(playerOne, playerTwo);
		
		playerOne.updateAllPieces(newBoard, playerTwo);
		playerOne.currentPieces.get(5).printPieceStatus();
		playerOne.currentPieces.get(5).printCurrentLegalMoves();
		playerOne.currentPieces.get(5).movePiece(playerOne.currentPieces.get(5).type.potentialMoves.get(0), newBoard, playerOne, playerTwo);
		playerOne.currentPieces.get(5).printPieceStatus();
		
		//WHAT IS LEFT
		//create game and turns (probably will result in copying and pasting a lot of code from mainThing to game) - 4
		//win condition (subset of game creation) - 5
		//create function to test is player is in check - 1 -- ACTUALLY DOESNT NEED TO BE DONE
		//modify legal moves to prevent moving into check (most likely requires setting up another board to test hypothetical scenario) - 2 -- DONE (I THINK)
		//modify legal moves to require moving out of check when necessary (tethered to previous task) - 3 
		//add ways for players to interact/make moves (thethered to game creation) - 6
		//add visual representation of board and pieces - 7
		//NOT NECESSARILY IN THAT ORDER
	}

}
