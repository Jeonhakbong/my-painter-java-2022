package painterapp;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import mylib.KButton;
import mylib.KCheckBox;
import mylib.KComponent;
import mylib.KMenu;
import mylib.KMenuItem;
import mylib.KPanel;
import mylib.KToolBar;

public class PainterPanel extends KPanel{
	
	PaintListener pl = new PaintListener(this);
	EditListener el = new EditListener(this);
	ColorListener cl = new ColorListener(this);
	
	// toolbar btn.
	ArrayList<Figure> fList; // painted figure.
	
	KButton btnRect;
	KButton btnOval;
	KButton btnLine;
	
	KButton btnMove;
	KButton btnGroup;
	KButton btnClear;
	
	// menu.
	KMenu mnFile;
	KMenu mnView;
	
	// menuitem
	KMenuItem miOpen;
	KMenuItem miSave;
	
	KMenuItem miFull;
	KMenuItem miMini;
	
	// checkbox.
	KCheckBox cbRed;
	KCheckBox cbBlue;
	KCheckBox cbBlack;
	
	static int TYPE_DEFAULT = 0;
	// type.
	int figureType = TYPE_DEFAULT; // 도형 타입.
	static int RECT_BTN = 1;
	static int OVAL_BTN = 2;
	static int LINE_BTN = 3;
	
	int menuType = TYPE_DEFAULT;
	static int FILE_MENU = 4;
	static int EDIT_MENU = 5;
	
	int editType = TYPE_DEFAULT;
	static int GROUP_MODE = 6;
	static int MOVE_MODE = 7;
	
	int colorType = TYPE_DEFAULT;
	static int BLACK_COLOR = 8;
	static int RED_COLOR = 9;
	static int BLUE_COLOR = 10;
	
	
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
			
			editFigure();
			paintFigure();
			break;
		case MouseEvent.MOUSE_CLICKED:
			System.out.println("Click");
			
