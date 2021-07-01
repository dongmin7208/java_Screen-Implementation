package ex02;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * ����͸� �����Ͽ� �̺�Ʈ�� ����ϴ� ���
 */


class MyActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("�̺�Ʈ�� �߻��� ��ü:" + arg0);
		System.out.println("��ư�̺�Ʈ �߻�!");
	}
	
}

class MyMouseListener extends MouseAdapter{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked");
	}
	
}

class MyWindowListener extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

public class MyFrame0x extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	private Button bt1 = new Button("bt1");
	private Button bt2 = new Button("bt2");
	
	private void init() {
		//������Ʈ ���
		this.add(bt1);
		this.add(bt2, BorderLayout.NORTH);
		
	}
	private void eventInit() {
		System.out.println("bt1��ü:" + bt1);
		bt1.addActionListener(new MyActionListener());//��ư�� �̺�Ʈ�� ���!
		bt2.addMouseListener(new MyMouseListener());
		this.addWindowListener(new MyWindowListener());
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
