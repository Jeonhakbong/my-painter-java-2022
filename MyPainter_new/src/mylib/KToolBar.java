package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KToolBar extends KContainer{
	ArrayList<KButton> bList; // button.
	
	public KToolBar(String name) {
		super(name);
		this.bList = new ArrayList<>();
		this.setBounds(10, 80);
		this.setSize(500, 40);
	}
	
	public void setActionCommand(String c) {
		this.text = c;
	}
	
	@Override
	public void initial() {
		// empty.
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
		g.drawRect(x, y, width, height);
		if(!(bList.isEmpty())) {
			for(int i = 0 ; i < bList.size(); i++) {
				bList.get(i).paint(g);
			}
		}
	}
	
	public void addBtn(KButton kb) {
		// TODO Auto-generated method stub
		bList.add(kb);
	}
	
	public KButton findBtn(Point p) {
		if(!(bList.isEmpty())) {
			for(int i = 0 ; i < bList.size(); i++) {
				if(bList.get(i).isCursorOn(p)) {
					return bList.get(i);
				}
			}
		}
		return null;
	}
}
