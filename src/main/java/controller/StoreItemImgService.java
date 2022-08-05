package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StoreDAO;
import db.JdbcUtil;
import vo.StoreDTO;

public class StoreItemImgService {

	public ArrayList<StoreDTO> getItemImg() {
		System.out.println("StoreItemImgService");
		
		ArrayList<StoreDTO> itemimg = null;
		
		Connection con = JdbcUtil.getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		itemimg = dao.StoreItemImg();
		
		return itemimg;
	}
	
}
