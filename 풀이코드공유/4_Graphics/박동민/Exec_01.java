package day32;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
class Exec_01_Sub extends Frame  {
	public Exec_01_Sub(String title) {
		super(title);
		
		this.init();

		this.eventInit();
		super.setSize(500, 350);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = super.getSize();
		int xpos = (int)(screen.getWidth() / 2 - frm.getWidth() / 2);
		int ypos = (int)(screen.getHeight() / 2 - frm.getHeight() / 2);
		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
		
	}

	private Image img = Toolkit.getDefaultToolkit().getImage("Ã¶±¸.jpeg");
	private int x = 100, y = 149;
	
//	private int liney =y*2/3;
	
//	private int sizex = 100, sizey = liney-50;

	
	public void paint(Graphics g) {
		g.drawLine(0, 250, 500,250);
		g.drawImage(img, x, y, 100, 100, this);
	}
	
	public void init() {
	}

	
	public void eventInit() {	
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_UP) {
					x+=10; y-=50;
					repaint();

				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==e.VK_UP) {
					x-=10; y+=50;
					repaint();
				}
			}
		});
		

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_RIGHT) {
					x+=20; 
					repaint();

				}
			}
		});
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_LEFT) {
					x-=20; 
					repaint();

				}
			}
		});

}
}

	


	
	 

	
	

public class Exec_01 {
	public static void main(String[] ar) {
		Exec_01_Sub ex = new Exec_01_Sub("Á¦¸ñ");
	}
}