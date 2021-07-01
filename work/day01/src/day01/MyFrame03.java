package day01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;

public class MyFrame03 extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	private Button bt1 = new Button("bt1");
	private Button bt2 = new Button("bt2");
	private Panel pn1 = new Panel();
	private Button bt3 = new Button("bt3");
	private Button bt4 = new Button("bt4");
	private Button bt5 = new Button("bt5");
	private void init() {
		//������Ʈ ��� 
		pn1.add(bt1);
		pn1.add(bt2);
		//Panel�� default ���̾ƿ��� FlowLayout�̴�.
		pn1.setLayout(new GridLayout(1, 2));
		this.add(pn1, BorderLayout.SOUTH);
		
		this.add(bt3, BorderLayout.EAST);
		this.add(bt4, BorderLayout.WEST);
		this.add(bt5, "Center");
	}
	private void eventInit() {
		//�̺�Ʈ ���
	}
	
	public MyFrame03(String t, int w, int h) {
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
		MyFrame03 f = new MyFrame03("����", 400, 500);
		f.setVisible(true);
	}
}
