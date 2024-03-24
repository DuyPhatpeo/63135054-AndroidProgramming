package ntu_63135054;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLySach extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtTenSach;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable bangSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLySach frame = new QuanLySach();
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
	public QuanLySach() {
		setTitle("Quản lý sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 600);
		JPanel contentPane = new JPanel();
		contentPane.setToolTipText("Quản lý sách");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(5, 0, 255));
		panel.setBounds(0, 0, 1116, 86);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý sách");
		lblNewLabel.setBounds(471, 26, 153, 25);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 87, 507, 476);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 47, 124, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tác giả");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 119, 124, 24);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Năm xuất bản");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 188, 124, 24);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Thể loại");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(10, 257, 124, 24);
		panel_1.add(lblNewLabel_1_3);
		
		txtTenSach = new JTextField();
		txtTenSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenSach.setBounds(144, 47, 353, 24);
		panel_1.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(144, 119, 353, 24);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(144, 188, 230, 24);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(144, 257, 230, 24);
		panel_1.add(textField_2);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemSach();
			}
		});
		btnThem.setBackground(new Color(128, 255, 255));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBounds(20, 349, 124, 24);
		panel_1.add(btnThem);
		
		JButton btnChinhSua = new JButton("Chỉnh sửa");
		btnChinhSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhSuaSach();
			}
		});
		btnChinhSua.setBackground(new Color(0, 128, 255));
		btnChinhSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChinhSua.setBounds(172, 349, 124, 24);
		panel_1.add(btnChinhSua);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaSach();
			}
		});
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBounds(353, 349, 124, 24);
		panel_1.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(507, 87, 609, 476);
		contentPane.add(scrollPane);
		
		bangSach = new JTable();
		scrollPane.setViewportView(bangSach);
		bangSach.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "N\u0103m xu\u1EA5t b\u1EA3n", "Th\u1EC3 lo\u1EA1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bangSach.getColumnModel().getColumn(0).setResizable(false);
		bangSach.getColumnModel().getColumn(0).setPreferredWidth(39);
		bangSach.getColumnModel().getColumn(1).setResizable(false);
		bangSach.getColumnModel().getColumn(1).setPreferredWidth(99);
		bangSach.getColumnModel().getColumn(2).setResizable(false);
		bangSach.getColumnModel().getColumn(2).setPreferredWidth(115);
		bangSach.getColumnModel().getColumn(3).setResizable(false);
		bangSach.getColumnModel().getColumn(4).setResizable(false);
		bangSach.getColumnModel().getColumn(4).setPreferredWidth(111);
		bangSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}
	private void ThemSach() {
		
	}
	private void ChinhSuaSach() {
		
	}
	private void XoaSach() {
		
	}

}
