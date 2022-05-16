import java.awt.Graphics;
import java.awt.Point;


public abstract class MyButton {
	protected String name;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public MyButton(String name) {
		this.name = name;
	}
	protected abstract void setBounds(int x, int y, int w, int h);
	protected abstract void drawBtn(Graphics g);
	protected abstract boolean isCursorOn(Point p);
}

class FigureBtn extends MyButton {
	public FigureBtn(String name) {
		super(name);
	}
	
	@Override 
	public void setBounds(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
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