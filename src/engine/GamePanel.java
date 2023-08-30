package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	
	final int originalTileSize = 16;
	private final int scale = 3;
	
	private final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	private final int screeWidth = tileSize * maxScreenCol;
	private final int screeHeight = tileSize * maxScreenRow;
	
	int playerX, playerY;
	private final int fps = 60;
	
	private AbstractGame AG;
	private Thread gameThread;

	
	public GamePanel(AbstractGame AG) {
		this.AG = AG;
		this.setPreferredSize(new Dimension(screeWidth, screeHeight));
		this.setBackground(Color.cyan);
		this.setDoubleBuffered(true);
	}
	public void startGame() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	@Override
	public void run() {
		double drawInterval = 1000000000 / fps;
		double delta = 0;
		long lasTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lasTime) / drawInterval;
			timer += (currentTime - lasTime);
			lasTime = currentTime;
			
			if(delta >= 1) {
				//Update: update information
				AG.update(this);
				
				//Draw; draw the screen
				repaint();
				delta --;
				drawCount++;
				
			}
			if(timer >= 1000000000) {
				System.out.println("quadros: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	public void update() {
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		AG.draw(g2);
		g2.dispose();
	}
	public int getTileSize() {
		return tileSize;
	}
	public int getScreeWidth() {
		return screeWidth;
	}
	public int getScreeHeight() {
		return screeHeight;
	}

	public int getScale() {
		return scale;
	}
}

























