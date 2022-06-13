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
		this.setSize(650, 40);
	}
	
	public void setActionCommand(String c) {
		this.text = c;
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
