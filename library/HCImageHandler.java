import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class HCImageHandler {
	
	ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	ArrayList<String> names = new ArrayList<String>();
	
	
	public BufferedImage get(String name) {
		if(names.contains(name)) {
			return images.get(names.indexOf(name));
		}else{
			try {
				images.add(ImageIO.read(getClass().getResource(name+".png")));
				names.add(name);
				System.out.println("Loaded: "+name);
				return get(name);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Cant load image");
				return null;
			}
		}
	}
}
