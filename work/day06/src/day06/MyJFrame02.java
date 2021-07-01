package day06;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;


public class MyJFrame02 extends JFrame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//이 아래로 컴포넌트 객체 정의
	JPanel contentPane;	
	private ImageIcon ii1 = new ImageIcon("a.gif");//버튼에 이미지를 넣어서 사용할수 있다.
	private ImageIcon ii2 = new ImageIcon("b.gif");
	private ImageIcon ii3 = new ImageIcon("c.gif");
	private ImageIcon ii4 = new ImageIcon("d.gif");
	private JToggleButton jtb1 = new JToggleButton(ii1);
	private JToggleButton jtb2 = new JToggleButton("2");
	private JToggleButton jtb3 = new JToggleButton("3", ii3);//이미지와 글자를 같이 넣을수 있다.
	private JToggleButton jtb4 = new JToggleButton("4", ii4);
	
	private ButtonGroup bg = new ButtonGroup();//위의 버튼이 하나씩만 사용되도록 그룹으로 묶는다.
	
	private GridLayout gl = new GridLayout(1, 4, 5, 5);
	
	private void init() {
		//contentPane을 이용하여 컴포넌트 등록
		contentPane.setLayout(gl);
		//jtb1.setEnabled(false);
		jtb1.setToolTipText("1번 버튼입니다.");
		bg.add(jtb1); contentPane.add(jtb1);
		
		jtb2.setToolTipText("2번 버튼입니다.");
		bg.add(jtb2); contentPane.add(jtb2);

		jtb3.setSelectedIcon(ii2);//선택을 했을때 이미지가 바뀐다.
		bg.add(jtb3); contentPane.add(jtb3);

		jtb4.setHorizontalTextPosition(SwingConstants.CENTER);//위치값을 지정해주는 SwingConstants인터페이스
								//좌우
		jtb4.setVerticalTextPosition(SwingConstants.BOTTOM);//위아래
		jtb4.setRolloverIcon(ii2);//버튼위에 올라가면 이미지를 바꾸어 주겠다.
		bg.add(jtb4); contentPane.add(jtb4);
		
		jtb1.setMnemonic('1');//단축버튼을 만들어 준다
		jtb2.setMnemonic('2');
		jtb3.setMnemonic('3');
		jtb4.setMnemonic('4');
	}
	private void eventInit() {
	}
	
	public MyJFrame02(String t, int w, int h) {
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
		MyJFrame02 f = new MyJFrame02("제목", 400, 500);
		f.setVisible(true);
	}
}
