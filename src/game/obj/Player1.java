package game.obj;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import engine.GamePanel;
import engine.RenderImage;

public class Player1 {
	private RenderImage image;
	private BufferedImage palete;
	
	private int x = 0, y = 0, speed = 5;
	public Player1() {
		image = new RenderImage();
		palete = image.getImage("res/PongGame/paleta01.png");
		startPosition();
	}
	public void startPosition() {
		x = 0;
		y = 250;
	}
	public void update(GamePanel gp) {
		
		if(gp.getKeyboard().iskeyPressed(KeyEvent.VK_DOWN)) {
			y+= speed;
		}
		if(gp.getKeyboard().iskeyPressed(KeyEvent.VK_UP)) {
			y-= speed;
		}
	}
	public void draw(Graphics2D g2) {
		g2.drawImage(palete, x, y, palete.getWidth(), palete.getHeight(), null);
	}
}