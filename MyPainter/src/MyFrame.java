
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame(String title) {
		super(title);
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new MyPanel());
		this.setVisible(true);
	}
}