package connect4;

/**
 * The logic behind the Connect 4 game containing all of the rules 
 * the game follows.
 * 
 * @author Jake Miller
 * @version 4/12/2018
 */
public class GameLogic {
	
	/** The game board. */
	private Cell[][] board;
	
	/** The number of players.  */
	private int players;
	
	/** The current player. */
	private int cPlayer;
	
	/**
	 * 
	 * Default constructor setting up the board as a 7x6 2D array
	 * and sets the current player to 1.
	 *
	 */
	public GameLogic() {
		board = new Cell[7][6];
		cPlayer = 1;
	}
	
	/**
	 * 
	 * Constructor setting setting up the board as a 7x6 2D array
	 * and sets the current player to 1. 
	 * 
	 * @param players The number of players.
	 */
	public GameLogic(final int players) {
		board = new Cell[7][6];
		this.players = players;
		cPlayer = 1;
	}
	
	/**
	 * 
	 * Gets the Cell object.
	 * 
	 * @param r The row.
	 * @param c The column.
	 * @return Cell.
	 */
	public Cell getCell(final int r, final int c) {
		return board[r][c];
	}
	
	/**
	 * 
	 * Gets the players.
	 *
	 * @return players.
	 */
	public int getPlayers() {
		return players;
	}
	
	/**
	 * 
	 * Resets the board.
	 *
	 */
	public void reset() {
		for (int r = 0; r < 7; r++) {
			for (int c = 0; c < 6; c++) {
				board[r][c] = null;
			}
		}
	}
	
	/**
	 * 
	 * Logic to check if the player wins by having 4 cells in a row.
	 *
	 * @param player The player to check for a win for.
	 * @return boolean.
	 */
	public boolean checkWin(final int player) {

	    // horizontalCheck 
	    for (int j = 0; j < 6 - 3; j++) {
	        for (int i = 0; i < 7; i++) {
	        	if (this.board[i][j] != null && this.board[i][j + 1] 
	        			!= null && this.board[i][j + 2] != null 
	        			&& this.board[i][j + 3] != null) {
	        		if (this.board[i][j].getPlayer() == player 
	        				&& this.board[i][j + 1]
	        				.getPlayer() == player 
	        				&& this.board[i][j + 2]
	        				.getPlayer() == player 
	        				&& this.board[i][j + 3]
	        				.getPlayer() == player) {
	        			return true;
	        		}           
	        	}
	        }
	    }
	    // verticalCheck
	    for (int i = 0; i < 7 - 3; i++) {
	        for (int j = 0; j < 6; j++) {
	        	if (this.board[i][j] != null && this.board[i + 1][j] 
	        			!= null && this.board[i + 2][j] 
	        		!= null && this.board[i + 3][j] != null) {
	        		if (this.board[i][j].getPlayer() == player 
	        			&& this.board[i + 1][j].getPlayer() 
	        		== player && this.board[i + 2][j].getPlayer() 
	        		== player && this.board[i + 3][j].getPlayer() 
	        		== player) {
	        			return true;
	        		}           
	        	}
	        }
	    }
	    // ascendingDiagonalCheck 
	    for (int i = 3; i < 7; i++) {
	        for (int j = 0; j < 6 - 3; j++) {
	        if (this.board[i][j] != null && this.board[i - 1][j + 1] 
	        		!= null && this.board[i - 2][j + 2] != null 
	        			&& this.board[i - 3][j + 3] != null) {
	        		if (this.board[i][j].getPlayer() == player 
	        			&& this.board[i - 1][j + 1].getPlayer() 
	             == player && this.board[i - 2][j + 2].getPlayer() 
	        	 == player && this.board[i - 3][j + 3].getPlayer() 
	        		  == player) {
	        			return true;
	        		}
	        	}
	        }
	    }
	    // descendingDiagonalCheck
	    for (int i = 3; i < 7; i++) {
	        for (int j = 3; j < 6; j++) {
	        if (this.board[i][j] != null && this.board[i - 1][j - 1] 
	        		!= null && this.board[i - 2][j - 2] != null 
	        		&& this.board[i - 3][j - 3] != null) {
	        		if (this.board[i][j].getPlayer() == player 
	        				&& this.board[i - 1][j - 1]
	        		.getPlayer() == player 
	        		&& this.board[i - 2][j - 2].getPlayer() 
	        		== player && this.board[i - 3][j - 3]
	        				.getPlayer() == player) {
	        			return true;
	        		}
	        	}
	        }
	    }
	    return false;
	}

	/**
	 * 
	 * Logic to select the proper cell when a column is selected.
	 * 
	 * @param col The column.
	 * @return boolean.
	 */
	public boolean select(final int col) {
		for (int r = 5; r >= 0; r--) {	
			if (board[col][r] == null) {
			// creates a new cell object to be placed in board
				Cell c = new Cell(cPlayer);
				board[col][r] = c;
				board[col][r].setPlayer(cPlayer);
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * Switches the current player to the next player.
	 *
	 */
	public void nextPlayer() {
		if (cPlayer == players) {
			cPlayer = 1;
		} else {
			cPlayer++;
		}
	}
}
