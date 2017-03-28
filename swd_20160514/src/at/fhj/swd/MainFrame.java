package at.fhj.swd;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private JTextField tfCurrency;
	private JLabel lblOutput;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hello SWD");
		setSize(300, 200);
		
		getContentPane().setLayout(new BorderLayout());
		createMenuBar();
		
		createMainContent();
		
	}
	
	private void createMainContent() {
		JPanel mainContent = new JPanel();
		BoxLayout boxLayout = new BoxLayout(mainContent, BoxLayout.Y_AXIS);
		mainContent.setLayout(boxLayout);
		
		mainContent.add(createCurrencyInputPane());
		mainContent.add(createConversionOutputPane());
		
		getContentPane().add(mainContent, BorderLayout.CENTER);
	}
	
	private JPanel createCurrencyInputPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JLabel lblCurrency = new JLabel("EUR:");
		tfCurrency = new JTextField();
		tfCurrency.setColumns(10);
		JButton btnConvert = new JButton("Convert");
		
		btnConvert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				performConversion();
				//JOptionPane.showMessageDialog(null, "You have clicked me!");
			}
		});
		
		panel.add(lblCurrency);
		panel.add(tfCurrency);
		panel.add(btnConvert);
		
		return panel;
	}
	
	private void performConversion() {
		try {
			String input = tfCurrency.getText();
			float inputCurrency = Float.parseFloat(input);
			final float EUR_USD_CONVERSION_RATE = 1.14f;
			float converted = inputCurrency * EUR_USD_CONVERSION_RATE;
			String outputText = String.format("%.2f EUR are %.2f USD.",  inputCurrency, converted);
			lblOutput.setText(outputText);
		} catch(NumberFormatException ex) {
			lblOutput.setText("Invalid Input");
		}
	}
	
	private JPanel createConversionOutputPane() {
		JPanel panel = new JPanel();
		lblOutput = new JLabel("Please enter amount above.");
		
		panel.setLayout(new FlowLayout());
		panel.add(lblOutput);
		
		return panel;
	}
	
	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuHelp = new JMenu("Help");
		
		JMenuItem miQuit = new JMenuItem("Quit");
		JMenuItem miAbout = new JMenuItem("About");
		
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		
		menuFile.add(miQuit);
		
		miQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menuHelp.add(miAbout);
		
		getContentPane().add(menuBar, BorderLayout.PAGE_START);
	}
}
