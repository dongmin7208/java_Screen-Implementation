import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
class Exec_055_Sub extends Frame {
	//패널안에 패널을 넣는다고 한다면 아래와 같이 표현하면 되겠다.
	private Font font = new Font("", Font.BOLD, 30);
	
	private Color cc1 = new Color(255,0,0);
	private Color cc2 = new Color(0,255,0);
	private Color cc3 = new Color(0,0,255);
	private Color cc4 = new Color(238,40,208);
	
	
	private Button btn_1 = new Button("btn1");
	private Button btn_2 = new Button("btn2");
	
	private Button btw_1 = new Button("btw1");
	private Button btw_2 = new Button("btw2");
	
	private Button bte_1 = new Button("bte1");
	private Button bte_2 = new Button("bte2");
	
	private Button bts_1 = new Button("bts1");
	private Button bts_2 = new Button("bts2");
	
	
	private Button btcw_4 = new Button("btc4");
	private Button btce_3 = new Button("btc3");
	private Button btcs_2 = new Button("btc2");
	private Button btcn_1 = new Button("btc1");
	private Button btcc_5 = new Button("btc5");
	
	private Button btcn_5 = new Button("Quiz!!!");
	
	
	private Panel p1n = new Panel();
	private Panel p2w = new Panel();
	private Panel p3e = new Panel();
	private Panel p4s = new Panel();
	
	private Panel p1c = new Panel();
	private Panel p2c = new Panel();
//	private Panel p3c = new Panel();
//	private Panel p4c = new Panel();
//	private Panel p5c = new Panel();
	
	private BorderLayout bl = new BorderLayout();
	private BorderLayout b2 = new BorderLayout(50,50);
	private GridLayout gln = new GridLayout(1, 2);
	private GridLayout g1s = new GridLayout(1, 2);
	private GridLayout g1e = new GridLayout(2, 1);
	private GridLayout g1w = new GridLayout(2, 1);
	
	private GridLayout g1cn = new GridLayout(1, 1);
//	private GridLayout g1cs = new GridLayout(1, 1);
//	private GridLayout g1ce = new GridLayout(1, 1);
//	private GridLayout g1cw = new GridLayout(1, 1);
//	private GridLayout g1cc = new GridLayout(1, 1);
	

	
	public Exec_055_Sub(String title) {
		super(title);
		
		this.init();
		
		super.setSize(500, 300);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = super.getSize();
		int xpos = (int)(screen.getWidth() / 2 - frm.getWidth() / 2);
		int ypos = (int)(screen.getHeight() / 2 - frm.getHeight() / 2);
		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
	}
	
	public void init() {
		//컴포넌트 등록
		p1c.setLayout(bl);
//		p2c.setLayout(btcn_5);
//		p2c.setLayout(g1cn);
		btcn_5.setBounds(180, 50, 150, 50);
		
		btcn_5.setFont(font);
//		p2c.add(btcn_5); //Quiz!!!
		
			
		p1c.setLayout(bl);
		p1c.add("South",btcs_2);
		p1c.add("North",btcn_1);
		p1c.add("West",btcw_4);
		p1c.add("East",btce_3);		
//		p1c.add("Center", btc_5);
		
		p4s.setLayout(g1s);
		p4s.add(bts_1);
		p4s.add(bts_2);

		p1n.setLayout(gln);
		p1n.add(btn_1);
		p1n.add(btn_2);

		p2w.setLayout(g1w);
		p2w.add(btw_1);
		p2w.add(btw_2);

		p3e.setLayout(g1e);
		p3e.add(bte_1);
		p3e.add(bte_2);
		
		btcs_2.setBackground(cc1);
		btcn_1.setBackground(cc2);
		btcw_4.setBackground(cc3);
		btce_3.setBackground(cc4);
		bts_1.setBackground(cc1);
		bts_2.setBackground(cc2);
		btn_1.setBackground(cc3);
		btn_2.setBackground(cc4);
		btw_1.setBackground(cc1);
		btw_2.setBackground(cc2);
		bte_1.setBackground(cc3);
		bte_2.setBackground(cc4);
		btcc_5.setBackground(cc4);

		this.add(btcn_5);   //Quiz 순서 !!! 먼저!
		
		this.add("South", p4s);
		this.add("North", p1n);
		this.add("Center", p1c);

		this.add("West", p2w);
		this.add("East", p3e);
		

		this.add(p4s,"South");
		this.add(p1n,"North");

		this.add(p2w,"West");
		this.add(p3e,"East");

		this.add(p1c,"Center");
//		p1c.add(btcn_5);
//		p2c.add(btcn_5);

	}
}

public class Exec_6 {
	public static void main(String[] ar) {
		Exec_055_Sub ex = new Exec_055_Sub("제목");
	}
}