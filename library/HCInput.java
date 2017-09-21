import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HCInput implements KeyListener{
	
	Boolean[] keys = new Boolean[26];
	
	public HCInput() {
		for(int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}
	
	public boolean getKey(char key) {
		return keys[Character.toLowerCase(key)-'a'];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[Character.toLowerCase(e.getKeyChar())-'a'] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[Character.toLowerCase(e.getKeyChar())-'a'] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
