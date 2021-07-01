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
 * 리스너를 직접 구현하여 이벤트를 등록하는 방법
 */

class MyActionListener implements ActionListener{
	private Label lb = null;
	
	public MyActionListener(Label lb) {
		this.lb = lb;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("이벤트가 발생된 객체:" + arg0.getSource());
		System.out.println("버튼이벤트 발생!");
		Button bt = (Button)arg0.getSource();
		//arg0.getSource() 이벤트가 발생된 컴포넌트 참조를 반환하는 메서드
		//다운캐스팅해서 해당 컴포넌트의 멤버를 활용할 수 있다.
		System.out.println(bt.getLabel());
		if(bt.getLabel().equals("bt1")) {
			lb.setText("bt1눌림");
		}else if(bt.getLabel().equals("bt2")) {
			lb.setText("bt2눌림");
		}

	}
	
}

public class MyFrame0x extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//이 아래로 컴포넌트 객체 정의
	private Label lb = new Label("버튼을 눌러주세요." , Label.CENTER);
	private Button bt1 = new Button("bt1");
	private Button bt2 = new Button("bt2");
	
	private void init() {
		//컴포넌트 등록
		this.add(lb, BorderLayout.SOUTH);
		this.add(bt1);
		this.add(bt2, BorderLayout.NORTH);
		
	}
	private void eventInit() {
		System.out.println("bt1객체:" + bt1);
		System.out.println("bt2객체:" + bt2);
		bt1.addActionListener(new MyActionListener(lb));//버튼에 이벤트를 등록!
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
		
		init();	//컴포넌트를 초기화 하는 메서드
		eventInit();	//이벤트를 등록하는 메서드
	}
	
	public static void main(String[] args) {
		MyFrame0x f = new MyFrame0x("제목", 400, 500);
		f.setVisible(true);
	}
}
