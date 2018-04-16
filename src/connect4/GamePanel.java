package connect4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Color;


/**
 * 
 * JPanel for Connect 4 game sets up a 7x6 board with 
 * JButtons allowing the player to select a column.
 *
 * @author Jake Miller
 * @version 4/12/2018
 */
public class GamePanel extends JPanel {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	/** a 2-dim array that represents the GUI board. */
	private JLabel[][] board;
	
	/** Buttons to select a column. */
	private JButton[] buttons;
	
	/** GameLogic object to control the game. */
	private GameLogic game;
	
	/** JMenu Items to quit and create new game. */
	private JMenuItem quitItem, newGameItem;
	
	/** listener for the buttons in the game. */
	private Listener listen;
	
	/** panel to hold the game board. */
	private JPanel gamePanel;
	
	/** Used to help determine if there is a winner. */
	private int win;
	
	/** The JFrame for the panel used to dispose of frame. */
	private JFrame frame;
	
	 /**
     * Constructor to create the panel.
     * 
     * @param quitItem JMenuItem quits the game.
	 * @param newGameItem creates a new game.
	 * @param frame The JFrame.
     */
    public GamePanel(final JMenuItem quitItem, final JMenuItem newGameItem,
    		final JFrame frame) {
    	
		this.frame = frame;
    	
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(7, 7));
		setLayout(new GridLayout());
		
		listen = new Listener();

		board = new JLabel[7][6];
		buttons = new JButton[7];
		game = new GameLogic(2);
		
		this.quitItem = quitItem;
		this.newGameItem = newGameItem;
		
		this.quitItem.addActionListener(listen);
		this.newGameItem.addActionListener(listen);
		
		for (int i = 0; i < 7; i++) {
            buttons[i] = new JButton("" + (i + 1));
            buttons[i].setActionCommand("" + i);
            buttons[i].addActionListener(listen);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 25));
            gamePanel.add(buttons[i]);
        }
		
		for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 7; row++) {
                board[row][column] = new JLabel();
               board[row][column].setHorizontalAlignment(SwingConstants.CENTER);
                board[row][column].setBorder(new LineBorder(Color.black));
                gamePanel.add(board[row][column]);
            }
        }
		add(gamePanel);
	}
	
    /**
     * 
     * A separate inner class to act as a listener for all of the
     * actions performed within the JPanel.
     *
     */
	public class Listener implements ActionListener {
		/**
		 * 
		 * Implements an ActionListener to handle for button clicks.
		 * 
		 * @param e ActionEvent.
		 */
		public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == quitItem) {
			frame.dispose();
		}

		if (e.getSource() == newGameItem) {
			repaint();
			game.reset();
			gamePanel.removeAll();
			
			board = new JLabel[7][6];
			buttons = new JButton[7];
			game = new GameLogic(2);
			
			for (int i = 0; i < 7; i++) {
	            buttons[i] = new JButton("" + (i + 1));
	            buttons[i].setActionCommand("" + i);
	            buttons[i].addActionListener(listen);
	            buttons[i].setFont(new Font("Arial", Font.PLAIN, 25));
	            gamePanel.add(buttons[i]);
	        }
			
			for (int column = 0; column < 6; column++) {
	            for (int row = 0; row < 7; row++) {
	                board[row][column] = new JLabel();
	                board[row][column].setHorizontalAlignment(
	                		SwingConstants.CENTER);
	                board[row][column].setBorder(new LineBorder(
	                		Color.black));
	                gamePanel.add(board[row][column]);
	            }
			}
			revalidate();
		}
		
		// Find which button was pressed
		for (int col = 0; col < 7; col++) {	
			if (buttons[col] == e.getSource()) {
				if (game.select(col)) {
					game.nextPlayer();
				} else {
					JOptionPane.showMessageDialog(
							null, "Pick again.");
				}
			}
		}
	
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 6; col++) {
				Cell c = game.getCell(row, col);
				if (c != null && c.getPlayer() == 1) {
					board[row][col].setOpaque(true);
					board[row][col].setBackground(
							Color.red);
				} 
				if (c != null && c.getPlayer() == 2) {
					board[row][col].setOpaque(true);
					board[row][col].setBackground(
							Color.blue);
				}
			}
		}
		
		boolean winner = false;
		for (int i = 1; i <= game.getPlayers(); i++) {
			if (game.checkWin(i)) {
				winner = true;
				win = i;
			}
		}
		if (winner) {
			JLabel label = new JLabel("Player " + win 
				+ " Wins! Press New Game to play again!");
			label.setFont(new Font("Arial", Font.BOLD, 25));
			JOptionPane.showMessageDialog(null, label, "WINNER", 
					JOptionPane.OK_OPTION);
		}
	}
	}
}
