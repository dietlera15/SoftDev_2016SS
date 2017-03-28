package at.fhj.swd;

import javax.swing.SwingUtilities;

public class SwingDemo {

	public static void main(String[] args) {
		/**
		 * eine anonyme klasse wird erstelle und die implementierung
		 * wird auch sofort eingef�gt.
		 */
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame main = new MainFrame();
				main.setVisible(true);
			}
		});
	}

}
