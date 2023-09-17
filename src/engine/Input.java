package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class Input implements KeyListener {
    private Map<Integer, Boolean> keyPressed = new HashMap<>();

    public Input(GamePanel gp) {
    	for (int i = 0; i < 256; i++) {
    		keyPressed.put(i, false);
    	}
    	gp.addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
    	int keycode = e.getKeyCode();
    	if(!keyPressed.get(keycode)) {
    		keyPressed.put(keycode, true);
    	}
    }
    @Override
    public void keyReleased(KeyEvent e) {
    	int keycode = e.getKeyCode();
    	keyPressed.put(keycode, false);
    }
    public boolean iskeyPressed(int keyCode) {
        return keyPressed.get(keyCode);
    }
}