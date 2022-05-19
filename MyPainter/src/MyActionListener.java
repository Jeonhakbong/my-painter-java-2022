import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{
	MyPanel mp;
	public MyActionListener(MyPanel mp) {
		this.mp = mp;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
		mp.setButtonType(e.getSource());
    }
}

