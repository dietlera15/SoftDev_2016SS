package at.fhj.swd;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class MainWindow  extends JFrame{
	private JLabel lblPicture;
	private JButton btnNext;
	public MainWindow() {
		super();
		initUi();
		setSize(300, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initUi(){
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		lblPicture = new JLabel("");
		main.add(lblPicture,BorderLayout.CENTER);
		JPanel pnlButton = new JPanel();
		btnNext = new JButton("Next Cat!");
		pnlButton.add(btnNext);
		main.add(pnlButton,BorderLayout.SOUTH);
		getContentPane().add(main);
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadCatPicture();
			}
		});
	}

	private static final String API_URL = "http://thecatapi.com/api/images/get?format=src&type=jpg";
	private void loadCatPicture() {
		InputStream httpStream = null;
		try{
			URL url = new URL(API_URL);
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setRequestMethod("GET");
			httpStream = httpConnection.getInputStream();
			BufferedImage img =  ImageIO.read(httpStream);
			lblPicture.setIcon(new ImageIcon(img));
		}
		catch(IOException ex){
			JOptionPane.showMessageDialog(this, "Error while loading cat picture!");
		}
		finally{
			if(httpStream != null){
				try{
					httpStream.close();
				}
				catch(Exception ex){}
			}
		}
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
