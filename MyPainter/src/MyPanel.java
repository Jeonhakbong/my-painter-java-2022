import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	Point start;
	Point end;
	ArrayList<Figure> fList; // 그린 도형.
	ArrayList<Button> bList; // 도형 버튼.
	int buttonType;
	
	BufferedImage img;
	
	Button btnRect;
	Button btnOval;
	Button btnLine;
	
	static int RECT_INPUT = 1;
	static int OVAL_INPUT = 2;
	static int LINE_INPUT = 3;
	static int TEXT_INPUT = 4;
	
	class MyListener implements MouseListener {

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
			// TODO Auto-generated method stub
			System.out.println("Up " + e.getX() + ", " + e.getY());
			end = e.getPoint();

			Button b = findBtn(end);
			setButtonType(b);
			
			
			if(buttonType == RECT_INPUT) {
				Figure f = new Rect(start, end);
				addFigure(f);
			} else if (buttonType == OVAL_INPUT) {
				Figure f = new Oval(start, end);
				addFigure(f);
			} else if(buttonType == LINE_INPUT){
				Figure f = new Line(start, end);
				addFigure(f);
			}
			
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
	
	public MyPanel() {
		setBackground(Color.lightGray);
		this.addMouseListener(new MyListener());
		
		fList = new ArrayList<Figure>(); 
		bList = new ArrayList<Button>();
		
		this.buttonType = 0;
		this.initialBtn();
		
		this.start = null;
		this.end = null;
		
		img = null;
		try {
		    img = ImageIO.read(new File("DUKE.PNG"));
		} catch (IOException e) {
		    System.out.println("Cannot open image file.");
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
		
		g.drawImage(img, 0,0, 450,450, null);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}
	
	public void addFigure(Figure f) {
		System.out.println("add.");
		fList.add(f);
	}
	
	public void initialBtn() {
		btnRect = new FigureBtn("Rect", 10, 10);
		btnOval = new FigureBtn("Oval", 100, 10);
		btnLine = new FigureBtn("Line", 190, 10);
		
		bList.add(btnRect);
		bList.add(btnOval);
		bList.add(btnLine);
	}
	
	public Button findBtn(Point p) {
		if(!(bList.isEmpty())) {
			for(int i = 0 ; i < bList.size(); i++) {
				if(bList.get(i).isCursorOn(p)) {
					return bList.get(i);
				}
			}
		}
		return null;
	}
	
	public void setButtonType(Button b) {
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
