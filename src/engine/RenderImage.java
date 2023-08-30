package engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RenderImage {
	private BufferedImage image = null;
	
	
	public RenderImage() {
		
	}
	public BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public BufferedImage getImage(String path) {
		image  = loadImage(path);
		return image;
	}
}
