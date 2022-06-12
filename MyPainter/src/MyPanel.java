// package MyApp;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


import java.util.ArrayList;


public class MyPanel extends JPanel{
	// fields.
	private Point start;
	private Point end;
	private ArrayList<Figure> fList; // painted figure.
	
	private JToolBar MyToolbar;
	private JButton btnRect;
	private JButton btnOval;
	private JButton btnLine;

	private JButton btnRed;
	private JButton btnBlue;
	private JButton btnBlack;
	
	private JButton btnMove;
	private JButton btnGroup;
	private JButton btnClear;
	
	private int figureType;
	private static int RECT_INPUT = 1;
	private static int OVAL_INPUT = 2;
	private static int LINE_INPUT = 3;
	
	private String colorType;
	private static String BLACK_COLOR = "black";
	private static String RED_COLOR = "red";
	private static String BLUE_COLOR = "blue";
	
	private String editType;
	private static String MOVE_MODE = "move";
	private static String GROUP_MODE = "group";
	
	// constructor.
	public MyPanel() {
		this.setBackground(Color.lightGray);
		this.setLayout(null);
		this.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		
		this.fList = new ArrayList<Figure>(); 
		this.start = null;
		this.end = null;
		
		this.initialToolBar();
	}
	
	
	// mypanel methods.	
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
				addFigure();
				repaint();
				break;
			case MouseEvent.MOUSE_CLICKED:
				System.out.println("Click");
				break;
			case MouseEvent.MOUSE_DRAGGED:
				System.out.println("Drag");
				break;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("draw");
		
		super.paint(g);
		
		setFigureColor(g);
		
		if(!(fList.isEmpty())) {
			for(int i = 0 ; i < fList.size(); i++) {
				fList.get(i).draw(g);
			}
		}
	}
	
	public void addFigure() {
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
	
	public void initialToolBar() {
		MyToolbar = new JToolBar("color");
		MyToolbar.setSize(800, 50);
		
		this.figureType = 0;
		this.colorType = null;
		this.editType = null;
		
		// figure btn.
		btnRect = new JButton("Rect");
		btnOval = new JButton("Oval");
		btnLine = new JButton("Line");
		
		btnRect.setMargin(new Insets(5,8,5,8));
		btnOval.setMargin(new Insets(5,8,5,8));
		btnLine.setMargin(new Insets(5,8,5,8));
		
		btnRect.addActionListener(new MouseActionListener(this));
		btnOval.addActionListener(new MouseActionListener(this));
		btnLine.addActionListener(new MouseActionListener(this));
		
		// color btn.
		btnBlack = new JButton("Black");
		btnRed = new JButton("Red");
		btnBlue = new JButton("Blue");
		
		btnBlack.setMargin(new Insets(5,8,5,8));
		btnBlack.setActionCommand("black"); 
		btnRed.setMargin(new Insets(5,8,5,8));
		btnRed.setActionCommand("red"); 
		btnBlue.setMargin(new Insets(5,8,5,8));
		btnBlue.setActionCommand("blue"); 
		
		btnBlack.addActionListener(new ColorActionListener(this));
		btnRed.addActionListener(new ColorActionListener(this));
		btnBlue.addActionListener(new ColorActionListener(this));
		
		// edit btn.
		btnMove = new JButton("Move");
		btnGroup = new JButton("Group");
		btnClear = new JButton("Clear");
		
		btnMove.setMargin(new Insets(5,8,5,8));
		btnMove.setActionCommand("move"); 
		btnGroup.setMargin(new Insets(5,8,5,8));
		btnGroup.setActionCommand("group"); 
		btnClear.setMargin(new Insets(5,8,5,8));
		btnClear.setActionCommand("clear"); 
		
		btnMove.addActionListener(new EditActionListener(this));
		btnGroup.addActionListener(new EditActionListener(this));
		btnClear.addActionListener(new EditActionListener(this));
		
		// add btn to toolbar.
		MyToolbar.add(btnRect);
		MyToolbar.add(btnOval);
		MyToolbar.add(btnLine);
		MyToolbar.add(btnBlack);
		MyToolbar.add(btnRed);
		MyToolbar.add(btnBlue);
		MyToolbar.add(btnMove);
		MyToolbar.add(btnGroup);
		MyToolbar.add(btnClear);
		
		this.add(MyToolbar, BorderLayout.NORTH);
	}
	
	public void setFigureType(Object b) {
		editType = null;
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
	
	public void setColorType(Object b) {
		if(b == btnBlack) {
			System.out.println("black");
			colorType = BLACK_COLOR;
		} else if(b == btnRed) {
			System.out.println("Red");
			colorType = RED_COLOR;
		} else if (b == btnBlue) {
			System.out.println("blue");
			colorType = BLUE_COLOR;
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
			repaint();
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
}
