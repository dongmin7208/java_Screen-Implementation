package day06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;


public class MyJFrame01 extends JFrame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	JPanel contentPane;
	private JButton jbt1 = new JButton("EMPTY");
	private JButton jbt2 = new JButton("LINE");
	private JButton jbt3 = new JButton("ETCHED");
	private JButton jbt4 = new JButton("BEVEL");
	private JButton jbt5 = new JButton("SOFTBEVEL");
	private JButton jbt6 = new JButton("MATTE");
	private JButton jbt7 = new JButton("TITLED");
	private JButton jbt8 = new JButton("COMPOUND");
	
	private GridLayout gl = new GridLayout(4, 2, 5, 5);
	
	private void init() {
		//contentPane�� �̿��Ͽ� ������Ʈ ���
		contentPane.setLayout(gl);
		EmptyBorder b1 = new EmptyBorder(5, 3, 5, 3);//���� �������� ������� �������� ��Ÿ����.
		jbt1.setBorder(b1);                          //�ٸ� ��ư���� �� Ʋ���� ����� ����� ��Ÿ��.
		contentPane.add(jbt1);
		LineBorder b2 = new LineBorder(Color.RED, 3);//���ο� ���� 3�ȼ���ŭ
		jbt2.setBorder(b2);
		contentPane.add(jbt2);
		EtchedBorder b3 = new EtchedBorder();//���ο� Ȩ�� �����ִ� ���
		jbt3.setBorder(b3);
		contentPane.add(jbt3);	
		BevelBorder b4 = new BevelBorder(BevelBorder.RAISED);//���� �ö����(LOWERED) ������ ��������
		jbt4.setBorder(b4);
		contentPane.add(jbt4);
		SoftBevelBorder b5 = new SoftBevelBorder(SoftBevelBorder.LOWERED);//�����̰� �ձ۰� ������ �ϴ°�
		jbt5.setBorder(b5);
		contentPane.add(jbt5);
		MatteBorder b6 = new MatteBorder(5, 10, 15, 20, Color.BLUE); //�β��� ������� ���ϴ� ���κ�������
		jbt6.setBorder(b6);
		contentPane.add(jbt6);
		TitledBorder b7 = new TitledBorder("����");//Ÿ��Ʋ�� �޼� �ְ� ���ִ� ����, ��ġ������ �Ҽ��ִ�.
		jbt7.setBorder(b7);
		contentPane.add(jbt7);		
		SoftBevelBorder b8 = new SoftBevelBorder(SoftBevelBorder.RAISED);
		TitledBorder b9 = new TitledBorder("������");
		CompoundBorder b10 = new CompoundBorder(b8, b9);//��� ���� ������
		jbt8.setBorder(b10);
		contentPane.add(jbt8);
		
	}
	private void eventInit() {
	}
	
	public MyJFrame01(String t, int w, int h) {
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
		MyJFrame01 f = new MyJFrame01("����", 400, 500);
		f.setVisible(true);
	}
}
