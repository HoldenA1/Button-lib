import java.awt.*;
import javax.swing.*;
import button.*;
import button.Button;

public class Panel extends JPanel {
	private static final long serialVersionUID = 2L;
	Button b = new Button(50, 60, 300, 70, "Hello World");
	Button c = new Button(50, 80+60, 300, 70, "ggggg ggggg", Color.CYAN, true);
	ButtonManager bm = new ButtonManager();
	Mouse m = new Mouse();
	
	public Panel() {
		this.addMouseListener(m);
		bm.add(b);
		bm.add(c);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		bm.updateButtons(g, this.getMousePosition(), m.mouseButtonPressed());
		if (b.isPressed()) {
			System.exit(0);
		}
		repaint();
	}

}