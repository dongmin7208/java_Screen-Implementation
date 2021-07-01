package model;

import java.util.HashMap;
/*
 * 데이터베이스 역할의 클래스
 * 실제 데이터베이스 대신 테스트 용으로 사용
 */
public class Database {
	public static HashMap<Integer, InfoVO> infoDB = new HashMap<Integer, InfoVO>();
	static {
		//샘플 데이터
		InfoVO[] is = new InfoVO[] {
			new InfoVO(InfoSequence.nextVal(), "홍길동", 54),
			new InfoVO(InfoSequence.nextVal(), "이순신", 23),
			new InfoVO(InfoSequence.nextVal(), "김지영", 13),
			new InfoVO(InfoSequence.nextVal(), "한혜진", 53),
			new InfoVO(InfoSequence.nextVal(), "이시언", 33),
			new InfoVO(InfoSequence.nextVal(), "박지성", 24),
			new InfoVO(InfoSequence.nextVal(), "김연아", 65),
			new InfoVO(InfoSequence.nextVal(), "원빈", 33),
			new InfoVO(InfoSequence.nextVal(), "정우성", 17),
			new InfoVO(InfoSequence.nextVal(), "김태희", 28),
			new InfoVO(InfoSequence.nextVal(), "김남길", 37),
			new InfoVO(InfoSequence.nextVal(), "김신영", 35),
			new InfoVO(InfoSequence.nextVal(), "홍진영", 17),
			new InfoVO(InfoSequence.nextVal(), "조용필", 35),
			new InfoVO(InfoSequence.nextVal(), "김수미", 66),
			new InfoVO(InfoSequence.nextVal(), "박나래", 39),
			new InfoVO(InfoSequence.nextVal(), "최수종", 42),
			new InfoVO(InfoSequence.nextVal(), "이나영", 41),
			new InfoVO(InfoSequence.nextVal(), "이성경", 66),
			new InfoVO(InfoSequence.nextVal(), "타노스", 100),
		};
		
		for(int i = 0; i < is.length; i++) {
			infoDB.put(is[i].getNo(), is[i]);
		}
	}
}
