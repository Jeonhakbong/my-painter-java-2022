package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class KComponent{
	protected ArrayList<KActionListener> myActListeners = new ArrayList<>();;
	protected int x, y, width, height;
	protected String name = null;
	protected String text = null;
	
	public KComponent() {
		//empty.
	}
	public KComponent(String name) {
		this.name = name;
	}
	public void addKActionListener(KActionListener al) {
		myActListeners.add(al);
	}
	public abstract void paint(Graphics g);
	public void processMouseEvent(MouseEvent e) {
		// empty.
	}
	public void setBounds(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public boolean isCursorOn(Point p) {
		return (((x <= p.x) && (p.x <= x+width)) && 
				((y <= p.y) && (p.y <= y+height)));
	}
}
