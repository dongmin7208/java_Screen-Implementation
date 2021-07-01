package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class InfoDAO {
	
	public InfoVO insert(InfoVO vo) {
		vo.setNo(InfoSequence.nextVal());
		Database.infoDB.put(vo.getNo(), vo);
		//print();
		return vo;
	}
	
	public void update(Integer no, InfoVO vo) {
		Database.infoDB.put(no, vo);
		//print();
	}
	
	public void delete(Integer no) {
		Database.infoDB.remove(no);
		//print();
	}
	
	public InfoVO last() {
		return Database.infoDB.get(InfoSequence.currentVal());
	}
	
	//결과 출력용 테스트 메서드
	private void print() {
		Set<Integer> keys = Database.infoDB.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()) {
			int key = it.next();
			System.out.println(key + ":" + Database.infoDB.get(key));
		}

	}
	
	public ArrayList<Integer> getNumberAll(){
		return new ArrayList<Integer>(Database.infoDB.keySet());
	}
	
	public ArrayList<InfoVO> getListAll(){
		ArrayList<InfoVO> list = new ArrayList<InfoVO>();
		Set<Integer> keys = Database.infoDB.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()) {
			list.add(Database.infoDB.get(it.next()));
		}
		return list;
	}
	
	public Integer getSize() {
		return Database.infoDB.size();
	}
}
