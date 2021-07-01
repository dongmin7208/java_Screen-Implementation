package ex06.copy;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Dialog;
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
	
	
	private BorderLayout bl = new BorderLayout();
	private Dialog dlg = new Dialog(this,"���ð��",true);
	
	private Label msg_lb = new Label(text,Label.CENTER);
	
	private void init() {
		
		
		//������Ʈ ���

		this.setLayout(gl2); 
		p.add(a); p.add(b); p.add(c);
		this.add(p);
		this.add(bt1);
		this.add(lb);
		
		dlg.add(msg_lb);





	}
	private void eventInit() {
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(a.getState())  text += a.getLabel()+" "; 
				if(b.getState())  text += b.getLabel()+" "; 
				if(c.getState())  text += c.getLabel();
				msg_lb.setText(text);
//				lb.setText(text);
				text = "";
				dlg.setLocation(300, 300);
				dlg.setSize(200,100);
				dlg.setVisible(true);
				dlg.setResizable(false);
				dlg.setLayout(bl);
				dlg.add("Center",msg_lb);
				dlg.setLocation(loc);
				
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
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
		
		init();	//������Ʈ�� �ʱ�ȭ �ϴ� �޼���
		eventInit();	//�̺�Ʈ�� ����ϴ� �޼���
	}
	
	public static void main(String[] args) {
		MyFrame0x f = new MyFrame0x("Event Ex01", 300, 250);
		f.setVisible(true);
	}
}
