package button;

import java.awt.*;
import java.util.ArrayList;

public class ButtonManager {
	private ArrayList<Button> buttons;
	
	public ButtonManager() {
		buttons = new ArrayList<Button>();
	}
	
	public void add(Button button) {
		buttons.add(button);
	}
	
	public void updateButtons(Graphics g, Point mouse, boolean mousePressed) {
		for (Button b: buttons)
			b.update(g, mouse, mousePressed);
	}

}
