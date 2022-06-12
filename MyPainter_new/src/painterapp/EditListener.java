package painterapp;

import java.awt.event.ActionEvent;

import mylib.KActionListener;

class EditListener implements KActionListener{
	PainterPanel pp;
	
	public EditListener(PainterPanel p) {
		pp =  p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pp.setEditType(e.getSource());
	}
	
}