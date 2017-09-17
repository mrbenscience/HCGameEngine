import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class HCPainter extends JPanel{
	
	BufferedImage bi;
	Graphics2D g2;
	
	public HCPainter(int width, int height) {
		bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2 = bi.createGraphics();
	}
	
	public void setColor(Color c) {
		g2.setColor(c);
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
	}
	
	public void image(String name, int x, int y, HCImageHandler handler) {
		g2.drawImage(handler.get(name), x, y, null);
	}
}
