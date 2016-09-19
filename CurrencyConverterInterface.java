package conversion;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Window.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyConverterInterface.
 */
public class CurrencyConverterInterface {

	/**
	 * Instantiates a new currency converter interface.
	 */
	public CurrencyConverterInterface() {
	}

	/**
	 * set up and display the swing application.
	 */
	public void display() {

		this.configFrame();
		this.buildComponents();
	}

	/**
	 * Builds the components.
	 */
	private void buildComponents() {

		this.buildTopPanelComponents();
		this.buildCenterPanelComponents();
		this.buildBottomPanelComponents();

		// set so that the window is the proper size when starting this
		// application
		this.jFrame.pack();
	}

	/**
	 * Builds the bottom panel components.
	 */
	private void buildBottomPanelComponents() {

		JPanel bottomPanel = new JPanel();

		JLabel jlblCanadian = new JLabel("Canadian: ");
		bottomPanel.add(jlblCanadian);

		this.jlblCanadianAmt = new JLabel("");
		this.jlblCanadianAmt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.jlblCanadianAmt.setPreferredSize(new Dimension(150, 15));
		bottomPanel.add(this.jlblCanadianAmt);

		JLabel jlblEuro = new JLabel("Euro:");
		bottomPanel.add(jlblEuro);

		this.jlblEuroAmt = new JLabel("");
		this.jlblEuroAmt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.jlblEuroAmt.setPreferredSize(new Dimension(150, 15));
		bottomPanel.add(this.jlblEuroAmt);

		JLabel jlblYen = new JLabel("Yen:");
		bottomPanel.add(jlblYen);

		this.jlblYenAmt = new JLabel("");
		this.jlblYenAmt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.jlblYenAmt.setPreferredSize(new Dimension(150, 15));
		bottomPanel.add(jlblYenAmt);

		this.jFrame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * Builds the center panel components.
	 */
	private void buildCenterPanelComponents() {

		JPanel centerPanel = new JPanel();

		JButton btnConvert = new JButton("Convert!");
		btnConvert.addActionListener(new CustomButtonListener());
		centerPanel.add(btnConvert);

		this.jFrame.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	/**
	 * Builds the top panel components.
	 */
	private void buildTopPanelComponents() {

		JPanel topPanel = new JPanel();

		JLabel jlblEnterAmount = new JLabel("Enter Amount in USD: ");
		topPanel.add(jlblEnterAmount);

		this.jtxtUserInput = new JTextField();
		this.jtxtUserInput.setColumns(8);
		topPanel.add(jtxtUserInput);

		this.jFrame.getContentPane().add(topPanel, BorderLayout.NORTH);
	}

	/**
	 * The listener interface for receiving customButton events. The class that
	 * is interested in processing a customButton event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's <code>addCustomButtonListener
	 * <code> method. When the customButton event occurs, that object's
	 * appropriate method is invoked.
	 *
	 * @see CustomButtonEvent
	 */
	class CustomButtonListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			new CurrencyWorker("Canadian", jtxtUserInput.getText(), jlblCanadianAmt).execute();
			new CurrencyWorker("Euro", jtxtUserInput.getText(), jlblEuroAmt).execute();
			new CurrencyWorker("Yen", jtxtUserInput.getText(), jlblYenAmt).execute();
		}
	}

	/**
	 * Configure the frame for this application.
	 */
	private void configFrame() {

		this.jFrame = new JFrame();
		jFrame.setAlwaysOnTop(true);
		jFrame.setType(Type.POPUP);
		this.jFrame.setVisible(true);
		this.jFrame.setTitle("Currency Conversion");
		this.jFrame.setResizable(false);
		this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		new CurrencyConverterInterface().display();
	}

	/** The label converted amt. */
	private JLabel jlblCanadianAmt;
	
	/** The label yen amt. */
	private JLabel jlblYenAmt;
	
	/** The label euro amt. */
	private JLabel jlblEuroAmt;

	/** The text field user input. */
	private JTextField jtxtUserInput;

	/** The frame. */
	private JFrame jFrame;
}
