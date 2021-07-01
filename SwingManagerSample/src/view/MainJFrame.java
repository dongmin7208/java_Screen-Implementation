package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import controller.ManageController;
import model.Database;
import model.InfoVO;

public class MainJFrame extends JFrame {
	
	public static final int NONE = 0;
	
	public static final int INSERT = 1;
	public static final int UPDATE = 2;
	public static final int UPDATING = 22;
	public static final int DELETE = 3;
	public static final int DELETING = 33;
	public static final int SEARCH = 4;

	public static final int COLUMN_SIZE = 3;
	
	protected int action;

	private JPanel contentPane;
	private JTable table;
	private InputJFrame ijf;
	private ManageController controller;

		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
					frame.setResizable(false);
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
	
	private DefaultTableModel model = null;
	private JTextField textField;
	public MainJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
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
		setTitle("관리프로그램 샘플");
		controller = ManageController.getInstance();
		
		ijf = new InputJFrame(this);
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		//샘플데이터 삽입
		int size = (Integer)controller.requestProcess("size", null);
		Object[][] data = new Object[size][COLUMN_SIZE];
		ArrayList<InfoVO> listTmp = (ArrayList<InfoVO>) controller.requestProcess("list", null);
		for(int i = 0; i < listTmp.size(); i++) {
			data[i][0] = listTmp.get(i).getNo();
			data[i][1] = listTmp.get(i).getName();
			data[i][2] = listTmp.get(i).getAge();
		}
		model = new DefaultTableModel(
				data ,
				new String[] {
					"번호", "이름", "나이"
				}
			);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_1.add(table);
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_1.add(scrollPane);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		
		JButton btnInsert = new JButton("등록하기");
		panel.add(btnInsert);
		JButton btnModify = new JButton("수정하기");
		panel.add(btnModify);
		JButton btnDelete = new JButton("삭제하기");
		panel.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("번호로 검색");
		comboBox.addItem("이름으로 검색");
		comboBox.addItem("나이로 검색");
		
		panel_2.add(comboBox);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(15);
		
		JButton button = new JButton("검색");
		panel_2.add(button);
		
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				action = MainJFrame.INSERT;
				ijf.setVisible(true);
			}
		});
		
		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				action = MainJFrame.UPDATE;
				if(!table.isEnabled()) {
					popup(MainJFrame.UPDATE, "");
					btnModify.setText("수정완료");
					btnInsert.setEnabled(false);
					btnDelete.setEnabled(false);
					table.setEnabled(true);
				}else {
					if(table.isEditing()) {
						popup(MainJFrame.UPDATING, "");
						return;
					}
					action = MainJFrame.NONE;
					btnModify.setText("수정하기");
					table.clearSelection();
					table.setEnabled(false);
					btnInsert.setEnabled(true);
					btnDelete.setEnabled(true);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				action = MainJFrame.DELETE;
				if(!table.isEnabled()) {
					btnDelete.setText("삭제완료");
					btnInsert.setEnabled(false);
					btnModify.setEnabled(false);
					table.setEnabled(true);
				}else {
					btnDelete.setText("삭제하기");
					table.setEnabled(false);
					btnInsert.setEnabled(true);
					btnModify.setEnabled(true);
				}
				if(action == MainJFrame.DELETE) {
					int row = table.getSelectedRow();
					System.out.println(row);
					if(row == -1) {
						popup(MainJFrame.DELETE, "");
					}else {
						int ret = popup(MainJFrame.DELETING, table.getValueAt(row, 1) + " 님 정보를 정말 삭제하시겠습니까?");
						System.out.println("삭제선택:" + ret);
						if(ret == JOptionPane.CANCEL_OPTION) {
							action = MainJFrame.NONE;
							table.clearSelection();
						}else {
							System.out.println(row);
							int delNo = (Integer)table.getValueAt(row, 0);
							System.out.println("삭제할 테이블 인덱스:" + delNo);
							model.removeRow(row);
							controller.requestProcess("delete", new InfoVO(delNo, "", -1));
						}
						action = MainJFrame.NONE;
					}
				}
			}
		});

		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				int row = 0;
				int no = 0;
				String name = "";
				int age = 0;
				switch(action) {
				case MainJFrame.UPDATE:
					row = table.getSelectedRow();
					System.out.println(
							"[" + table.getValueAt(row, 0) + ", " + 
								  table.getValueAt(row, 1) + ", " + 
								  table.getValueAt(row, 2) + "] ");
				
					no = (Integer)table.getValueAt(row, 0);
					name = (String)table.getValueAt(row, 1);
					age = Integer.parseInt(table.getValueAt(row, 2).toString());
					InfoVO vo = new InfoVO(no, name, age);
					controller.requestProcess("update", vo);
					break;
				case MainJFrame.DELETE:
				}
			}
		});
	}
	public void addModel(InfoVO vo) {
		action = MainJFrame.INSERT;
		vo = (InfoVO)controller.requestProcess("insert", vo);
		model.addRow(new Object[] {vo.getNo(), vo.getName(), vo.getAge()});
	}
	
	public int popup(int ac, String message) {
		int warn = 0;
		int op = JOptionPane.CLOSED_OPTION;
		switch(ac) {
		case MainJFrame.UPDATE:
			message = "테이블 수정 후 완료를 클릭하세요.";
			break;
		case MainJFrame.DELETE:
			message = "삭제할 행을 선택하고 완료를 클릭하세요.";
			break;
		case MainJFrame.UPDATING:
			message = "수정 중 입니다. 엔터를 입력하여 완료 후 수정완료를 클릭하세요.";
			break;
		case MainJFrame.DELETING:
			warn = JOptionPane.WARNING_MESSAGE;
			op = JOptionPane.OK_CANCEL_OPTION;
		}
		return JOptionPane.showConfirmDialog(this, message, "알림", op, warn);
	}
}
