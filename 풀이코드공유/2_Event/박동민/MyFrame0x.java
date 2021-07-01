package ex05;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * �����ʸ� ���� �����Ͽ� �̺�Ʈ�� ����ϴ� ���
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyActionListener implements ActionListener{
	private Label lb = null;
	
	public MyActionListener(Label lb) {
		this.lb = lb;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("�̺�Ʈ�� �߻��� ��ü:" + arg0.getSource());
		System.out.println("��ư�̺�Ʈ �߻�!");
		Button bt = (Button)arg0.getSource();
		//arg0.getSource() �̺�Ʈ�� �߻��� ������Ʈ ������ ��ȯ�ϴ� �޼���
		//�ٿ�ĳ�����ؼ� �ش� ������Ʈ�� ����� Ȱ���� �� �ִ�.
		System.out.println(bt.getLabel());
		if(bt.getLabel().equals("Left")) {
			lb.setText("���� ��ư�� �������ϴ�.");
		}else if(bt.getLabel().equals("Right")) {
			lb.setText("������ ��ư�� �������ϴ�.");
		}

	}
	
}

public class MyFrame0x extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	private GridLayout gl2 = new GridLayout(2,0); 
	private Label lb = new Label("��ư�� �����ּ���." , Label.CENTER);
	private Font font = new Font("����ü", Font.ITALIC, 20);
	
	private GridLayout gl1 = new GridLayout(1,1); 
	private Panel pn1 = new Panel();
	private Button bt1 = new Button("Left");
	private Button bt2 = new Button("Right");
	private void init() {
		//������Ʈ ���
		pn1.setLayout(gl1);
		pn1.add(bt1,BorderLayout.SOUTH);
		pn1.add(bt2,BorderLayout.SOUTH);
		lb.setFont(font);
		this.setLayout(gl2);
		this.add(lb, BorderLayout.NORTH);
//		this.add(bt1,BorderLayout.SOUTH);
//		this.add(bt2, BorderLayout.SOUTH);
		this.add(pn1, BorderLayout.SOUTH);
		
	}
	private void eventInit() {
		System.out.println("bt1��ü:" + bt1);
		System.out.println("bt2��ü:" + bt2);
		bt1.addActionListener(new MyActionListener(lb));//��ư�� �̺�Ʈ�� ���!
		bt2.addActionListener(new MyActionListener(lb));
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public MyFrame0x(String t, int w, int h) {
		super(t);
		size.width = w;
		size.height = h;
		setSize(size);
		loc.x = (screenSize.width/2) - (getWidth()/2);
		loc.y = (screenSize.height/2) - (getHeight()/2);
		setLocation(loc);
		setResizable(false);
		
		init();	//������Ʈ�� �ʱ�ȭ �ϴ� �޼���
		eventInit();	//�̺�Ʈ�� ����ϴ� �޼���
	}
	
	public static void main(String[] args) {
		MyFrame0x f = new MyFrame0x("Event Ex01", 300, 150);
		f.setVisible(true);
	}
}
