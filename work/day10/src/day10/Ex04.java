package day10;

public class Ex04 {
	public static void main(String[] args) {
		int time = 10;
		while(true) {
			System.out.println(time + "초");
			try {
				Thread.sleep(1000);
				time--;
			}catch(InterruptedException e) {
				
			}
			if(time == 0) {
				break;
			}
		}
		System.out.println("게임종료");
	}
}
