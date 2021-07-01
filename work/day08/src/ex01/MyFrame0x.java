package ex01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame0x extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	private Button bt1 = new Button("bt1");
	
	private void init() {
		//������Ʈ ��� 
		this.add(bt1, BorderLayout.SOUTH);
		
	}
	private void eventInit() {
		//�̺�Ʈ ���
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("repaint()ȣ��");
				y1 += 10;
				y2 += 10;
				repaint();
			}
		});
	}
	
	public MyFrame0x(String t, int w, int h) {
		super(t);
		size.width = w;
		size.height = h;
		setSize(size);
		loc.x = (screenSize.width/2) - (getWidth()/2) + 1920;
		loc.y = (screenSize.height/2) - (getHeight()/2);
		setLocation(loc);
		setResizable(true);
		
		init();	//������Ʈ�� �ʱ�ȭ �ϴ� �޼���
		eventInit();	//�̺�Ʈ�� ����ϴ� �޼���
	}
	int x1 = 100;
	int y1 = 100;
	int x2 = 200;
	int y2 = 200;
	@Override
	public void paint(Graphics g) {
		System.out.println("paintȣ��");
		g.drawLine(x1, y1, x2, y2);
		super.paint(g);
	}

	//update�Լ��� �������̵� ���� ����.
	//update�Լ��� ����� ȭ���� Ŭ�����ϰ� paint()�޼��� ȣ��
	//update�� ȣ��Ǵ� ������ repaint()�޼��� ȣ�� ��
	@Override	
	public void update(Graphics g) {	
		System.out.println("updateȣ��");
		//super.update(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		paint(g);
	}
	
	public static void main(String[] args) {
		MyFrame0x f = new MyFrame0x("����", 400, 500);
		f.setVisible(true);
	}
}
