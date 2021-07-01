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
	
	//이 아래로 컴포넌트 객체 정의
	private Button bt1 = new Button("bt1");
	
	private void init() {
		//컴포넌트 등록 
		this.add(bt1, BorderLayout.SOUTH);
		
	}
	private void eventInit() {
		//이벤트 등록
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("repaint()호출");
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
		
		init();	//컴포넌트를 초기화 하는 메서드
		eventInit();	//이벤트를 등록하는 메서드
	}
	int x1 = 100;
	int y1 = 100;
	int x2 = 200;
	int y2 = 200;
	@Override
	public void paint(Graphics g) {
		System.out.println("paint호출");
		g.drawLine(x1, y1, x2, y2);
		super.paint(g);
	}

	//update함수는 오버라이딩 하지 않음.
	//update함수의 기능은 화면을 클리어하고 paint()메서드 호출
	//update가 호출되는 시점은 repaint()메서드 호출 시
	@Override	
	public void update(Graphics g) {	
		System.out.println("update호출");
		//super.update(g);
		g.clearRect(0, 0, getWidth(), getHeight());
		paint(g);
	}
	
	public static void main(String[] args) {
		MyFrame0x f = new MyFrame0x("제목", 400, 500);
		f.setVisible(true);
	}
}
