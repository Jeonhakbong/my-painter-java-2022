package painterapp;

import java.awt.event.ActionEvent;

import mylib.KActionListener;
import mylib.KFrame;
import mylib.KPanel;

public class FigureListener implements KActionListener{
	PainterPanel pp;
	
	public FigureListener(PainterPanel p) {
		pp =  p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pp.setType(e.getSource());
	}
	
}
