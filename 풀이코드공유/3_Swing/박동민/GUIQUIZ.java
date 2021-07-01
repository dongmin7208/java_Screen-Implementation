package day30;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GUIQUIZ extends JFrame {

	
	private int count = 1;
	   private JPanel contentPane;
	   private JTextField textField;
	   private JTable table;
	   private DefaultTableModel model;
	   
	   private Vector<String> name = new Vector<String>();
	   private Vector value;
	   private JScrollPane sp1;

//	   private JDialog d1 = new JDialog(this, "���", true);

	 
	//�� �Ʒ��� ������Ʈ ��ü ����
	
//	
//	private String[] Search = new String[] { "��ȣ�ΰ˻� ", "�̸����� �˻�", "���̷� �˻�"};
//	private String[] header = new String[] {"��ȣ","�̸�","����"};
//	
	private JDialog dlg1 = new JDialog(this,"���",true);
	private JLabel info = new JLabel("�̸�", JLabel.CENTER);
	private JLabel info2 = new JLabel("����", JLabel.CENTER);
	private TextField info3 = new TextField();
	private TextField info4 = new TextField();
	private JButton bt1 = new JButton("���");
	private JButton bt2 = new JButton("���");
	//����г�
	
	private JDialog dlg2 = new JDialog(this,"�˸�",true);
	private JLabel info5 = new JLabel("���̺� ������ �ϷḦ Ŭ���ϼ���.", JLabel.CENTER);
	private JButton bt3 = new JButton("Ȯ��");
	
	
	private JDialog dlg3 = new JDialog(this,"����",true);
	
	
	
	private JPanel dp1 = new JPanel(); //��� �г�
	private JPanel dp2 = new JPanel(); //����г�
	private JPanel dp3 = new JPanel(); //�����г�
	private JPanel dp4 = new JPanel(); //�����г�
	private JPanel dp5 = new JPanel(); //�����г�
	private JPanel dp6 = new JPanel(); //�����г�

	
//	private Dialog dlg2 = new Dialog(this,"�����ϱ�",true);
//	private Dialog dlg3 = new Dialog(this,"�����ϱ�",true);
//	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIQUIZ frame = new GUIQUIZ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void init() {
		//����г�
		dp1.setLayout(new GridLayout(2,2,10,10));
		dp1.add(info); dp1.add(info3); dp1.add(info2); dp1.add(info4);
		dlg1.add(dp1);
		
		dp2.add(bt1); dp2.add(bt2);
		dlg1.add(dp2, "South");
		
		dp3.setLayout(new GridLayout(2,1,10,10));
		dp3.add(info5); dp3.add(bt3);
		dlg2.add(dp3);
		
		
		name.add("��ȣ");
		name.add("�̸�");
		name.add("����");
	
		model = new DefaultTableModel(name, 0);
		table = new JTable(model);
	
		sp1 = new JScrollPane(table);
		table.enable(false);  //����Ʈ �� �����
	
		contentPane.add(sp1,"Center");
		
//	value = new Vector();
	
//	value.add(1);
//	value.add("ȫ�浿");
//	value.add(23);
//	
//	model.addRow(value);
	

	
		
	}
	private void eventInit() {
		bt1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				value = new Vector();
				value.add(count++);
				value.add(info3.getText());
				value.add(info4.getText());
				
				model.addRow(value);
				dlg1.setVisible(false);
				info3.setText(null);
				info4.setText(null);
				
			}
		});
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg1.setVisible(false);
				
			}
		});
		
		
	
	bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

	

	public GUIQUIZ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnFile.add(mntmNewMenuItem);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("����ϱ�");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg1.setSize(200,150);
				dlg1.setLocation(300,300);
				dlg1.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("�����ϱ�");
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg2.setSize(200,150);
				dlg2.setLocation(300,300);
				dlg2.setVisible(true);
			}
		});
		
		bt3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				table.enable(true);
				btnNewButton.setEnabled(false);
				dlg2.setVisible(false);
				btnNewButton_2.setText("�����Ϸ�");
				
				
				
				super.mouseClicked(e);
			}
			
		});

		
		JButton btnNewButton_1 = new JButton("�����ϱ�");
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg1.setSize(200,150);
				dlg1.setLocation(300,300);
				dlg1.setVisible(true);
			}
		});
		
		init();	//������Ʈ�� �ʱ�ȭ �ϴ� �޼���
		eventInit();	//�̺�Ʈ�� ����ϴ� �޼���
	}

}
