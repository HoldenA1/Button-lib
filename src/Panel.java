import java.awt.*;
import javax.swing.*;
import gui.GUIManager;
import gui.Mouse;
import gui.button.Button;
import gui.checkBox.CheckBox;
import gui.slider.Slider;

public class Panel extends JPanel {
	private static final long serialVersionUID = 2L;
	
	Button b1;
	Button b2;
	CheckBox c1;
	CheckBox c2;
	Slider s;
	GUIManager gm = new GUIManager();
	Mouse m = new Mouse();
	
	public Panel() {
		this.addMouseListener(m);
		b1 = new Button("Button One", 50, 60, 300, 70);
		gm.add(b1);
		b2 = new Button("Button Two", 50, 80+60, 300, 70).withColor(Color.CYAN).lightText();
		gm.add(b2);
		c1 = new CheckBox("Check", 50, 80+60+80);
		gm.add(c1);
		c2 = new CheckBox("Box", 50+150, 80+60+80).withColor(Color.CYAN);
		gm.add(c2);
		s = new Slider("Slider", 50, 80+60+80+80);
		gm.add(s);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gm.updateElements(g, this, m);
		if (b1.isPressed() || b2.isPressed()) {
			System.out.println("this is a button");
		}
//		if (c1.isChecked() || c2.isChecked()) {
//			System.out.println("this is a checkbox");
//		}
//		System.out.println(s.getValue());
		repaint();
	}
	
	public static void main(String[] args) {	
		Window w = new Window("GUI Demo");
		Panel p = new Panel();
		w.add(p);		
	}

}