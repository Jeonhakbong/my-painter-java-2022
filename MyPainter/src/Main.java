import java.util.Scanner;

public class Main {
	
	static int RECT_INPUT = 0;
	static int OVAL_INPUT = 1;
	static int LINE_INPUT = 2;
	static int TEXT_INPUT = 3;
	
	static Figure createFigure(Scanner sc, int type) {
		Figure temp;
		
		if(type == RECT_INPUT) {
			//System.out.println("Rect");
			temp = new Rect(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		} else if(type == OVAL_INPUT) {
			//System.out.println("Oval");
			temp = new Oval(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		} else if(type == LINE_INPUT) {
			//System.out.println("Line");
			temp = new Line(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		} else {
			//System.out.println("Text");
			temp = new Text(sc.next(), sc.nextInt(), sc.nextInt());
		}
		
		return temp;
	}

	public static void main(String[] args) {
//		표준 입력에서 입력 받은 내용으로 도형을 그리는 그림판을 작성한다.
//
//		1. 입력 형식:
//		도형 종류는 정수로 0~3 으로 입력 (0: 사각형 1:타원 2: 선분 3: 텍스트)
//		도형 종류에 따라 0~2 의 경우는 추가로 4개 정수를 입력 (drawRect, drawOval, drawLine 의 4개 정수)
//		3 의 경우는 스트링과 2개 정수
		
//		2. 프레임 클래스(상속 받은) 는 도형의 ArrayList 에 도형 객체를 저장(다형성)
		
//		3. 모든 도형을 그리는 것은 paint 함수에서 책임을 지되, 각 도형은 자기 자신을 그리는 함수
//		   void draw(Graphics g); 함수를 가진다. 즉, paint 함수가 모든 도형의 draw를 호출해주는 것이다. 

//		4. 입력을 받으면 도형 객체를 추가하고 repaint() 를 호출하면 자동으로 paint함수가 호출 된다.
//		   main 에서 그림을 바로 그리는 것이 아니다.
		MyFrame  mf = new MyFrame ("My Figure Paint");
		mf.setVisible(true);
		Figure f;
		
		try {
			Scanner sc = new Scanner(System.in);
			while(sc.hasNextInt()) {
				f = createFigure(sc, sc.nextInt());
				mf.add(f);
				mf.repaint();
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
