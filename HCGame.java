import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class HCGame {
	
	JFrame frame;
	HCPainter painter;
	Timer time;
	HCLogic logic;
	HCInput input;
	HCImageHandler handler;
	
	
	public HCGame(String name, int width, int height, HCLogic logic) {
		this.logic = logic;
		input = new HCInput();
		handler = new HCImageHandler();
		frame = new JFrame(name);
		painter = new HCPainter(width, height);
		frame.setSize(width, height);
		frame.add(painter);
		frame.addKeyListener(input);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		time = new Timer(1000/60, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
	}
	
	public boolean getKey(char key) {
		return input.getKey(key);
	}
	
	public void drawRect(int x, int y, int width, int height, boolean fill) {
		painter.rect(x, y, width, height, fill);
	}
	
	public void drawLine(int x, int y, int x2, int y2) {
		painter.line(x, y, x2, y2);
	}
	
	public void setDrawColor(Color c) {
		painter.setColor(c);
	}
	
	public void drawImage(String name, int x, int y) {
		painter.image(name, x, y, handler);
	}
	
	public void update() {
		logic.update();
		frame.repaint();
	}
	
	public void start() {
		time.start();
	}
	
	public void stop() {
		time.stop();
	}
	
}
