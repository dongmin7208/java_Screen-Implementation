package day10;

class MyThread05 extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("�١١١١١١١١١١�");
		}
	}
}
class MyThread06 implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("�ڡڡڡڡڡڡڡڡڡڡڡ�");
		}
	}
}

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("main����");
		MyThread05 th1 = 
				new MyThread05();
		MyThread06 th2 = new MyThread06();
		Thread th = new Thread(th2);
		//th1.setDaemon(true);
		//th.setDaemon(true);
		th1.start();//���ο� ������� run()����
		th.start();
		
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%2d ", i);
			if(i%10 == 0) {
				System.out.println();
			}
		}
		System.out.println("main��");

	}
}
