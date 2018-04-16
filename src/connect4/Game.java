package connect4;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * The main method to start the game and set the JMenu.  
 *	@author Jake Miller
 *	@version 4/12/2018
*/
public class Game {
	
	/** JFrame for game. */
	private JFrame frame;
	
	/** JMenu for game. */
	private JMenu menu;
	
	/** JMenuBar for game. */
	private JMenuBar menuBar;
	
	/** Quit game and new game JMenuItem. */
	private JMenuItem quitItem, newGameItem;
	
	/**
     * Constructor that creates the JFrame for the game with a JMenuBar on the 
	 * frame.
     */
	public Game() {
		frame = new JFrame("Connect 4");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setMenu();
		frame.getContentPane().add(new GamePanel(
				quitItem, newGameItem, frame));
		frame.pack();
		frame.setSize(1300, 1200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/**
     * Sets the JMenu.
     */
	public void setMenu() {
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		menu.setFont(new Font("Arial", Font.PLAIN, 25));
		quitItem = new JMenuItem("Quit");
		quitItem.setFont(new Font("Arial", Font.PLAIN, 25));
		newGameItem = new JMenuItem("New Game");
		newGameItem.setFont(new Font("Arial", Font.PLAIN, 25));

		menu.add(quitItem);
		menu.add(newGameItem);

		menuBar.add(menu);

		frame.setJMenuBar(menuBar);
	}

	/**
     * Main method to start the game.
     * 
     * @param args arguments.
     */
	public static void main(final String[] args) {
		new Game();
	}
}




