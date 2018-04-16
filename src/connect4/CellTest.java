package connect4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 
 * JUnitTest class to test the Cell class.
 * 
 */
class CellTest {
	
	/**
	 * Tests the other constructor.
	 */
	@Test
	public void testCellConstructorParam() {
		Cell cell = new Cell(1);
		assertTrue(cell.getPlayer() == 1);
	}
	
	/**
	 * Tests the constructor with a negative parameter.
	 */
	@Test
	public void testCellConstructorBadParam() {
		Cell cell = new Cell(-1);
		assertTrue(cell.getPlayer() == 1);
	}
	
	/**
	 * Tests the constructor with a too big parameter.
	 */
	@Test
	public void testCellConstructorBadParam2() {
		Cell cell = new Cell(3);
		assertTrue(cell.getPlayer() == 1);
	}
	
	/**
	 * Tests the setPlayers method.
	 */
	@Test
	public void testSetPlayers() {
		Cell cell = new Cell(1);
		cell.setPlayer(1);
		assertTrue(cell.getPlayer() == 1);
	}
	
	/**
	 * Tests the setPlayers method with a negative parameter.
	 */
	@Test
	public void testSetPlayersBad() {
		Cell cell = new Cell(1);
		cell.setPlayer(-1);
		assertTrue(cell.getPlayer() == 1);
	}
	
	/**
	 * Tests the setPlayers method with a too big parameter.
	 */
	@Test
	public void testSetPlayersBad2() {
		Cell cell = new Cell(1);
		cell.setPlayer(3);
		assertTrue(cell.getPlayer() == 1);
	}
}

