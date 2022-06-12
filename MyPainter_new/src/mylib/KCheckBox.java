package mylib;

import java.awt.Graphics;

public class KCheckBox extends KAbstractButton{
	boolean check = false;
	
	public KCheckBox(String name) {
		super(name);
		this.width = 20;
		this.height = 20;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
		g.drawString(name, x+(width + 5), y+15);
		if(check) {
			g.fillRect(x, y, width, height);
		}
	}	
	public void setCheck() {
		if(check) {
			check = false;
		} else {
			check = true;
		}
	}
}
