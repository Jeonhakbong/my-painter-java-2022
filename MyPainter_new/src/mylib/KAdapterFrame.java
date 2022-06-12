package mylib;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public // 프레임 자체를 만드는 것이 좀 복잡해서 KFrame 을 우리가 만드는 컴포넌트들의
//top window 처럼 사용한다.
//이것을 JFrame 안에 넣어서 사용하기 때문에 필요한 클래스가 AdapterFrame이다.
//
class KAdapterFrame extends JFrame{
	KFrame myFrame = null;
	KPanel myPanel = null;
	
	public KAdapterFrame() {
		enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		// setContentPane(new JPanel());
		getContentPane().setBackground(Color.white);
	}
	public void setK(KFrame kf, KPanel kp) {
		myFrame = kf;
		myPanel = kp;
		kf.setContentPane(kp);
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (myFrame != null) {
			myFrame.paint(g);
		}
	}
	@Override 
	public void processMouseEvent(MouseEvent e) {
		if (myFrame != null) {
			myFrame.processMouseEvent(e);
		}
		this.repaint();
	}

}

