package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.GamePanel;

public class Player extends Entity{
	private GamePanel gp;
	
    private int playerX;
    private int playerY;

    private int deltaX = 3; // delta change position each update
    private int deltaY = 3;
	public Player (GamePanel gp) {
		this.gp = gp;
		
		serDefaultValue();
	}
	public void serDefaultValue() {
		playerX = 100;
		playerY = 400;
		speed = 4;
	}
	public void update() {

		move();
	}
	public void move() {
        playerX += deltaX;
        playerY += deltaY;
        
        if (playerX <= 0 || playerX + gp.getTileSize() >= gp.getScreeWidth()) {
            deltaX = -deltaX; // Invert x position
        }
        if (playerY <= 0 || playerY + gp.getTileSize() >= gp.getScreeHeight()) {
            deltaY = -deltaY; // Invert y position
        }
	}
	public void draw(Graphics2D g2) {
		g2.setColor(Color.orange);
		g2.fillRect(playerX, playerY, gp.getTileSize(), gp.getTileSize());
	}
}














