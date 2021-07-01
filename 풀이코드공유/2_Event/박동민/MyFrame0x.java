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
 * 리스너를 직접 구현하여 이벤트를 등록하는 방법
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
		System.out.println("이벤트가 발생된 객체:" + arg0.getSource());
		System.out.println("버튼이벤트 발생!");
		Button bt = (Button)arg0.getSource();
		//arg0.getSource() 이벤트가 발생된 컴포넌트 참조를 반환하는 메서드
		//다운캐스팅해서 해당 컴포넌트의 멤버를 활용할 수 있다.
		System.out.println(bt.getLabel());
		if(bt.getLabel().equals("Left")) {
			lb.setText("왼쪽 버튼을 눌렀습니다.");
		}else if(bt.getLabel().equals("Right")) {
			lb.setText("오른쪽 버튼을 눌렀습니다.");
		}

	}
	
}

public class MyFrame0x extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//이 아래로 컴포넌트 객체 정의
	private GridLayout gl2 = new GridLayout(2,0); 
	private Label lb = new Label("버튼을 눌러주세요." , Label.CENTER);
	private Font font = new Font("굴림체", Font.ITALIC, 20);
	
	private GridLayout gl1 = new GridLayout(1,1); 
	private Panel pn1 = new Panel();
	private Button bt1 = new Button("Left");
	private Button bt2 = new Button("Right");
	private void init() {
		//컴포넌트 등록
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
		System.out.println("bt1객체:" + bt1);
		System.out.println("bt2객체:" + bt2);
		bt1.addActionListener(new MyActionListener(lb));//버튼에 이벤트를 등록!
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
		
		init();	//컴포넌트를 초기화 하는 메서드
		eventInit();	//이벤트를 등록하는 메서드
	}
	
	public static void main(String[] args) {
		MyFrame0x f = new MyFrame0x("Event Ex01", 300, 150);
		f.setVisible(true);
	}
}
