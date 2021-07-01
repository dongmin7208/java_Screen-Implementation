package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ManageController;
import model.InfoVO;

public class InputJFrame extends JFrame {

	private JPanel contentPane;
	private MainJFrame parentContentPane;
	private JLabel lbName;
	private JLabel lbAge;
	private JTextField jtfName;
	private JTextField jtfAge;
	private JButton btnInsert;
	private JButton btnCancel;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InputJFrame frame = new InputJFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public InputJFrame(MainJFrame pane) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 250, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		parentContentPane = pane;
		

		lbName = new JLabel("이름");
		jtfName = new JTextField(15);
		JPanel namePane = new JPanel();
		//namePane.setLayout(new GridLayout(1, 2));
		namePane.add(lbName);
		namePane.add(jtfName);

		lbAge = new JLabel("나이");
		jtfAge = new JTextField(15);
		JPanel agePane = new JPanel();
		agePane.add(lbAge);
		agePane.add(jtfAge);
		
		JPanel inputPane = new JPanel();
		inputPane.setLayout(new GridLayout(2, 1));
		inputPane.add(namePane);
		inputPane.add(agePane);

		btnInsert = new JButton("저장");
		btnInsert.addActionListener((e)->{
			ManageController controller = ManageController.getInstance();
			parentContentPane.addModel(new InfoVO(-1, jtfName.getText(), Integer.parseInt(jtfAge.getText())));
			btnCancel.doClick();
		});
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e)->{
			jtfName.setText("");
			jtfAge.setText("");
			this.setVisible(false);
		});
		JPanel btnPane = new JPanel();
		btnPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnPane.add(btnInsert);
		btnPane.add(btnCancel);
		
		contentPane.add(inputPane, BorderLayout.CENTER);
		contentPane.add(btnPane, BorderLayout.SOUTH);
		setContentPane(contentPane);
	}

}
