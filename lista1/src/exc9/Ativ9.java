package exc9;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Ativ9 extends JFrame {

	private JPanel contentPane;
	private JTextField textCpf;
	private JTextField textNome;
	private JTextField textEmail;
	Connection conexao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ativ9 frame = new Ativ9();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ativ9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(57, 56, 66, 32);
		contentPane.add(lblNewLabel);
		
		textCpf = new JTextField();
		textCpf.setBounds(123, 65, 179, 19);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(57, 108, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textNome = new JTextField();
		textNome.setBounds(123, 107, 179, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(57, 154, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textEmail = new JTextField();
		textEmail.setBounds(123, 153, 179, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + "baquinhodasofi","root","8-EeP&;ZIX");
					String wSQL= "INSERT INTO pessoas(cpf, nome, email) VALUES (?,?,?)";
					PreparedStatement stm = conexao.prepareStatement(wSQL);
					
					Long cpf = Long.valueOf(textCpf.getText());
					
					stm.setLong(1,cpf);
					stm.setString(2, textNome.getText());
					stm.setString(3,textEmail.getText());
					
					stm.executeUpdate();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 
				
				textCpf.setText("");
				textNome.setText("");
				textEmail.setText("");
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(157, 216, 118, 21);
		contentPane.add(btnCadastrar);
	}
}
