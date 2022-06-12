package mylib;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class KMenuItem extends KAbstractButton{
	protected boolean visible = false;
	public KMenuItem(String name) {
		super(name);
		this.width = 60;
		this.height = 30;
	}
	@Override
	public void processMouseEvent(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}