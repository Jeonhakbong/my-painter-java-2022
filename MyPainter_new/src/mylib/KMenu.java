package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KMenu extends KContainer{
	public KMenu(String name) {
		super(name);
		this.width = 60;
		this.height = 30;
	}
	
	// methods.
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
		g.drawRect(x, y, width, height);
		g.drawString(name, x+(width/4), y+20);
		
		for(int i = 0; i < compoList.size(); i++) {
			compoList.get(i).paint(g);
		}
	}	
	public void showItem(boolean t) {
		for(int i = 0; i < compoList.size(); i++) {
			((KMenuItem)compoList.get(i)).setVisible(t);
		}
	}
	
}