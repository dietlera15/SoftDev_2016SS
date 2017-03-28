package swd_20160616;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainWindow extends JFrame{

	public MainWindow() {
		super();
		createCombo();
		this.pack();
	}
	
	public void createCombo() {
		JComboBox cb = new JComboBox(new String[]
				{"SWD","ITM","IMA"});
		
		cb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxSelectionChanged();
			}
		});
		getContentPane().add(cb);
	}
	
	public void comboBoxSelectionChanged(){
		
	}
	
	
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainWindow wnd = new MainWindow();
				wnd.setVisible(true);
			}
			
		});
		
	}
}
