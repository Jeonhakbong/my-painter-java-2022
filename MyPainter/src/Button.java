import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public abstract class Button {
	protected String name;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public Button(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = 80;
		this.height = 40;
	}
	protected abstract void drawBtn(Graphics g);
	protected abstract boolean isCursorOn(Point p);
}

class FigureBtn extends Button {
	public FigureBtn(String name, int x, int y) {
		super(name, x, y);
	}
	
	@Override
	public void drawBtn(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString(name, x+25, y+25);
	}
	
	@Override
	public boolean isCursorOn(Point p) {
		return (((x <= p.x) && (p.x <= x+width)) && 
				((y < p.y) && (p.y <= y+height)));
	}
}