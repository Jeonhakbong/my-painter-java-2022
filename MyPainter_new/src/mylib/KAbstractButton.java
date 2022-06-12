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
	
}