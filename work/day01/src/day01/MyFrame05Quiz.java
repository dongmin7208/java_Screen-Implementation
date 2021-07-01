package day01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;

public class MyFrame05Quiz extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	private Button bt1 = new Button("bt1");
	private Panel pn1 = new Panel();
	private GridLayout gl1 = new GridLayout(1,2); 

	private Button bt2 = new Button("bt2");
	private Button bt3 = new Button("bt3");	
	private Panel pn2 = new Panel();
	private GridLayout gl2 = new GridLayout(2,1); 

	private void init() {
		//������Ʈ ��� 
		pn1.setLayout(gl1);
		pn1.add(bt1);
		pn1.add(pn2);
		
		pn2.setLayout(gl2);
		pn2.add(bt2);
		pn2.add(bt3);
		
		this.add(pn1, BorderLayout.SOUTH);
	}
	private void eventInit() {
		//�̺�Ʈ ���
	}
	
	public MyFrame05Quiz(String t, int w, int h) {
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
		MyFrame05Quiz f = new MyFrame05Quiz("����", 400, 500);
		f.setVisible(true);
	}
}
