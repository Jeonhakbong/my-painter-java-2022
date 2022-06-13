package painterapp;

import java.awt.event.ActionEvent;

import mylib.KActionListener;
import mylib.KFrame;
import mylib.KPanel;

public class PaintListener implements KActionListener{
	PainterPanel pp;
	
	public PaintListener(PainterPanel p) {
		pp =  p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pp.setBtnType(e.getSource());
	}
	
}
