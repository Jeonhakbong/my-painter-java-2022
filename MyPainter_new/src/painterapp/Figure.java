package painterapp;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import mylib.KComponent;

public abstract class Figure extends KComponent{
//	protected Point start;
//	protected Point end;
	protected int startX;
	protected int startY;
	protected int width;
	protected int height;
	protected boolean isOnGroup(Figure f) {
		return ((startX <= f.startX) && (f.startX <= (startX + width))) &&
				((startX <= (f.startX + f.width)) && ((f.startX + f.width) <= (startX + width))) &&
				((startY <= f.startY) && (f.startY <= (startY + height))) &&
				((startY <= (f.startY + f.height)) && ((f.startY + f.height) <= (startY + height)));
	}
	// protected abstract void paint(Graphics g);
	// protected abstract boolean isCursorOn(Point p);
	protected abstract void move(Point ms, Point me);
}

class FigureGroup extends Figure {
	private ArrayList<Figure> fGroup;
	private int endX;
	private int endY;
	
	public FigureGroup(Point s, Point e) {
		this.fGroup = new ArrayList<>();
		this.startX = s.x < e.x ? s.x : e.x;
		this.startY = s.y < e.y ? s.y : e.y;
		this.width = Math.abs(s.x - e.x);
		this.height = Math.abs(s.y - e.y);
	}
	
	@Override
	public void paint(Graphics g) {
		if (!(fGroup.isEmpty())) {
			findDrawMin();
			findDrawMax();
			this.width = endX - startX;
			this.height = endY - startY;
			g.drawRect(startX, startY, width, height);
		
			for (int i = 0; i < fGroup.size(); i++) {
				fGroup.get(i).paint(g);
			 }
		} 
		else {
			g.drawRect(startX, startY, width, height);
		}
	}

	@Override
	public boolean isCursorOn(Point p) {
		// TODO Auto-generated method stub
		return ((startX <= p.getX()) && (p.getX()<= (startX + width))) &&
				((startY <= p.getY()) && (p.getY() <= (startY + height)));
	}

	@Override
	public void move(Point ms, Point me) {
		// TODO Auto-generated method stub
		this.startX += (me.x - ms.x);
		this.startY += (me.y - ms.y);
		for(int i = 0; i < fGroup.size(); i++) {
			fGroup.get(i).move(ms, me);
		}
	}
	
	public void add(Figure f) {
		this.fGroup.add(f);
	}
	
	void findDrawMin() {
		int tempMinX = fGroup.get(0).startX;
		int tempMinY = fGroup.get(0).startY;

		for (int i = 0; i < fGroup.size(); i++) {
			if (tempMinX > fGroup.get(i).startX) {
				tempMinX = fGroup.get(i).startX;
			}

			if (tempMinY > fGroup.get(i).startY) {
				tempMinY = fGroup.get(i).startY;
			}
		}

		startX = tempMinX;
		startY = tempMinY;
	}

	void findDrawMax() {
		int tempMaxX = fGroup.get(0).startX + fGroup.get(0).width;
		int tempMaxY = fGroup.get(0).startY + fGroup.get(0).height;

		for (int i = 0; i < fGroup.size(); i++) {
			if (tempMaxX < (fGroup.get(i).startX + fGroup.get(i).width)) {
				tempMaxX = fGroup.get(i).startX + fGroup.get(i).width;
			}

			if (tempMaxY < (fGroup.get(i).startY + fGroup.get(i).height)) {
				tempMaxY = fGroup.get(i).startY + fGroup.get(i).height;
			}
		}

		endX = tempMaxX;
		endY = tempMaxY;
	}
}

class Rect extends Figure {

	public Rect(Point s, Point e) {
		this.startX = s.x < e.x ? s.x : e.x;
		this.startY = s.y < e.y ? s.y : e.y;
		this.width = Math.abs(s.x - e.x);
		this.height = Math.abs(s.y - e.y);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(this.startX, this.startY, width, height);
	}

	@Override
	public boolean isCursorOn(Point p) {
		// TODO Auto-generated method stub
		return ((startX <= p.getX()) && (p.getX()<= (startX + width))) &&
				((startY <= p.getY()) && (p.getY() <= (startY + height)));
	}

	@Override
	public void move(Point ms, Point me) {
		// TODO Auto-generated method stub
		this.startX += (me.x - ms.x);
		this.startY += (me.y - ms.y);
	}
}


class Oval extends Figure {
	private int centerX;
	private int centerY;
	
	public Oval(Point s, Point e) {
		this.startX = s.x < e.x ? s.x : e.x;
		this.startY = s.y < e.y ? s.y : e.y;
		this.width = Math.abs(s.x - e.x);
		this.height = Math.abs(s.y - e.y);
		this.centerX = startX + (width / 2);
		this.centerY = startY + (height / 2);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawOval(this.startX, this.startY, width, height);
	}

	@Override
	public boolean isCursorOn(Point p) {
		double distance = Math.sqrt(((centerX - p.getX()) * (centerX - p.getX())) 
				+ ((centerY - p.getY()) * (centerY - p.getY())));
		return (distance <= (width/2));
	}

	@Override
	public void move(Point ms, Point me) {
		this.startX += (me.x - ms.x);
		this.startY += (me.y - ms.y);
		this.centerX = startX + (width / 2);
		this.centerY = startY + (height / 2);
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
	public void paint(Graphics g) {
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
	}

	@Override
	public boolean isCursorOn(Point p) {
		return false;
	}

	@Override
	public void move(Point ms, Point me) {
		// empty.
	}
}

