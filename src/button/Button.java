package button;

import java.awt.*;

public class Button {
	private String name;
	private int x, y, width, height;
	private boolean hover = false, isPressed = false, isVisible = true;
	private Color originalButtonColor = Color.GREEN;
	private Color buttonColor;
	private Color textColor = Color.BLACK;
	private Font normalFont = new Font(Font.MONOSPACED, Font.PLAIN, 25);
	
	public Button(int x, int y, String name) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = (name.length()+2)*15;
		this.height = 52;
	}
	
	public Button(int x, int y, String text, Color originalButtonColor, boolean lightText) {
		name = text;
		this.x = x;
		this.y = y;
		this.width = (name.length()+2)*15;
		this.height = 52;
		this.originalButtonColor = originalButtonColor;
		if (lightText) {
			textColor = Color.WHITE;
		}
	}
	
	public Button(int x, int y, int width, int height, String name) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Button(int x, int y, int width, int height, String text, Color originalButtonColor, boolean lightText) {
		name = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.originalButtonColor = originalButtonColor;
		if (lightText) {
			textColor = Color.WHITE;
		}
	}
	
	/**
	 * Draws the button and detects if the mouse is hovering over it
	 * @param g the graphics component for rendering
	 * @param mouse the current mouse position
	 */
	public void update(Graphics g, Point mouse, boolean mousePressed) {
		if (isVisible) {
			hover = this.contains(mouse);
			isPressed = hover && mousePressed;
			
			if (isPressed) {
				buttonColor = originalButtonColor.darker().darker();
			} else if (hover) {
				buttonColor = originalButtonColor.darker();
			} else {
				buttonColor = originalButtonColor;
			}
			
			g.setColor(buttonColor);
			g.fillRect(x, y, width, height);
			g.setColor(textColor);
			g.setFont(normalFont);
			g.drawString(name, width/2-(15*name.length())/2+x, height/2+13+y);
		}
	}
	
	/**
	 * Checks to see if point p is contained in the button box
	 * @param p can be any point
	 * @return whether the point p is in the button box
	 */
	public boolean contains(Point p) {
		if (p == null) {
			p = new Point(-1, -1);
		}
		
		if (p.x >= x && p.x < width+x) {
			if (p.y >= y && p.y < height+y) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Simple getter for the isPressed variable
	 * @return true when button is pressed
	 */
	public boolean isPressed() {
		return isPressed;
	}
	
	/**
	 * Sets whether to show the button or not
	 * @param isVisible sets the button's visibility
	 */
	public void setVisibility(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
