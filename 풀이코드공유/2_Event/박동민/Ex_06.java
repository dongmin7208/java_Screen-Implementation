package ex07;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
class Ex_06 extends Frame {
/* MenuBar객체를 만들고 그위에 메뉴를 만든다.
   Munu의 개념은 하위 메뉴를 가지고 있으면 무조건 메뉴라고 설정한다.
   MunuItem은 메뉴 밑에 있는 마지막 메뉴를 말한다.
   앞에 체크를 해주려고 한다면 CheckboxMenuItem 을 사용한다.
   	*/
	//메뉴판
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("FILE");
	private MenuItem fexit = new MenuItem("EXIT");
	private Menu help = new Menu("HELP");
	private MenuItem hver = new MenuItem("Ver...");
	//메뉴판
	//밑에 대화상대 창
	private BorderLayout b1 = new BorderLayout();
	private Panel p1 = new Panel();
	private Label title_lb = new Label("대화 상대 : ", Label.RIGHT);
	
	//내용 들어오는판
	private TextArea out = new TextArea();

	
	
	
	
	//내용 치는판
	private TextArea in = new TextArea(3,1);
	
	
	
	
	
	//보내기 버튼
	private Panel p2 = new Panel();//글등록부분
	private Button register_bt = new Button("보내기");
	private FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
	
	public Ex_06(String title) {
		super(title);
		
		this.init();
		this.eventInit();
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
		//메뉴판
		file.add(fexit);
		mb.add(file);
		help.add(hver);
		mb.add(help);
		this.setMenuBar(mb);
		p1.setLayout(b1);
		p1.add("West",title_lb);
		this.add("North",p1);
		
		this.add(out);
		out.setEditable(false);
		p2.setLayout(new BorderLayout());
		p2.add(register_bt,"East");
		p2.add(in);
		this.add("South",p2);
		

		
	}
	private void eventInit() {
		// 이벤트 등록
		register_bt.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			out.append("동민 : " + in.getText() + "\n");
			in.setText("");
			in.requestFocus();
			}
		});
	
		in.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode() == arg0.VK_ENTER) {
				out.append("나 : " + in.getText() + "\n");
				in.setText("");
				in.requestFocus();
			}
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
		Ex_06 f = new Ex_06("대화창");
		f.setVisible(true);
	}
	
}

