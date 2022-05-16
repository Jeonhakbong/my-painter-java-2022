import java.awt.Graphics;

public abstract class Figure {
	protected int x;
	protected int y;
	abstract void draw(Graphics g);
}


class Rect extends Figure {
	private int width;
	private int height;
	
	public Rect(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(this.x, this.y, width, height);
	}
}


class Oval extends Figure {
	private int width;
	private int height;
	
	public Oval(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawOval(this.x, this.y, width, height);
	}
}


class Line extends Figure {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
	}
}


class Text extends Figure {
	private String str;
	
	public Text(String str, int x, int y) {
		this.str = str;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawString(this.str, this.x, this.y);
	}
}