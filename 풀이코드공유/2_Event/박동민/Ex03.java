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
	Image img1 = tk.getImage("fastrcp.gif"); //�����°�
	Image img2 = tk.getImage("c.jpg");//����
	Image img3 = tk.getImage("p.jpg");//��
	Image img4 = tk.getImage("r.jpg");//����
	Image img5 = tk.getImage("fastrcp.gif");// ����
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	private Label info = new Label("�޼���:�ָ�,����,���ڱ� Ű�� ��������",Label.CENTER);
	
	
	Random ran = new Random();
	
	private GridLayout b1 = new GridLayout(6,1,20,20);
	private Panel p1 = new Panel();
	private Button bt1 = new Button("�ָ�");
	 
	
	private Button bt2 = new Button("����");
	private Button bt3 = new Button("���ڱ�");
	private Button bt4 = new Button("����");
	private Button bt5 = new Button("�ٽ�");
	private Button bt6 = new Button("����");
	
	int cntw,cntl,cntd;
	
	
	
	
	
	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		 arg0.drawImage(img1,150,100,500,300,this);
	}
	private void init() {
		//������Ʈ ���
		p1.setLayout(b1);
		p1.add(bt1); p1.add(bt2); p1.add(bt3); p1.add(bt4); p1.add(bt5);p1.add(bt6);
		this.add("North",info);
		this.add("East",p1);

		
	} //img1(����),img2(����),img3(��),img4(����)
	private void eventInit() {
		//�̺�Ʈ ���
		bt1.addMouseListener(new MouseAdapter() { //����
			@Override
			public void mouseClicked(MouseEvent e) {
				int Random = ran.nextInt(3);
				if(Random == 0) {img1=img4; cntd++; info.setText("�����ϴ�");}
				else if(Random == 1) {img1=img2; cntw++; info.setText("�̰���ϴ�");}
				else {img1=img3; cntl++; info.setText("�����ϴ�");}
			}
		});
		bt2.addMouseListener(new MouseAdapter() { //����
		
			@Override
			public void mouseClicked(MouseEvent e) {
				int Random = ran.nextInt(3);
				if(Random == 0) {img1=img2; cntd++; info.setText("�����ϴ�");}
				else if(Random == 1) {img1=img3; cntw++; info.setText("�̰���ϴ�");}
				else {img1=img4; cntl++; info.setText("�����ϴ�");}
			}
		});
		bt3.addMouseListener(new MouseAdapter() {  //��
		
			@Override
			public void mouseClicked(MouseEvent e) {
				int Random = ran.nextInt(3);
				if(Random == 0) {img1=img3; cntd++; info.setText("�����ϴ�");}
				else if(Random == 1) {img1=img4; cntw++; info.setText("�̰���ϴ�");}
				else {img1=img2; cntl++; info.setText("�����ϴ�");}
			}
		});
		bt4.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				info.setText(String.format("�¸�:%d,�й�:%d,���º�:%d",cntw,cntl,cntd));
			}
		});
		
		bt5.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				cntw=0; cntl=0;cntd = 0;
				img1=img5;
				info.setText("�޼���:�ָ�,����,���ڱ� Ű�� ��������");
				
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
		
		init(); //������Ʈ�� �ʱ�ȭ �ϴ� �޼���
		eventInit(); //�̺�Ʈ�� ����ϴ� �޼���
		
	}
	
	public static void main(String[] args) {
		Ex03 f = new Ex03("���� ���� �� ����", 800, 500);
		f.setVisible(true);
	}
}
