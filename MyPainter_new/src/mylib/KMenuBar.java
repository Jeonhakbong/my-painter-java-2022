package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class KMenuBar extends KContainer{
	ArrayList<KMenu> mList; // Menu.
	
	public KMenuBar(String name) {
		super(name);
		this.mList = new ArrayList<>();
		this.setBounds(10, 40);
		this.setSize(225, 40);
	}
	@Override
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
		if(!(mList.isEmpty())) {
			for(int i = 0 ; i < mList.size(); i++) {
				mList.get(i).paint(g);
			}
		}
	}
	public void addMenu(KMenu km) {
		// TODO Auto-generated method stub
		mList.add(km);
	}
	
	public KMenu findBtn(Point p) {
		if(!(mList.isEmpty())) {
			for(int i = 0 ; i < mList.size(); i++) {
				if(mList.get(i).isCursorOn(p)) {
					return mList.get(i);
				}
			}
		}
		return null;
	}
}
