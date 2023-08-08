package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.GamePanel;

public class Boneco extends Entity{
	private GamePanel gp;
	
    private int centerX = 400; // Centro x da órbita circular
    private int centerY = 300; // Centro y da órbita circular
    private int radius = 100; // Raio da órbita circular
    private double angle = 0;
	
	public Boneco(GamePanel gp) {
		this.gp = gp;
		serDefaultValue();
	}
	public void update() {
		angle += Math.toRadians(1);
		
	}
	public void serDefaultValue() {
		x = 200;
		y = 320;
	}
	public void draw(Graphics2D g2) {
        int objectX = (int) (centerX + radius * Math.cos(angle)) - gp.getTileSize() / 2;
        int objectY = (int) (centerY + radius * Math.sin(angle)) - gp.getTileSize() / 2;
        
        g2.setColor(Color.RED);
        g2.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        g2.setColor(Color.BLUE);
        g2.fillRect(objectX, objectY, gp.getTileSize(), gp.getTileSize());
        
//		g2.setColor(Color.green);
//		g2.fillOval(x, y, gp.getTileSize(), gp.getTileSize());
	}

}
