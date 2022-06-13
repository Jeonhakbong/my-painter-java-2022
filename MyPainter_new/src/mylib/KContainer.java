package mylib;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Point;

public class KContainer extends KComponent{
	protected ArrayList<KComponent> compoList = new ArrayList<>();
	
	
	public KContainer() {
		// empty.
	}
	public void initial() {
		// empty.
	}
	public KContainer(String name) {
		super(name);
	}
	public void add(KComponent kc) {
		compoList.add(kc);
	}
	public KComponent findBtn(Point p) {
		if(!(compoList.isEmpty())) {
			for(int i = 0 ; i < compoList.size(); i++) {
				if(compoList.get(i).isCursorOn(p)) {
					return compoList.get(i);
				} 
			} 
		}
		return null;
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}