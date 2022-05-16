import javax.swing.JPanel;

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
	
	ArrayList<Figure> fList; // 그린 도형.
	ArrayList<MyButton> bList; // 도형 버튼.
	int buttonType;
	
	MyButton btnRect;
	MyButton btnOval;
	MyButton btnLine;
	
	static int RECT_INPUT = 1;
	static int OVAL_INPUT = 2;
	static int LINE_INPUT = 3;
	static int TEXT_INPUT = 4;
	
	// MouseListener.
	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("Clicked " + e.getX() + ", " + e.getY());
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("Down " + e.getX() + ", " + e.getY());
			start = e.getPoint();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("Up " + e.getX() + ", " + e.getY());
			end = e.getPoint();

			MyButton b = findBtn(end);
			if (b != null) {
				setButtonType(b);
			}
			addFigure();
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("Entered " + e.getX() + ", " + e.getY());
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			// System.out.println("Exited " + e.getX() + ", " + e.getY());
		}
				
	}
	
	//constructor.
	public MyPanel() {
		this.setBackground(Color.lightGray);
		this.addMouseListener(new MyMouseListener());
		
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
		
		g.drawImage(img, 700, 10, 250,250, null);

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
		
		btnRect.setBounds(10, 10, 80, 40);  
		btnOval.setBounds(100, 10, 80, 40);
		btnLine.setBounds(190, 10, 80, 40);
		
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
	
	public void setButtonType(MyButton b) {
		if(b != null) {
			if(b == btnRect) {
				buttonType = RECT_INPUT;
			} else if(b== btnOval) {
				buttonType = OVAL_INPUT;
			} else if(b==btnLine){
				buttonType = LINE_INPUT;
			}
		}
	}
}
