package tech.hackerlife.gui;

import java.awt.*;
import javax.swing.*;
import tech.hackerlife.gui.Button;
import tech.hackerlife.gui.Window;

public class ExampleCode extends JPanel {
	private static final long serialVersionUID = 2L;
	
	Button b1;
	Button b2;
	CheckBox c1;
	CheckBox c2;
	Slider s;
	GUIManager gm = new GUIManager();
	Mouse m = new Mouse();
	
	public ExampleCode() {
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
		repaint();
	}
	
	public static void main(String[] args) {	
		Window w = new Window("GUI Demo");
		ExampleCode p = new ExampleCode();
		w.add(p);		
	}

}