package svc.community;

import static db.JdbcUtil.close;

import java.sql.*;
import java.util.*;

import dao.*;
import db.*;
import vo.community.*;

public class QnaListService {

	//전체 게시물 개수 조회
	public int getListCount(String qna_tag) {
		System.out.println("QnaListService - getListCount");
		
		int itemlistCount = 0;

		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setConnection(con);
		
		itemlistCount = dao.selectListCount(qna_tag);
		
		close(con);
		
		return itemlistCount;
	}

	//전체 게시물 목록 조회
	public ArrayList<QnaDTO> getQnaList(int pageNum, int listLimit, String qna_tag) {
		
		ArrayList<QnaDTO> qnaList = null;
		
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setConnection(con);
		
		qnaList = dao.selectQnaList(pageNum, listLimit, qna_tag);
		
		return qnaList;
	}

}
