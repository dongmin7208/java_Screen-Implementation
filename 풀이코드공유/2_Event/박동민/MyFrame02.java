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
 * �����ʸ� ���� �����Ͽ� �̺�Ʈ�� ����ϴ� ���
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
		//arg0.getSource() �̺�Ʈ�� �߻��� ������Ʈ ������ ��ȯ�ϴ� �޼���
		//�ٿ�ĳ�����ؼ� �ش� ������Ʈ�� ����� Ȱ���� �� �ִ�.


//		System.out.println(bt.getLabel());
//		if(bt.getLabel().equals("���")) {
//			lb.setText("���");
//		}else if(bt.getLabel().equals("��")) {
//			lb.setText("��");
//		}else if(bt.getLabel().equals("�ٳ���")) {
//			lb.setText("�ٳ���");
//		}
//
//	}


	


public class MyFrame0x extends Frame{
	Dimension screenSize = 
			Toolkit.getDefaultToolkit().getScreenSize();
	Dimension size = new Dimension();
	Point loc = new Point();
	
	//�� �Ʒ��� ������Ʈ ��ü ����
	private String text =" ";
	private Font font = new Font("����ü", Font.ITALIC, 20);

	
	private Panel p = new Panel();
	private GridLayout gl3 = new GridLayout(1, 3);	
	private Checkbox a = new Checkbox("���");//�ڽ���ư ����
	private Checkbox b = new Checkbox("��");
	private Checkbox c = new Checkbox("�ٳ���");
	
	
	private GridLayout gl1 = new GridLayout(1,2); 
	private Panel pn1 = new Panel();
	private Button bt1 = new Button("���ÿϷ�");
	
	private GridLayout gl2 = new GridLayout(3,1); 
	private Label lb = new Label("���� �� ��ư Ŭ��." , Label.CENTER);
	private void init() {
		//������Ʈ ���
//		lb.setFont(font);
		
//		p.setLayout(gl3);
		this.setLayout(gl2); //, BorderLayout.NORTH);
		p.add(a); p.add(b); p.add(c);
		this.add(p);
		this.add(bt1);
		this.add(lb);

//		this.add(bt1,BorderLayout.SOUTH); //������ ��ưŬ��
		
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
//		System.out.println("bt1��ü:" + bt1);
//		System.out.println("bt2��ü:" + bt2);
//		bt1.addActionListener(new MyActionListener(lb));//��ư�� �̺�Ʈ�� ���!
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
		
		init();	//������Ʈ�� �ʱ�ȭ �ϴ� �޼���
		eventInit();	//�̺�Ʈ�� ����ϴ� �޼���
	}
	
	public static void main(String[] args) {
		MyFrame0x f = new MyFrame0x("Event Ex01", 300, 250);
		f.setVisible(true);
	}
}
