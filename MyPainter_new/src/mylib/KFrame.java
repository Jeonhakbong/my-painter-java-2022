package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KFrame extends KContainer{
	protected KMenuBar menuBar;
	protected KContainer contentPane;

	
	public KFrame() {
		contentPane = null;
	}
	
	public void setKMenuBar(KMenuBar mb) {
		// 원래 메뉴바는 frame에 있는게 정상이지만...
		// add(mb);
	}
	public void setContentPane(KContainer kc) {
		contentPane = kc;
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		contentPane.paint(g);
	}
	@Override
	public void processMouseEvent(MouseEvent e) {
		contentPane.processMouseEvent(e);
	}
	
}
