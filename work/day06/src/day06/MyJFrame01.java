package day06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;


public class MyJFrame01 extends JFrame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//이 아래로 컴포넌트 객체 정의
	JPanel contentPane;
	private JButton jbt1 = new JButton("EMPTY");
	private JButton jbt2 = new JButton("LINE");
	private JButton jbt3 = new JButton("ETCHED");
	private JButton jbt4 = new JButton("BEVEL");
	private JButton jbt5 = new JButton("SOFTBEVEL");
	private JButton jbt6 = new JButton("MATTE");
	private JButton jbt7 = new JButton("TITLED");
	private JButton jbt8 = new JButton("COMPOUND");
	
	private GridLayout gl = new GridLayout(4, 2, 5, 5);
	
	private void init() {
		//contentPane을 이용하여 컴포넌트 등록
		contentPane.setLayout(gl);
		EmptyBorder b1 = new EmptyBorder(5, 3, 5, 3);//위와 좌측에서 어느정도 떨어져서 나타날지.
		jbt1.setBorder(b1);                          //다른 버튼과는 좀 틀리게 평면의 모양을 나타남.
		contentPane.add(jbt1);
		LineBorder b2 = new LineBorder(Color.RED, 3);//라인에 색을 3픽셀만큼
		jbt2.setBorder(b2);
		contentPane.add(jbt2);
		EtchedBorder b3 = new EtchedBorder();//라인에 홈이 파져있는 모양
		jbt3.setBorder(b3);
		contentPane.add(jbt3);	
		BevelBorder b4 = new BevelBorder(BevelBorder.RAISED);//위로 올라오고(LOWERED) 밑으로 내려가고
		jbt4.setBorder(b4);
		contentPane.add(jbt4);
		SoftBevelBorder b5 = new SoftBevelBorder(SoftBevelBorder.LOWERED);//모퉁이가 둥글게 나오게 하는거
		jbt5.setBorder(b5);
		contentPane.add(jbt5);
		MatteBorder b6 = new MatteBorder(5, 10, 15, 20, Color.BLUE); //두께를 마음대로 정하는 라인보더형태
		jbt6.setBorder(b6);
		contentPane.add(jbt6);
		TitledBorder b7 = new TitledBorder("제목");//타이틀을 달수 있게 해주는 보더, 위치지정도 할수있다.
		jbt7.setBorder(b7);
		contentPane.add(jbt7);		
		SoftBevelBorder b8 = new SoftBevelBorder(SoftBevelBorder.RAISED);
		TitledBorder b9 = new TitledBorder("제목임");
		CompoundBorder b10 = new CompoundBorder(b8, b9);//섞어서 쓰고 싶을때
		jbt8.setBorder(b10);
		contentPane.add(jbt8);
		
	}
	private void eventInit() {
	}
	
	public MyJFrame01(String t, int w, int h) {
		super(t);
		size.width = w;
		size.height = h;
		setSize(size);
		loc.x = (screenSize.width/2) - (getWidth()/2);
		loc.y = (screenSize.height/2) - (getHeight()/2);
		setLocation(loc);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();	//작업 패널
		this.setContentPane(contentPane); //프레임에 패널추가
		init();	//컴포넌트를 초기화 하는 메서드
		eventInit();	//이벤트를 등록하는 메서드
	}
	
	public static void main(String[] args) {
		MyJFrame01 f = new MyJFrame01("제목", 400, 500);
		f.setVisible(true);
	}
}
