package painterapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mylib.KActionListener;

class ColorListener implements KActionListener{
	PainterPanel pp;
	
	public ColorListener(PainterPanel p) {
		pp =  p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pp.setColorType(e.getSource());
	}
	
}
