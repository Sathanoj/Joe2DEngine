package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Boneco;
import entity.Player;

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
	
	Thread gameThread;
	Player jogador;
	Boneco boneco;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screeWidth, screeHeight));
		this.setBackground(Color.cyan);
		this.setDoubleBuffered(true);
	}
	public void startGame() {
		gameThread = new Thread(this);
		jogador = new Player(this);
		boneco = new Boneco(this);
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
				update();
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
		jogador.update();
		boneco.update();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;

		jogador.draw(g2);
		boneco.draw(g2);
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

























