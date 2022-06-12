package mylib;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public abstract class KAbstractButton extends KComponent{
	protected KMouseListener ml;
	protected ArrayList<KActionListener> myActListeners;
	
	public KAbstractButton(String name) {
		super(name);
		
		this.width = 60;
		this.height = 30; 
		myActListeners = new ArrayList<>();		
	}
	public void addKActionListener(KActionListener al) {
		myActListeners.add(al);
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