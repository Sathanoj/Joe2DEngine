package game.obj;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.GamePanel;

public class Ball {
	private int x;
	private int y;
	
	public Ball() {
		y = 0;
	}
	public void update(GamePanel gp) {
		x = gp.getWidth()/2;
		y ++;
		if(y == gp.getHeight()) {
			y = 0;
		}
	}
	public void draw(Graphics2D g2) {
		g2.setColor(Color.PINK);
		g2.fillOval(x, y, 30, 30);
	}
 
}
