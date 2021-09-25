import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class GUI {

	private JFrame frame;
	private Manager manager = new Manager();
	JTextArea tfOrderSummary = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfOrderSummary.setBounds(10, 59, 335, 95);
		frame.getContentPane().add(tfOrderSummary);
		
		JButton btnBigMac = new JButton("Big Mac");
		btnBigMac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addList("BigMac");
				Formatierer();
			}
		});
		btnBigMac.setBounds(10, 161, 89, 23);
		frame.getContentPane().add(btnBigMac);
		
		JLabel lblNewLabel = new JLabel("Order Summary:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(0, 0, 414, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCola = new JButton("Cola");
		btnCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addList("Cola");
				Formatierer();
			}
		});
		btnCola.setBounds(120, 161, 89, 23);
		frame.getContentPane().add(btnCola);
		
		JButton btnCheeseBurger = new JButton("CheeseBurger");
		btnCheeseBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.addList("CheeseBurger");
				Formatierer();
			}
		});
		btnCheeseBurger.setBounds(10, 195, 166, 23);
		frame.getContentPane().add(btnCheeseBurger);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnOrder.setBounds(313, 208, 111, 42);
		frame.getContentPane().add(btnOrder);
		

	}
	
	public void Formatierer() {
		List<String> Unikate = new List<String>();
		Unikate = manager.getUniques();
		tfOrderSummary.setText(null);
		Unikate.toFirst();
		while(Unikate.hasAccess()) {
			//Debug: System.out.println("tf append : "+Unikate.getContent()+" x"+manager.getOrderAmount(Unikate.getContent()));
			tfOrderSummary.append(Unikate.getContent()+" x"+manager.getOrderAmount(Unikate.getContent())+"\n");
			Unikate.next();
		}
	}
}
