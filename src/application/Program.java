package application;

import javax.swing.JFrame;

import engine.GamePanel;

public class Program {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("engine 0.0.1");
		
		GamePanel game = new GamePanel();
		window.add(game);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		game.startGame();

	}

}
