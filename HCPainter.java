import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class HCPainter extends JPanel{
	
	BufferedImage bi;
	Graphics2D g2;
	Color bg;
	int width, height;
	
	public HCPainter(int width, int height) {
		this.width = width;
		this.height = height;
		bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2 = bi.createGraphics();
	}
	
	public void setColor(Color c) {
		g2.setColor(c);
	}
	
	public void background(Color c) {
		bg = c;
	}
	
	public void rect(int x, int y, int width, int height, boolean fill) {
		if(fill) {
			g2.fillRect(x, y, width, height);
		}else {
			g2.drawRect(x, y, width, height);
		}
	}
	
	public void line(int x, int y, int x2, int y2) {
		g2.drawLine(x, y, x2, y2);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bi, 0, 0, null);
		if(bg != null) {
			g2.setColor(bg);
			g2.fillRect(0, 0, width, height);
		}
	}
	
	public void image(String name, int x, int y, HCImageHandler handler) {
		g2.drawImage(handler.get(name), x, y, null);
	}
	
	public void rotateImage(String name, double degree, int x, int y, HCImageHandler handler) {
		BufferedImage image = handler.get(name);
		AffineTransform at = new AffineTransform();
		at.translate(x, y);
		at.rotate(Math.toRadians(degree), image.getWidth()/2, image.getHeight()/2);
		g2.drawImage(image, at, null);
	}
}
