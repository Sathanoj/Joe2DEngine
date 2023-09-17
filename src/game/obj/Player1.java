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
		y = 576 / 2;
	}
	public void update(GamePanel gp) {
//		System.out.println(gp.getWidth() + " " + gp.getHeight());
		if(gp.getKeyboard().iskeyPressed(KeyEvent.VK_DOWN)) {
			y += speed;
			if(y >= gp.getHeight() - palete.getHeight()) {
				y = gp.getHeight() - palete.getHeight();
			}
		}
		if(gp.getKeyboard().iskeyPressed(KeyEvent.VK_UP)) {
			y-= speed;
			if(y <= 0) {
				y = 0;
			}
		}
	}
	public void draw(Graphics2D g2) {
		g2.drawImage(palete, x, y, palete.getWidth(), palete.getHeight(), null);
	}
}