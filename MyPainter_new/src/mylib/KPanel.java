package mylib;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import painterapp.PaintListener;

public class KPanel extends KContainer{
	protected KToolBar toolBar;
	protected KMenuBar menuBar;
	protected Point start;
	protected Point end;
	
	
	protected int buttonType;
	
	public KPanel() {
		this.buttonType = 0;
		this.start = null;
		this.end = null;
		this.toolBar = new KToolBar("toolbar");
		this.menuBar = new KMenuBar("menubar");
	}

}
