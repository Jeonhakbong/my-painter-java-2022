package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KButton extends KAbstractButton {
	// constructor.
	public KButton(String name) {
		super(name);
	}
	
	// methods.
	@Override
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString(name, x+(width/4), y+20);
	}	
}
