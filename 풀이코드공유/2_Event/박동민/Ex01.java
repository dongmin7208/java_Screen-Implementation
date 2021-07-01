package ex08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex01 extends Frame{
	
	public Ex01(String title) {
		super(title);
		
		this.init();
		this.eventInit();
		super.setSize(300, 150);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = super.getSize();
		int xpos = (int)(screen.getWidth() / 2 - frm.getWidth() / 2);
		int ypos = (int)(screen.getHeight() / 2 - frm.getHeight() / 2);
		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
		
		
		
	}

	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("FILE");
	private MenuItem reset = new MenuItem("다시 계산");
	private Menu help = new Menu("HELP");
	private MenuItem About = new MenuItem("About");
	
	private Panel p3 = new Panel();
	private Label info = new Label("버전:1.1",Label.CENTER);
	private Dialog dlg = new Dialog(this,"Info",true);
	private Button bt2 = new Button("닫기");
	
	
	private GridLayout b1 = new GridLayout(3,4); 
	
	private Panel p1 = new Panel();
	
	private Label kor = new Label("국  어", Label.CENTER);
	private TextField kor1 = new TextField("점수 입력...");
	
	private Label eng = new Label("영 어", Label.CENTER);
	private TextField eng1 = new TextField("점수 입력...");
	
	private Label math = new Label("수  학", Label.CENTER);
	private TextField math1 = new TextField("점수 입력...");
	
	private Label sum = new Label("총 점",Label.CENTER);
	private Label sum1 = new Label("0",Label.CENTER);
	private Label avg = new Label("평  균",Label.CENTER);
	private Label avg1 = new Label("0.00",Label.CENTER);
	private Label gread = new Label("학  점",Label.CENTER);
	private Label gread1 = new Label(" ",Label.CENTER);
	
	private Panel p2 = new Panel();
	private BorderLayout b2 = new BorderLayout();
	private Button bt1 = new Button("결과확인");
	
	
	
	
	public void init() {
		
		file.add(reset);
		mb.add(file);
		help.add(About);
		mb.add(help);
		this.setMenuBar(mb);
		
		p1.setLayout(b1);
		p1.add(kor);
		p1.add(kor1);
		p1.add(sum);
		p1.add(sum1);
		p1.add(eng);
		p1.add(eng1);
		p1.add(avg);
		p1.add(avg1);
		p1.add(math);
		p1.add(math1);
		p1.add(gread);
		p1.add(gread1);
		this.add(p1);
		
		p2.setLayout(b2);
		p2.add(bt1);
		this.add("South",p2);
		
		dlg.add(info);
		dlg.add("South",bt2);
		
		
		
	}
	
	public void eventInit() {
		
		//결과확인 누르면 TextField 로 들어가는것
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int total =0;
				total += Integer.parseInt(kor1.getText())+ Integer.parseInt(eng1.getText()) + Integer.parseInt(math1.getText());
				double avg = (total/3.0); 
				sum1.setText(String.valueOf(total));
				avg1.setText(String.format("%.2f", avg));
				if(avg >=90) gread1.setText("A");
				else if(avg >=80) gread1.setText("B");
				else if(avg >=70) gread1.setText("C");
				else if(avg >=60) gread1.setText("D");
				else gread1.setText("F");
			}
		});
				
		kor1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				kor1.setText(null);
				
			}
			
		});
		eng1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				eng1.setText(null);
				
			}
			
		});
		math1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				math1.setText(null);
				
			}
			
		});
		bt2.addMouseListener(new MouseAdapter () {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dlg.setVisible(false);
			}
		});
		
		
		
		About.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlg.setSize(100,120);
				dlg.setLocation(100,100);
				dlg.setVisible(true);
				
			}
			
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}




	
	public static void main(String[] args) {
		Ex01 f = new Ex01("성적 계산기");
		f.setVisible(true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
