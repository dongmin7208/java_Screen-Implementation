package day01;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;

public class MyFrame01 extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	private Button bt1 = new Button("bt1");
	
	private void init() {
		//������Ʈ ��� 
		this.add(bt1);
	}
	private void eventInit() {
		//�̺�Ʈ ���
	}
	
	public MyFrame01(String t, int w, int h) {
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
		MyFrame01 f = new MyFrame01("����", 400, 500);
		f.setVisible(true);
	}
}
