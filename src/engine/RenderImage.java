package engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RenderImage {
	BufferedImage image = null;
	GamePanel gp;
	public RenderImage(GamePanel gp) {
		this.gp = gp;
	}
	public void draw(Graphics g2) {
		try {
			this.image = ImageIO.read(new File("/walk_01.png"));
			g2.drawImage(image, 100, 100, 26, 59, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
