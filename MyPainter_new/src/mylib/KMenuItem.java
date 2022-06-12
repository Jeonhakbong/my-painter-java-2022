package mylib;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class KMenuItem extends KAbstractButton{
	protected boolean visible = false;

	static int FILE = 4;
	static int VIEW = 5;
	
	public KMenuItem(String name) {
		super(name);
	}
	@Override
	public void processMouseEvent(MouseEvent e) {
		switch(e.getID()) {
			case MouseEvent.MOUSE_CLICKED:
				for(int i = 0; i < myActListeners.size(); i++) {
					myActListeners.get(i).actionPerformed(new ActionEvent(this, 
															MouseEvent.MOUSE_CLICKED, ""));
				}
				break;
		}
	}
	@Override
	public void paint(Graphics g) {
		if(visible) {
			g.drawRect(x, y, width, height);
			g.drawString(name, x+(width/4), y+20);
		}
	}	
	public void setVisible(boolean type) {
		visible = type;
	}
}