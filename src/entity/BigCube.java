package entity;

import java.awt.Color;
import java.awt.Graphics;

public class BigCube extends Entity {
	
	
	public BigCube() {
		x = 50;
		y = 50;
		
	}
	public void update() {
		
	}
	public void draw(Graphics g2) {
		g2.setColor(Color.black);
		g2.drawRect(x, y, 400, 400);
	}
}
