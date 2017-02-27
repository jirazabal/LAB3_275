import static org.junit.Assert.*;

import org.junit.Test;

public class boardTest{
	
	@Test
	public void testPassConstructor() {
		Board b = new Board(100);
		assertEquals(150, b.timer);
	}
	@Test
	public void testFailConstructor(){
		Board b = new Board(100);
		assertEquals(100, b.timer);
	}
	
	@Test
	public void testPassSpawnRock(){
		Board b = new Board(100);
		b.spawnRock();
		assertNotNull(b.Rocks);
	}
	@Test
	public void testFailSpawnRock(){
		Board b = new Board(100);
		b.spawnRock();
		assertNull(b.Rocks);
	}
	@Test
	public void testPassSetTimer(){
		Board b = new Board(100);
		b.setTimer(65);
		assertEquals(65, b.timer);
	}
	@Test
	public void testFailSetTimer(){
		Board b = new Board(100);
		b.setTimer(65);
		assertEquals(150, b.timer);
	}
	@Test
	public void testPassMoveRocks(){
		Board b = new Board(100);
		for (int i = 0; i < 20; i++){
			b.spawnRock();
		}
		b.moveRocks();
		assertEquals(1, b.Rocks.get(0).getY());
		for (int i = 0; i < 19; i++){
			b.Rocks.get(0).moveRock();
		}
		assertEquals(20, b.Rocks.get(0).getY());
		
	}
	@Test
	public void testFailMoveRocks(){
		Board b = new Board(100);
		for (int i = 0; i < 20; i++){
			b.spawnRock();
		}
		b.moveRocks();
		assertEquals(0, b.Rocks.get(0).getY());
		for (int i = 0; i < 19; i++){
			b.Rocks.get(0).moveRock();
		}
		assertEquals(21, b.Rocks.get(0).getY());
		
	}
	@Test
	public void testPassRemoveRock(){
		Board b = new Board(100);
		for (int i = 0; i < 20; i++){
			b.spawnRock();
		}
		assertEquals(20, b.Rocks.size());
		b.removeRock(19);
		assertEquals(19, b.Rocks.size());
	}
	@Test
	public void testFailRemoveRock(){
		Board b = new Board(100);
		for (int i = 0; i < 20; i++){
			b.spawnRock();
		}
		assertEquals(19, b.Rocks.size());
		b.removeRock(19);
		assertEquals(20, b.Rocks.size());
	}
	@Test
	public void testPassMoveLeft(){
		Board b = new Board(100);
		assertEquals(10, b.player.getX());
		b.moveLeft();
		assertEquals(9, b.player.getX());	
	}
	@Test
	public void testFailMoveLeft(){
		Board b = new Board(100);
		assertEquals(10, b.player.getX());
		b.moveLeft();
		assertEquals(10, b.player.getX());	
	}
	@Test
	public void testPassMoveRight(){
		Board b = new Board(100);
		assertEquals(10, b.player.getX());	
		b.moveRight();
		assertEquals(11, b.player.getX());	
	}
	@Test
	public void testFailMoveRight(){
		Board b = new Board(100);
		assertEquals(10, b.player.getX());
		b.moveLeft();
		assertEquals(11, b.player.getX());	
	}
	@Test
	public void testPassProcessChar(){
		Board b = new Board(100);
		WaitForCharThread t1 = new WaitForCharThread();
		//t1.run(); input for Windows machines is broken apparently. tried javac on CMD and got multiple errors about ConsoleReader. 
		int i = t1.i;
		b.processChar(i);
		
	}
	@Test
	public void testPassTakeTurn(){
		Board b = new Board(100);
		for (int i = 0; i < 20; i++){
			b.spawnRock();
		}
		assertEquals(0, b.Rocks.get(0).getY());
		b.takeTurn(0);
		assertEquals(1, b.Rocks.get(0).getY());
				
	}
	
	@Test
	public void testFailTakeTurn(){
		Board b = new Board(100);
		for (int i = 0; i < 20; i++){
			b.spawnRock();
		}
		assertEquals(0, b.Rocks.get(0).getY());
		b.takeTurn(0);
		assertEquals(2, b.Rocks.get(0).getY());
				
	}
	
}

