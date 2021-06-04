package database;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class phieubaodiem {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					phieubaodiem window = new phieubaodiem();
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
	public phieubaodiem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID_PBD");
		lblNewLabel.setBounds(47, 38, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID_TS");
		lblNewLabel_1.setBounds(47, 80, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("diem1");
		lblNewLabel_2.setBounds(47, 128, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("diem2");
		lblNewLabel_2_1.setBounds(47, 168, 45, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("diem3");
		lblNewLabel_2_2.setBounds(47, 210, 45, 13);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setBounds(113, 35, 172, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(113, 77, 172, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(113, 125, 172, 19);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(113, 165, 172, 19);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(113, 207, 172, 19);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		btnNewButton.setBounds(313, 103, 85, 53);
		frame.getContentPane().add(btnNewButton);
	}
	
	static Connection con() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/DATABASE";
			String username = "root";
			String password = "123456789";
			Class.forName(driver);
			System.out.println("Connected");
			return DriverManager.getConnection(url,username,password);
		}catch(Exception e) {System.out.println("Connection failed!" +e);}
		
		return null;
	}
	
	private void SaveToDatabase() {
		Connection conn = con();
		try {
			String query = "insert into duthi values(?,?,?,?,?)";
			PreparedStatement ps =conn.prepareStatement(query);
			ps.setString(1, textField.getText());
			ps.setString(2, textField_1.getText());
			ps.setString(3, textField_2.getText());
			ps.setString(4, textField_3.getText());
			ps.setString(5, textField_4.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!");
		}catch (Exception e) {
			System.out.println("error: "+ e);
		}
	}

}
