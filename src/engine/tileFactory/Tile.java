package engine.tileFactory;

public class Tile {
	
	private final int originalTileSize = 16;
	private final int scale = 3;
	private final int tileSize = originalTileSize * scale;
	private final int maxScreenCol = 16;
	private final int maxScreenRow = 12;
	
	public Tile() {
		
	}
	public int getTileSize() {
		return tileSize;
	}
	public int getMaxScreenCol() {
		return maxScreenCol;
	}
	public int getMaxScreenRow() {
		return maxScreenRow;
	}
}
