package exc10;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import exc9.Cadastro;
import exc10.People;

public class TelaConsultar extends JFrame {

	private JPanel contentPane;
	Connection conexao;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultar frame = new TelaConsultar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TelaConsultar() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 10, 682, 433);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] {"CPF", "Nome", "Email"});
		
		ArrayList<People> List = new ArrayList<>();
		
		conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + "baquinhodasofi","root","");
			
			String wSQL = "SELECT * FROM pessoas";
			Statement stm = conexao.prepareStatement(wSQL);
			ResultSet rs = stm.executeQuery(wSQL);
			
			while (rs.next()) {
				
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				
				People p = new People(cpf, nome, email);
				
				List.add(p);
			}
			
			for (People pessoa : List) {
				modelo.addRow(new Object[] {
						pessoa.getCpf(), pessoa.getNome(), pessoa.getEmail()
				});
			}
			
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			JButton btnNewButton = new JButton("CADASTRO");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cadastro cad = new Cadastro();
					cad.setLocationRelativeTo(null);
					cad.setVisible(true);
					dispose();
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(325, 472, 133, 38);
			contentPane.add(btnNewButton);
			
			
			
			
	}
}
