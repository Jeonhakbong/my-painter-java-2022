package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class KMenuBar extends KContainer{
	public KMenuBar(String name) {
		super(name);
		this.setBounds(10, 40);
		this.setSize(225, 40);
	}
	@Override
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
		if(!(compoList.isEmpty())) {
			for(int i = 0 ; i < compoList.size(); i++) {
				compoList.get(i).paint(g);
			}
		}
	}
	
	
}
