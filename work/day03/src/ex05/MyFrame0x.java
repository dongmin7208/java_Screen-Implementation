package ex05;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*
 * �����ʸ� ���� �����Ͽ� �̺�Ʈ�� ����ϴ� ���
 */

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
		if(bt.getLabel().equals("bt1")) {
			lb.setText("bt1����");
		}else if(bt.getLabel().equals("bt2")) {
			lb.setText("bt2����");
		}

	}
	
}

public class MyFrame0x extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	private Label lb = new Label("��ư�� �����ּ���." , Label.CENTER);
	private Button bt1 = new Button("bt1");
	private Button bt2 = new Button("bt2");
	
	private void init() {
		//������Ʈ ���
		this.add(lb, BorderLayout.SOUTH);
		this.add(bt1);
		this.add(bt2, BorderLayout.NORTH);
		
	}
	private void eventInit() {
		System.out.println("bt1��ü:" + bt1);
		System.out.println("bt2��ü:" + bt2);
		bt1.addActionListener(new MyActionListener(lb));//��ư�� �̺�Ʈ�� ���!
		bt2.addActionListener(new MyActionListener(lb));
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
		MyFrame0x f = new MyFrame0x("����", 400, 500);
		f.setVisible(true);
	}
}
