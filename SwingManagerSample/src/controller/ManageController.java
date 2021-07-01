package controller;

import model.Database;
import model.InfoDAO;
import model.InfoVO;

public class ManageController {
	private Database db = new Database();
	private InfoDAO dao = new InfoDAO();
	private static ManageController instance;
	private ManageController() {}
	
	public static ManageController getInstance() {
		if(instance == null) {
			synchronized(ManageController.class) {
				instance = new ManageController();
			}
		}
		return instance;
	}
	
	public Object requestProcess(String cmd, Object data) {
		InfoVO tmp = (InfoVO)data;
		Object ret = null;
		if(cmd.equals("insert")) {
			System.out.println("저장");
			ret = dao.insert(tmp);
		}else if(cmd.equals("update")) {
			System.out.println("수정");
			dao.update(tmp.getNo(), tmp);
		}else if(cmd.equals("delete")) {
			System.out.println("삭제");
			dao.delete(tmp.getNo());
		}else if(cmd.equals("list")) {
			System.out.println("전체목록");
			ret = dao.getListAll();
		}else if(cmd.equals("size")) {
			System.out.println("크기");
			ret = dao.getSize();
		}
		return ret;
	}
}
