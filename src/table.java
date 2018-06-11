import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class table extends JPanel{
	
	public void table() {
		
		setLayout(new BorderLayout());
		
		JPanel tables = new JPanel();
		add(tables, BorderLayout.WEST);
		
		JPanel list = new JPanel();
		add(list, BorderLayout.EAST);
	}
}
