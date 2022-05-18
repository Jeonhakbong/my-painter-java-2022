
import javax.swing.JPanel;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.ArrayList;


public class MyPanel extends JPanel{
	// fields.
	Point start;
	Point end;
	
	BufferedImage img; // image.
	
	ArrayList<Figure> fList; // painted figure.
	ArrayList<MyButton> bList; // figure button.
	int buttonType;
	
	MyButton btnRect;
	MyButton btnOval;
	MyButton btnLine;
	
	static int RECT_INPUT = 1;
	static int OVAL_INPUT = 2;
	static int LINE_INPUT = 3;
	
	// constructor.
	public MyPanel() {
		this.setBackground(Color.lightGray);
		// this.addMouseListener(new MyMouseListener());
		this.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		
		this.fList = new ArrayList<Figure>(); 
		this.bList = new ArrayList<MyButton>();
		
		this.buttonType = 0;
		this.initialBtn();
		
		this.start = null;
		this.end = null;
		
		this.img = null;
		
		try {
		    this.img = ImageIO.read(new File("DUKE.PNG"));
		} catch (IOException e) {
		    System.out.println("Cannot open image file.");
		}

	}
	
	// my panel methods.
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
				addFigure();
				repaint();
			case MouseEvent.MOUSE_CLICKED:
				System.out.println("Click");
				
				MyButton b = findBtn(end);
				if (b != null) {
					System.out.println("button");
					b.processMouseEvent(e);
				}
				break;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("draw");
		
		super.paint(g);
	
		if(!(bList.isEmpty())) {
			for(int i = 0 ; i < bList.size(); i++) {
				bList.get(i).drawBtn(g);
			}
		}

		if(!(fList.isEmpty())) {
			for(int i = 0 ; i < fList.size(); i++) {
				fList.get(i).draw(g);
			}
		}
		
		g.drawImage(img, 500, 10, 250,250, null);
	}
	
	public void addFigure() {
		if(buttonType == RECT_INPUT) {
			Figure f = new Rect(start, end);
			fList.add(f);
		} else if (buttonType == OVAL_INPUT) {
			Figure f = new Oval(start, end);
			fList.add(f);
		} else if(buttonType == LINE_INPUT){
			Figure f = new Line(start, end);
			fList.add(f);
		}
	}
	
	public void initialBtn() {
		btnRect = new FigureBtn("Rect");
		btnOval = new FigureBtn("Oval");
		btnLine = new FigureBtn("Line");
		
		btnRect.setBounds(10, 10);  
		btnOval.setBounds(100, 10);
		btnLine.setBounds(190, 10);
		
		btnRect.addMyActionListener(new MyRectListener(this));
		btnOval.addMyActionListener(new MyOvalListener(this));
		btnLine.addMyActionListener(new MyLineListener(this));
		
		bList.add(btnRect);
		bList.add(btnOval);
		bList.add(btnLine);
	}
	
	public MyButton findBtn(Point p) {
		if(!(bList.isEmpty())) {
			for(int i = 0 ; i < bList.size(); i++) {
				if(bList.get(i).isCursorOn(p)) {
					return bList.get(i);
				}
			}
		}
		return null;
	}
	
	public void setButtonType(Object b) {
		if(b != null) {
			if(b == btnRect) {
				System.out.println("Rect");
				buttonType = RECT_INPUT;
			} else if(b== btnOval) {
				System.out.println("Oval");
				buttonType = OVAL_INPUT;
			} else if(b==btnLine){
				System.out.println("Line");
				buttonType = LINE_INPUT;
			}
		}
	}
}
