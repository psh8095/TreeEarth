package svc.community;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

import dao.*;
import db.*;
import vo.community.*;

public class QnaFaqListService {

	//전체 게시물 개수 조회
	public int getListCount() {
		System.out.println("QnaFaqListService - getListCount");
		
		int itemlistCount = 0;

		Connection con = JdbcUtil.getConnection();
		FaqDAO dao = FaqDAO.getInstance();
		dao.setConnection(con);
		
		itemlistCount = dao.selectListCount();
		
		close(con);
		
		return itemlistCount;
	}

	//전체 게시물 목록 조회
	public ArrayList<QnaFaqDTO> getFaqList(int pageNum, int listLimit) {
		
		ArrayList<QnaFaqDTO> qnaFaqList = null;
		
		Connection con = JdbcUtil.getConnection();
		FaqDAO dao = FaqDAO.getInstance();
		dao.setConnection(con);
		
		qnaFaqList = dao.selectFaqList(pageNum, listLimit);
		
		return qnaFaqList;
	}

}
