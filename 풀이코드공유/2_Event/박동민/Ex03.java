package ex08;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Ex03 extends Frame{
	Dimension screenSize =
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	Toolkit tk = Toolkit.getDefaultToolkit();
	Image img1 = tk.getImage("fastrcp.gif"); //돌리는거
	Image img2 = tk.getImage("c.jpg");//가위
	Image img3 = tk.getImage("p.jpg");//보
	Image img4 = tk.getImage("r.jpg");//바위
	Image img5 = tk.getImage("fastrcp.gif");// 전적
	
	//이 아래로 컴포넌트 객체 정의
	private Label info = new Label("메세지:주먹,가위,보자기 키를 누르세요",Label.CENTER);
	
	
	Random ran = new Random();
	
	private GridLayout b1 = new GridLayout(6,1,20,20);
	private Panel p1 = new Panel();
	private Button bt1 = new Button("주먹");
	 
	
	private Button bt2 = new Button("가위");
	private Button bt3 = new Button("보자기");
	private Button bt4 = new Button("전적");
	private Button bt5 = new Button("다시");
	private Button bt6 = new Button("종료");
	
	int cntw,cntl,cntd;
	
	
	
	
	
	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		 arg0.drawImage(img1,150,100,500,300,this);
	}
	private void init() {
		//컴포넌트 등록
		p1.setLayout(b1);
		p1.add(bt1); p1.add(bt2); p1.add(bt3); p1.add(bt4); p1.add(bt5);p1.add(bt6);
		this.add("North",info);
		this.add("East",p1);

		
	} //img1(랜덤),img2(가위),img3(보),img4(바위)
	private void eventInit() {
		//이벤트 등록
		bt1.addMouseListener(new MouseAdapter() { //바위
			@Override
			public void mouseClicked(MouseEvent e) {
				int Random = ran.nextInt(3);
				if(Random == 0) {img1=img4; cntd++; info.setText("비겼습니다");}
				else if(Random == 1) {img1=img2; cntw++; info.setText("이겼습니당");}
				else {img1=img3; cntl++; info.setText("졌습니다");}
			}
		});
		bt2.addMouseListener(new MouseAdapter() { //가위
		
			@Override
			public void mouseClicked(MouseEvent e) {
				int Random = ran.nextInt(3);
				if(Random == 0) {img1=img2; cntd++; info.setText("비겼습니다");}
				else if(Random == 1) {img1=img3; cntw++; info.setText("이겼습니당");}
				else {img1=img4; cntl++; info.setText("졌습니다");}
			}
		});
		bt3.addMouseListener(new MouseAdapter() {  //보
		
			@Override
			public void mouseClicked(MouseEvent e) {
				int Random = ran.nextInt(3);
				if(Random == 0) {img1=img3; cntd++; info.setText("비겼습니다");}
				else if(Random == 1) {img1=img4; cntw++; info.setText("이겼습니당");}
				else {img1=img2; cntl++; info.setText("졌습니다");}
			}
		});
		bt4.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				info.setText(String.format("승리:%d,패배:%d,무승부:%d",cntw,cntl,cntd));
			}
		});
		
		bt5.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				cntw=0; cntl=0;cntd = 0;
				img1=img5;
				info.setText("메세지:주먹,가위,보자기 키를 누르세요");
				
			}
			
			
			
		});

		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public Ex03(String t, int w, int h) {
		super(t);
		size.width = w;
		size.height = h;
		setSize(size);
		loc.x = screenSize.width/2 - getWidth()/2;
		loc.y = screenSize.height/2 - getHeight()/2;

		setLocation(loc);
		setResizable(false);
		
		init(); //컴포넌트를 초기화 하는 메서드
		eventInit(); //이벤트를 등록하는 메서드
		
	}
	
	public static void main(String[] args) {
		Ex03 f = new Ex03("가위 바위 보 게임", 800, 500);
		f.setVisible(true);
	}
}
