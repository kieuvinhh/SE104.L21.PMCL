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

public class FMain {

	private JFrame frame;
	private JTextField txtIdts;
	private JTextField txtHoten;
	private JTextField txtNgaysinh;
	private JTextField txtNoisinh;
	private JTextField txtHktt;
	private JTextField txtKhuvuc;
	private JTextField txtNamtn;
	private JTextField txtHeth;
	private JTextField txtDcbt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMain window = new FMain();
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
	public FMain() {
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
		
		JLabel lblNewLabel = new JLabel("ID_TS");
		lblNewLabel.setBounds(38, 10, 74, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("hoten");
		lblNewLabel_1.setBounds(38, 39, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ngaysinh");
		lblNewLabel_2.setBounds(38, 62, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("noisinh");
		lblNewLabel_3.setBounds(38, 89, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("HKTT");
		lblNewLabel_4.setBounds(38, 112, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("khuvuc");
		lblNewLabel_5.setBounds(38, 137, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("namTN");
		lblNewLabel_6.setBounds(38, 160, 45, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("heTH");
		lblNewLabel_7.setBounds(38, 187, 45, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("DCBT");
		lblNewLabel_8.setBounds(38, 216, 45, 13);
		frame.getContentPane().add(lblNewLabel_8);
		
		txtIdts = new JTextField();
		txtIdts.setBounds(93, 16, 203, 19);
		frame.getContentPane().add(txtIdts);
		txtIdts.setColumns(10);
		
		txtHoten = new JTextField();
		txtHoten.setBounds(93, 36, 203, 19);
		frame.getContentPane().add(txtHoten);
		txtHoten.setColumns(10);
		
		txtNgaysinh = new JTextField();
		txtNgaysinh.setBounds(93, 59, 203, 19);
		frame.getContentPane().add(txtNgaysinh);
		txtNgaysinh.setColumns(10);
		
		txtNoisinh = new JTextField();
		txtNoisinh.setBounds(93, 86, 203, 19);
		frame.getContentPane().add(txtNoisinh);
		txtNoisinh.setColumns(10);
		
		txtHktt = new JTextField();
		txtHktt.setBounds(93, 109, 203, 19);
		frame.getContentPane().add(txtHktt);
		txtHktt.setColumns(10);
		
		txtKhuvuc = new JTextField();
		txtKhuvuc.setBounds(93, 134, 203, 19);
		frame.getContentPane().add(txtKhuvuc);
		txtKhuvuc.setColumns(10);
		
		txtNamtn = new JTextField();
		txtNamtn.setBounds(93, 157, 203, 19);
		frame.getContentPane().add(txtNamtn);
		txtNamtn.setColumns(10);
		
		txtHeth = new JTextField();
		txtHeth.setBounds(93, 184, 203, 19);
		frame.getContentPane().add(txtHeth);
		txtHeth.setColumns(10);
		
		txtDcbt = new JTextField();
		txtDcbt.setBounds(93, 213, 203, 19);
		frame.getContentPane().add(txtDcbt);
		txtDcbt.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		btnNewButton.setBounds(315, 85, 111, 65);
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
			String query = "insert into thisinh values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps =conn.prepareStatement(query);
			ps.setString(1, txtIdts.getText());
			ps.setString(2, txtHoten.getText());
			ps.setString(3, txtNgaysinh.getText());
			ps.setString(4, txtNoisinh.getText());
			ps.setString(5, txtHktt.getText());
			ps.setString(6, txtKhuvuc.getText());
			ps.setString(7, txtNamtn.getText());
			ps.setString(8, txtHeth.getText());
			ps.setString(9, txtDcbt.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved!");
		}catch (Exception e) {
			System.out.println("error: "+ e);
		}
	}
}
