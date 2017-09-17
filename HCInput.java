import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HCInput implements KeyListener{
	
	Boolean[] keys = new Boolean[26];
	
	public boolean getKey(char key) {
		return keys[key-'a'];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyChar()-'a'] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyChar()-'a'] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
