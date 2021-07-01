package ex06.copy;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
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

//class MyActionListener implements ActionListener{
//	private Label lb = null;
//	
//	public MyActionListener(Label lb) {
//		this.lb = lb;
//	}
	
//		Button bt = (Button)arg0.getSource();
		//arg0.getSource() 이벤트가 발생된 컴포넌트 참조를 반환하는 메서드
		//다운캐스팅해서 해당 컴포넌트의 멤버를 활용할 수 있다.


//		System.out.println(bt.getLabel());
//		if(bt.getLabel().equals("사과")) {
//			lb.setText("사과");
//		}else if(bt.getLabel().equals("배")) {
//			lb.setText("배");
//		}else if(bt.getLabel().equals("바나나")) {
//			lb.setText("바나나");
//		}
//
//	}


	


public class MyFrame0x extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//이 아래로 컴포넌트 객체 정의
	private String text =" ";
	private Font font = new Font("굴림체", Font.ITALIC, 20);

	
	private Panel p = new Panel();
	private GridLayout gl3 = new GridLayout(1, 3);	
	private Checkbox a = new Checkbox("사과");//박스버튼 생성
	private Checkbox b = new Checkbox("배");
	private Checkbox c = new Checkbox("바나나");
	
	
	private GridLayout gl1 = new GridLayout(1,2); 
	private Panel pn1 = new Panel();
	private Button bt1 = new Button("선택완료");
	
	private GridLayout gl2 = new GridLayout(3,1); 
	private Label lb = new Label("선택 후 버튼 클릭." , Label.CENTER);
	private void init() {
		//컴포넌트 등록
//		lb.setFont(font);
		
//		p.setLayout(gl3);
		this.setLayout(gl2); //, BorderLayout.NORTH);
		p.add(a); p.add(b); p.add(c);
		this.add(p);
		this.add(bt1);
		this.add(lb);

//		this.add(bt1,BorderLayout.SOUTH); //선택후 버튼클릭
		
//		pn1.setLayout(gl1);//,BorderLayout.SOUTH);
//
//		pn1.add(bt1);//,BorderLayout.SOUTH);
//		this.add(pn1);
//		this.add(lb,BorderLayout.SOUTH);
//		this.add(bt2, BorderLayout.SOUTH);
				//, BorderLayout.SOUTH);
		
	}
	private void eventInit() {
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(a.getState())  text += a.getLabel()+" "; 
				if(b.getState())  text += b.getLabel()+" "; 
				if(c.getState())  text += c.getLabel();
				
				lb.setText(text);
				text = "";
				
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
//		System.out.println("bt1객체:" + bt1);
//		System.out.println("bt2객체:" + bt2);
//		bt1.addActionListener(new MyActionListener(lb));//버튼에 이벤트를 등록!
//		bt2.addActionListener(new MyActionListener(lb));

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
		MyFrame0x f = new MyFrame0x("Event Ex01", 300, 250);
		f.setVisible(true);
	}
}
