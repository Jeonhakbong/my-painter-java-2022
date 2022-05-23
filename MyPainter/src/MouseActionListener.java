import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MouseActionListener implements ActionListener{
	MyPanel mp;
	public MouseActionListener(MyPanel mp) {
		this.mp = mp;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		mp.setFigureType(e.getSource());
    }
}


class ColorActionListener implements ActionListener{
	MyPanel mp;
	public ColorActionListener(MyPanel mp) {
		this.mp = mp;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		mp.setColorType(e.getSource());
    }
}

class EditActionListener implements ActionListener{
	MyPanel mp;
	public EditActionListener(MyPanel mp) {
		this.mp = mp;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		mp.setEditType(e.getSource());
    }
}