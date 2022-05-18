import java.awt.event.ActionEvent;

interface MyActionListener {
	public void actionPerformed(ActionEvent e);
}


// three types of button action listener.
class MyRectListener implements MyActionListener{
	MyPanel mp; // panel parent.
	
	public MyRectListener(MyPanel mp) {
		this.mp = mp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mp.setButtonType(e.getSource());
	}
	
}


class MyOvalListener implements MyActionListener{
	MyPanel mp;
	
	public MyOvalListener(MyPanel mp) {
		this.mp = mp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mp.setButtonType(e.getSource());
	}
	
}


class MyLineListener implements MyActionListener{
	MyPanel mp;
	
	public MyLineListener(MyPanel mp) {
		this.mp = mp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mp.setButtonType(e.getSource());
	}
	
}
