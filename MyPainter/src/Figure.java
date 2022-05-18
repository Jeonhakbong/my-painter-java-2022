
import java.awt.Graphics;
import java.awt.Point;

public abstract class Figure {
	protected Point start;
	protected Point end;
	protected int startX;
	protected int startY;
	protected abstract void draw(Graphics g);
}


class Rect extends Figure {
	private int width;
	private int height;
	
	public Rect(Point s, Point e) {
		this.startX = s.x < e.x ? s.x : e.x;
		this.startY = s.y < e.y ? s.y : e.y;
		this.width = Math.abs(s.x - e.x);
		this.height = Math.abs(s.y - e.y);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(this.startX, this.startY, width, height);
	}
}


class Oval extends Figure {
	private int width;
	private int height;
	
	public Oval(Point s, Point e) {
		this.startX = s.x < e.x ? s.x : e.x;
		this.startY = s.y < e.y ? s.y : e.y;
		this.width = Math.abs(s.x - e.x);
		this.height = Math.abs(s.y - e.y);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawOval(this.startX, this.startY, width, height);
	}
}


class Line extends Figure {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Line(Point s, Point e) {
		this.x1 = s.x;
		this.y1 = s.y;
		this.x2 = e.x;
		this.y2 = e.y;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
	}
}


class Text extends Figure {
	private String str;
	
	public Text(String str, Point s) {
		this.str = str;
		this.startX = s.x;
		this.startY = s.y;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawString(this.str, this.startX, this.startY);
	}
}