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

//	   private JDialog d1 = new JDialog(this, "등록", true);

	 
	//이 아래로 컴포넌트 객체 정의
	
//	
//	private String[] Search = new String[] { "번호로검색 ", "이름으로 검색", "나이로 검색"};
//	private String[] header = new String[] {"번호","이름","나이"};
//	
	private JDialog dlg1 = new JDialog(this,"등록",true);
	private JLabel info = new JLabel("이름", JLabel.CENTER);
	private JLabel info2 = new JLabel("나이", JLabel.CENTER);
	private TextField info3 = new TextField();
	private TextField info4 = new TextField();
	private JButton bt1 = new JButton("등록");
	private JButton bt2 = new JButton("취소");
	//등록패널
	
	private JDialog dlg2 = new JDialog(this,"알림",true);
	private JLabel info5 = new JLabel("테이블 수정후 완료를 클릭하세요.", JLabel.CENTER);
	private JButton bt3 = new JButton("확인");
	
	
	private JDialog dlg3 = new JDialog(this,"삭제",true);
	
	
	
	private JPanel dp1 = new JPanel(); //등록 패널
	private JPanel dp2 = new JPanel(); //등록패널
	private JPanel dp3 = new JPanel(); //수정패널
	private JPanel dp4 = new JPanel(); //수정패널
	private JPanel dp5 = new JPanel(); //삭제패널
	private JPanel dp6 = new JPanel(); //삭제패널

	
//	private Dialog dlg2 = new Dialog(this,"수정하기",true);
//	private Dialog dlg3 = new Dialog(this,"삭제하기",true);
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
		//등록패널
		dp1.setLayout(new GridLayout(2,2,10,10));
		dp1.add(info); dp1.add(info3); dp1.add(info2); dp1.add(info4);
		dlg1.add(dp1);
		
		dp2.add(bt1); dp2.add(bt2);
		dlg1.add(dp2, "South");
		
		dp3.setLayout(new GridLayout(2,1,10,10));
		dp3.add(info5); dp3.add(bt3);
		dlg2.add(dp3);
		
		
		name.add("번호");
		name.add("이름");
		name.add("나이");
	
		model = new DefaultTableModel(name, 0);
		table = new JTable(model);
	
		sp1 = new JScrollPane(table);
		table.enable(false);  //리스트 손 못대게
	
		contentPane.add(sp1,"Center");
		
//	value = new Vector();
	
//	value.add(1);
//	value.add("홍길동");
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
		
		JButton btnNewButton = new JButton("등록하기");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg1.setSize(200,150);
				dlg1.setLocation(300,300);
				dlg1.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("수정하기");
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
				btnNewButton_2.setText("수정완료");
				
				
				
				super.mouseClicked(e);
			}
			
		});

		
		JButton btnNewButton_1 = new JButton("삭제하기");
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg1.setSize(200,150);
				dlg1.setLocation(300,300);
				dlg1.setVisible(true);
			}
		});
		
		init();	//컴포넌트를 초기화 하는 메서드
		eventInit();	//이벤트를 등록하는 메서드
	}

}
