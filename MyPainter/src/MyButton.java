//
//import java.awt.Graphics;
//import java.awt.Point;
//import java.awt.event.ActionEvent;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//
//
//public abstract class MyButton {
//	protected String name;
//	protected int x;
//	protected int y;
//	protected int width;
//	protected int height;
//	
//	protected ArrayList<MouseActionListener> myActListeners;
//	
//	public MyButton(String name) {
//		this.name = name;
//	}
//	protected abstract void setBounds(int x, int y);
//	protected abstract void drawBtn(Graphics g);
//	protected abstract boolean isCursorOn(Point p);
//	protected abstract void addMyActionListener(MouseActionListener al);
//	protected abstract void processMouseEvent(MouseEvent e);
//}
//
//class FigureBtn extends MyButton {
//	public FigureBtn(String name) {
//		super(name);
//		this.width = 80;
//		this.height = 40;
//		myActListeners = new ArrayList<>(); // button action listener.
//	}
//	
//	@Override 
//	public void setBounds(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//	
//	@Override
//	public void drawBtn(Graphics g) {
//		g.drawRect(x, y, width, height);
//		g.drawString(name, x+25, y+25);
//	}
//	
//	@Override
//	public boolean isCursorOn(Point p) {
//		return (((x <= p.x) && (p.x <= x+width)) && 
//				((y < p.y) && (p.y <= y+height)));
//	}
//	
//	@Override
//	public void addMyActionListener(MouseActionListener al) {
//		myActListeners.add(al);
//	}
//	
//	@Override 
//	public void processMouseEvent(MouseEvent e) {
//		switch(e.getID()) {
//			case MouseEvent.MOUSE_CLICKED:
//				for(int i = 0; i < myActListeners.size(); i++) {
//					myActListeners.get(i).actionPerformed(new ActionEvent(this, MouseEvent.MOUSE_CLICKED, ""));
//				}
//				break;
//		}
//	}
//}