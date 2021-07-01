package model;

public class InfoSequence {
	private static int no = 1;
	
	public static int nextVal() {
		int cur = no;
		no++;
		return cur;
	}
	public static int currentVal() {
		return no;
	}
}
