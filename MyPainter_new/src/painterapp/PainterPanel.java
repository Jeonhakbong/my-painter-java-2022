package painterapp;

import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import mylib.KButton;
import mylib.KPanel;
import mylib.KToolBar;

public class PainterPanel extends KPanel{
	// toolbar btn.
	PainterButton btnRect;
	PainterButton btnOval;
	PainterButton btnLine;
	
	int figureType;
	
	static int RECT_INPUT = 1;
	static int OVAL_INPUT = 2;
	static int LINE_INPUT = 3;
	
	ArrayList<Figure> fList; // painted figure.
	
	// menubar menu.
	PainterMenu mnFile;

	
	// 생성자.
	public PainterPanel() {
		super();
		this.fList = new ArrayList<Figure>(); 
		this.initial();
	}
	
	// 매소드.
	@Override
	public void processMouseEvent(MouseEvent e) {
		switch(e.getID()) {
		case MouseEvent.MOUSE_PRESSED:
			System.out.println("Down");
			start = e.getPoint();
			break;
		case MouseEvent.MOUSE_RELEASED:
			System.out.println("UP");
			end = e.getPoint();
			paintFigure();
			break;
		case MouseEvent.MOUSE_CLICKED:
			System.out.println("Click");
			
			KButton b = toolBar.findBtn(end);
			if (b != null) {
				b.processMouseEvent(e);
			}
			
			break;
		case MouseEvent.MOUSE_DRAGGED:
			System.out.println("Drag");
			break;
		}
	}
	@Override
	public void paint(Graphics g) {
		if(!(compoList.isEmpty())) {
			for(int i = 0; i < compoList.size(); i++) {
				compoList.get(i).paint(g);
			}
		}
		if(!(fList.isEmpty())) {
			for(int i = 0 ; i < fList.size(); i++) {
				fList.get(i).paint(g);
			}
		}
	}
	@Override
	public void initial() {
		PainterListener init = new PainterListener(this);
		
		// toolbar.
		btnRect = new PainterButton("Rect");
		btnOval = new PainterButton("Oval");
		btnLine = new PainterButton("Line");
		
		btnRect.setBounds(15, 85);  
		btnOval.setBounds(85, 85);
		btnLine.setBounds(155, 85);

		btnRect.addKActionListener(init);
		btnOval.addKActionListener(init);
		btnLine.addKActionListener(init);
		
		toolBar.addBtn(btnRect);
		toolBar.addBtn(btnOval);
		toolBar.addBtn(btnLine);
		
		toolBar.addKActionListener(init);
		
		this.add(toolBar);
		
		// menubar.
		mnFile = new PainterMenu("Flie");
		mnFile.setBounds(15, 45);
		mnFile.addKActionListener(init);
		
		menuBar.addMenu(mnFile);
		
		menuBar.addKActionListener(init);
		
		this.add(menuBar);
	}
	public void setFigureType(Object b) {
		if(b != null) {
			if(b == btnRect) {
				System.out.println("Rect");
				figureType = RECT_INPUT;
			} else if(b == btnOval) {
				System.out.println("Oval");
				figureType = OVAL_INPUT;
			} else if(b == btnLine){
				System.out.println("Line");
				figureType = LINE_INPUT;
			} 
		}
	}
	
	public void paintFigure() {
		if(figureType == RECT_INPUT) {
			Figure f = new Rect(start, end);
			fList.add(f);
		} else if (figureType == OVAL_INPUT) {
			Figure f = new Oval(start, end);
			fList.add(f);
		} else if(figureType == LINE_INPUT){
			Figure f = new Line(start, end);
			fList.add(f);
		}
	}
}
