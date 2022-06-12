package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KMenu extends KContainer{
	// protected ArrayList<KActionListener> myActListeners;
	ArrayList<KMenuItem> mItemList; // Menu item.
	
	
	public KMenu(String name) {
		super(name);
		mItemList = new ArrayList<>();
		this.width = 60;
		this.height = 30;
	}
	
	// methods.
		public void addKActionListener(KActionListener al) {
			myActListeners.add(al);
		}
		public void addMenuItem(KMenuItem kmi) {
			// TODO Auto-generated method stub
			mItemList.add(kmi);
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
			g.drawString(name, x+(width/4), y+20);
			
			for(int i = 0; i < mItemList.size(); i++) {
				mItemList.get(i).paint(g);
			}
		}	
		
		public KMenuItem findBtn(Point p) {
			if(!(mItemList.isEmpty())) {
				for(int i = 0 ; i < mItemList.size(); i++) {
					if(mItemList.get(i).isCursorOn(p)) {
						return mItemList.get(i);
					}
				}
			}
			return null;
		}
		
		public void showItem(boolean t) {
			for(int i = 0; i < mItemList.size(); i++) {
				mItemList.get(i).setVisible(t);
			}
		}
}