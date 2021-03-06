package ex04;

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
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
 * 익명(중첩)클래스를 구현하여 이벤트를 등록하는 방법
 */

public class MyFrame0x extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//이 아래로 컴포넌트 객체 정의
	private Button bt1 = new Button("bt1");
	private Button bt2 = new Button("bt2");
	
	private void init() {
		//컴포넌트 등록
		this.add(bt1);
		this.add(bt2, BorderLayout.NORTH);
		
	}
	private void eventInit() {
		System.out.println("bt1객체:" + bt1);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				System.out.println("이벤트가 발생된 객체:" + e);
				System.out.println("버튼이벤트 발생!");
			}
			
		});//버튼에 이벤트를 등록!
		bt2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("mouseClicked");
			}
		});
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
		
		init();	//컴포넌트를 초기화 하는 메서드
		eventInit();	//이벤트를 등록하는 메서드
	}
	
	public static void main(String[] args) {
		MyFrame0x f = new MyFrame0x("제목", 400, 500);
		f.setVisible(true);
	}
}
