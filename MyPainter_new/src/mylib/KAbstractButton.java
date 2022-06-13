package mylib;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public abstract class KAbstractButton extends KComponent{
	protected KMouseListener ml;
	
	public KAbstractButton(String name) {
		super(name);
		this.width = 60;
		this.height = 30; 
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
}