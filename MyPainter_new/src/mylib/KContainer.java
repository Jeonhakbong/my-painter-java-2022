package mylib;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KContainer extends KComponent{
	public ArrayList<KComponent> compoList = new ArrayList<>();
	
	
	protected ArrayList<KActionListener> myActListeners;
	
	public KContainer() {
		//empty.
	}
	public void initial() {}
	
	public KContainer(String name) {
		super(name);
		
		myActListeners = new ArrayList<>();
	}
	public void add(KComponent kc) {
		compoList.add(kc);
	}
	
	@Override
	public void processMouseEvent(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	public void addKActionListener(KActionListener al) {
		myActListeners.add(al);
	}
}