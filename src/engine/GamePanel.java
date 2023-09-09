package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import engine.tileFactory.Tile;

public class GamePanel extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	
	private AbstractGame AG;
	private Input keyboard;
	private Thread gameThread;
	private Tile tl;

	private int screeWidth;
	private int screeHeight;
	private final int fps = 60;
	
	
	public GamePanel(AbstractGame AG) {
		this.AG = AG;
		tl = new Tile();
		keyboard = new Input(this);
		screeWidth = tl.getTileSize() * tl.getMaxScreenCol();
		screeHeight = tl.getTileSize() * tl.getMaxScreenRow();
		
		this.setPreferredSize(new Dimension(screeWidth, screeHeight));
		this.setBackground(Color.cyan);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addKeyListener(keyboard);
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
//	public void update() {
//	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		AG.draw(g2);
		g2.dispose();
	}
	public Input getKeyboard() {
		return keyboard;
	}
}

























