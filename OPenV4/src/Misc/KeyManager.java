package Misc;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	public boolean[] keys;
	public boolean w,a,s,d,re,up,down,left,right,space;
	public boolean one,two,three,four;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		d=keys[KeyEvent.VK_D];
		a=keys[KeyEvent.VK_A];
		s=keys[KeyEvent.VK_S];
		w=keys[KeyEvent.VK_W];
		up=keys[KeyEvent.VK_UP];
		down=keys[KeyEvent.VK_DOWN];
		left=keys[KeyEvent.VK_LEFT];
		right=keys[KeyEvent.VK_RIGHT];
		re=keys[KeyEvent.VK_ENTER];
		space=keys[KeyEvent.VK_SPACE];
		one=keys[KeyEvent.VK_1];
		two=keys[KeyEvent.VK_2];
		three=keys[KeyEvent.VK_3];
		four=keys[KeyEvent.VK_4];
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