			KComponent b = findBtn(end);
			
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
		setFigureColor(g);
		if(!(fList.isEmpty())) {
			for(int i = 0 ; i < fList.size(); i++) {
				fList.get(i).paint(g);
			}
		}
	}
	@Override
	public KComponent findBtn(Point p) {
		KComponent temp;
		if((temp = toolBar.findBtn(p)) != null) {
			return temp;
		} 
		if ((temp = menuBar.findBtn(p)) != null) {
			return temp;
		}
		
		return null;
	}
	@Override
	public void initial() {
		this.setToolBar(); // toolbar.		
		this.setMenuItem(); // menuitem		
		this.setMenu(); // menu.		
		this.setMenuBar(); // menubar.
	}
	public void setToolBar() {
		btnRect = new KButton("Rect");
		btnOval = new KButton("Oval");
		btnLine = new KButton("Line");
		
		btnMove = new KButton("Move");
		btnGroup = new KButton("Group");
		btnClear = new KButton("Clear");
		
		cbRed = new KCheckBox("Red");
		cbBlue = new KCheckBox("Blue");
		cbBlack = new KCheckBox("Black");
		
		btnRect.setBounds(15, 85);  
		btnOval.setBounds(85, 85);
		btnLine.setBounds(155, 85);
		
		btnMove.setBounds(225, 85);
		btnGroup.setBounds(295, 85);
		btnClear.setBounds(365, 85);
		
		cbRed.setBounds(435, 85);
		cbBlue.setBounds(505, 85);
		cbBlack.setBounds(575, 85);
		
		btnRect.addKActionListener(pl);
		btnOval.addKActionListener(pl);
		btnLine.addKActionListener(pl);
		
		btnMove.addKActionListener(el);
		btnGroup.addKActionListener(el);
		btnClear.addKActionListener(el);
		
		cbRed.addKActionListener(cl);
		cbBlue.addKActionListener(cl);
		cbBlack.addKActionListener(cl);
		
		toolBar.add(btnRect);
		toolBar.add(btnOval);
		toolBar.add(btnLine);
		
		toolBar.add(btnGroup);
		toolBar.add(btnMove);
		toolBar.add(btnClear);
		
		toolBar.add(cbRed);
		toolBar.add(cbBlue);
		toolBar.add(cbBlack);
		
		toolBar.addKActionListener(pl);
		
		this.add(toolBar);
	}
	public void setMenuItem() {
		miOpen = new KMenuItem("Open");
		miSave = new KMenuItem("Save");
		miFull = new KMenuItem("Full");
		miMini = new KMenuItem("Mini");
		
		miOpen.setBounds(245, 45);
		miSave.setBounds(315, 45);
		miFull.setBounds(245, 45);
		miMini.setBounds(315, 45);
		
		miOpen.addKActionListener(pl);
		miSave.addKActionListener(pl);
		miFull.addKActionListener(pl);
		miMini.addKActionListener(pl);
	}
	public void setMenu() {
		mnFile = new KMenu("Flie");
		mnView = new KMenu("View");
		
		mnFile.setBounds(15, 45);
		mnView.setBounds(85, 45);
		
		mnFile.addKActionListener(pl);
		mnView.addKActionListener(pl);
		
		mnFile.add(miOpen);
		mnFile.add(miSave);
		mnView.add(miFull);
		mnView.add(miMini);
	}
	public void setMenuBar() {
		menuBar.addKActionListener(pl);
		menuBar.add(mnFile);
		menuBar.add(mnView);
		
		this.add(menuBar);
	}
	public void setBtnType(Object b) {
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
				
			} else if(b == mnView) {
				System.out.println("View");
				menuType = EDIT_MENU;
				mnView.showItem(true);
			} 
		}
	}
	public void setEditType(Object b) {
		figureType = 0;
		if(b == btnMove) {
			System.out.println("move");
			editType = MOVE_MODE;
		} else if(b == btnGroup) {
			System.out.println("group");
			editType = GROUP_MODE;
		} else if(b == btnClear) {
			fList.clear();
		}
	}
	public void setColorType(Object b) {
		if(b == cbBlack) {
			System.out.println("black");
			if(!(cbBlack.getCheck())){
				colorType = BLACK_COLOR;
				cbBlack.setCheck();
			} else {
				colorType = TYPE_DEFAULT;
				cbBlack.setCheck();
			}
		} else if(b == cbRed) {
			System.out.println("Red");
			if(!(cbRed.getCheck())){
				colorType = RED_COLOR;
				cbRed.setCheck();
			} else {
				colorType = TYPE_DEFAULT;
				cbRed.setCheck();
			}
		} else if (b == cbBlue) {
			System.out.println("blue");
			if(!(cbBlue.getCheck())){
				colorType = BLUE_COLOR;
				cbBlue.setCheck();
			} else {
				colorType = TYPE_DEFAULT;
				cbBlue.setCheck();
			}
		}
	}
	public void setFigureColor(Graphics g) {
		if(colorType == BLACK_COLOR) {
			g.setColor(Color.BLACK);
		} else if(colorType == RED_COLOR) {
			g.setColor(Color.RED);
		} else if (colorType == BLUE_COLOR) {
			g.setColor(Color.BLUE);
		} 
	}
	public void editFigure() {
		if(editType == MOVE_MODE) {
			if(!(fList.isEmpty())) {
				for(int i = 0 ; i < fList.size(); i++) {
					if(fList.get(i).isCursorOn(start)) {
						System.out.println("Cursor On");
						fList.get(i).move(start, end);
					}
				}
			}
		} else if(editType == GROUP_MODE) {
			FigureGroup fg = new FigureGroup(start, end);
			if(!(fList.isEmpty())) {
				for(int i = 0 ; i < fList.size(); i++) {
					if(fg.isOnGroup(fList.get(i))) {
						System.out.println("On Group");
						fg.add(fList.get(i));
					} 
				}
			}
			fList.add(fg);
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
	
}
