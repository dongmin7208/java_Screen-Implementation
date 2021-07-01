package day06;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;


public class MyJFrame02 extends JFrame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	JPanel contentPane;	
	private ImageIcon ii1 = new ImageIcon("a.gif");//��ư�� �̹����� �־ ����Ҽ� �ִ�.
	private ImageIcon ii2 = new ImageIcon("b.gif");
	private ImageIcon ii3 = new ImageIcon("c.gif");
	private ImageIcon ii4 = new ImageIcon("d.gif");
	private JToggleButton jtb1 = new JToggleButton(ii1);
	private JToggleButton jtb2 = new JToggleButton("2");
	private JToggleButton jtb3 = new JToggleButton("3", ii3);//�̹����� ���ڸ� ���� ������ �ִ�.
	private JToggleButton jtb4 = new JToggleButton("4", ii4);
	
	private ButtonGroup bg = new ButtonGroup();//���� ��ư�� �ϳ����� ���ǵ��� �׷����� ���´�.
	
	private GridLayout gl = new GridLayout(1, 4, 5, 5);
	
	private void init() {
		//contentPane�� �̿��Ͽ� ������Ʈ ���
		contentPane.setLayout(gl);
		//jtb1.setEnabled(false);
		jtb1.setToolTipText("1�� ��ư�Դϴ�.");
		bg.add(jtb1); contentPane.add(jtb1);
		
		jtb2.setToolTipText("2�� ��ư�Դϴ�.");
		bg.add(jtb2); contentPane.add(jtb2);

		jtb3.setSelectedIcon(ii2);//������ ������ �̹����� �ٲ��.
		bg.add(jtb3); contentPane.add(jtb3);

		jtb4.setHorizontalTextPosition(SwingConstants.CENTER);//��ġ���� �������ִ� SwingConstants�������̽�
								//�¿�
		jtb4.setVerticalTextPosition(SwingConstants.BOTTOM);//���Ʒ�
		jtb4.setRolloverIcon(ii2);//��ư���� �ö󰡸� �̹����� �ٲپ� �ְڴ�.
		bg.add(jtb4); contentPane.add(jtb4);
		
		jtb1.setMnemonic('1');//�����ư�� ����� �ش�
		jtb2.setMnemonic('2');
		jtb3.setMnemonic('3');
		jtb4.setMnemonic('4');
	}
	private void eventInit() {
	}
	
	public MyJFrame02(String t, int w, int h) {
		super(t);
		size.width = w;
		size.height = h;
		setSize(size);
		loc.x = (screenSize.width/2) - (getWidth()/2);
		loc.y = (screenSize.height/2) - (getHeight()/2);
		setLocation(loc);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();	//�۾� �г�
		this.setContentPane(contentPane); //�����ӿ� �г��߰�
		init();	//������Ʈ�� �ʱ�ȭ �ϴ� �޼���
		eventInit();	//�̺�Ʈ�� ����ϴ� �޼���
	}
	
	public static void main(String[] args) {
		MyJFrame02 f = new MyJFrame02("����", 400, 500);
		f.setVisible(true);
	}
}
