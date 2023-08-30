package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.AbstractGame;
import engine.GamePanel;
import engine.RenderImage;

public class Game extends AbstractGame{

	
//	private GamePanel gp;
	private RenderImage tile;
	private BufferedImage image;
	private int x = 100, y = 0;
	public Game() {
//		this.gp = gp;
		tile = new RenderImage();
		carregaTtiles();
		
	}
	public void carregaTtiles() {
		//from res folder this the correct way "res/tile05.png"
		image = tile.getImage("res/tile05.png");
	}
	@Override
	public void update(GamePanel gp) {
		y ++;
		if(y == gp.getScreeHeight()) {
			y =- gp.getTileSize();
		}
	}

	@Override
	public void draw(Graphics g2) {
		g2.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
		
	}


}
