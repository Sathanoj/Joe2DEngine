package game;

import java.awt.Graphics2D;

import engine.AbstractGame;
import engine.GamePanel;
import game.obj.Ball;
import game.obj.Player1;

public class Game extends AbstractGame{
	private Ball ball;
	private Player1 palete;
	
	public Game() {
		ball = new Ball();
		palete = new Player1();
		carregaTtiles();
	}
	public void carregaTtiles() {
		//from res folder this the correct way "res/tile05.png"
	}
	@Override
	public void update(GamePanel gp) {
		ball.update(gp);
		palete.update(gp);
	}
	@Override
	public void draw(Graphics2D g2) {
		ball.draw(g2);
		palete.draw(g2);
	}
}
