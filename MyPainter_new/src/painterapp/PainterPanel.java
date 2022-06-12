package painterapp;

import java.awt.Graphics;
import java.awt.Menu;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import mylib.KButton;
import mylib.KComponent;
import mylib.KPanel;
import mylib.KToolBar;

public class PainterPanel extends KPanel{

	// toolbar btn.
	ArrayList<Figure> fList; // painted figure.
	
	PainterButton btnRect;
	PainterButton btnOval;
	PainterButton btnLine;
	
	int figureType = 0; // 도형 타입.
	
	static int RECT_BTN = 1;
	static int OVAL_BTN = 2;
	static int LINE_BTN = 3;
	
	// menu.
	PainterMenu mnFile;
	PainterMenu mnView;
	
	int menuType = 0;
	
	static int FILE_MENU = 4;
	static int VIEW_MENU = 5;
	
	// menuitem
	PainterMenuItem miOpen;
	PainterMenuItem miSave;
	
	PainterMenuItem miFull;
	
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
			
			KComponent b = find(end);
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
		
		// menuitem
		miOpen = new PainterMenuItem("Open");
		miSave = new PainterMenuItem("Save");
		miFull = new PainterMenuItem("Full");
		
		miOpen.setBounds(245, 45);
		miSave.setBounds(315, 45);
		miFull.setBounds(245, 45);
		
		miOpen.addKActionListener(init);
		miSave.addKActionListener(init);
		miFull.addKActionListener(init);
		
		// menu.
		mnFile = new PainterMenu("Flie");
		mnView = new PainterMenu("view");
		
		mnFile.setBounds(15, 45);
		mnView.setBounds(85, 45);
		
		mnFile.addKActionListener(init);
		mnView.addKActionListener(init);
		
		mnFile.addMenuItem(miOpen);
		mnFile.addMenuItem(miSave);
		
		mnView.addMenuItem(miFull);
		
		// menubar.
		menuBar.addKActionListener(init);
		menuBar.addMenu(mnFile);
		menuBar.addMenu(mnView);
		
		this.add(menuBar);
	}
	public void setType(Object b) {
		if(b != null) {
			mnFile.showItem(false);
			mnView.showItem(false);
			if(b == btnRect) {
				System.out.println("Rect");
				figureType = RECT_BTN;
				
			} else if(b == btnOval) {
				System.out.println("Oval");
				figureType = OVAL_BTN;
				
			} else if(b == btnLine){
				System.out.println("Line");
				figureType = LINE_BTN;

			} else if(b == mnFile) {
				System.out.println("File");
				menuType = FILE_MENU;
				mnFile.showItem(true);
				
			} else if(b==mnView) {
				System.out.println("View");
				menuType = VIEW_MENU;
				mnView.showItem(true);
				
			}
		}
	}
	
	public void paintFigure() {
		if(figureType == RECT_BTN) {
			Figure f = new Rect(start, end);
			fList.add(f);
		} else if (figureType == OVAL_BTN) {
			Figure f = new Oval(start, end);
			fList.add(f);
		} else if(figureType == LINE_BTN){
			Figure f = new Line(start, end);
			fList.add(f);
		} 
	}
	
	public KComponent find(Point p) {
		KComponent temp;
		if((temp = toolBar.findBtn(p)) != null) {
			return temp;
		} 
		if ((temp = menuBar.findBtn(p)) != null) {
			return temp;
		}
		return null;
	}
}
