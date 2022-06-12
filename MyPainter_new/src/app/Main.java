package app;

import java.awt.event.ActionEvent;
import mylib.*;
import painterapp.*;//여기는 응용



public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KAdapterFrame frame = new KAdapterFrame();
		frame.setSize(800,600);
		frame.setK(new PainterFrame(), new PainterPanel());
		frame.setVisible(true);
		frame.repaint();
	}

}
