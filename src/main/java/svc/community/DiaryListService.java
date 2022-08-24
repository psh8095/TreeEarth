package svc.community;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dao.*;
import db.*;
import vo.community.*;

public class DiaryListService {


	public int getDiaryListCount() {

		int listCount = 0;
		
		//싱글톤 디자인 패턴으로 생성된 DiaryDAO 인스턴스 활용
		Connection con = getConnection();
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.setConnection(con);
		
		//전체 게시물 목록 조회
		listCount = dao.selectListCount();
//		System.out.println("listCount : " + listCount);
		
		close(con);
		
		return listCount;
	}

	public static ArrayList<DiaryDTO> getDiaryList(int pageNum, int listLimit) {
		System.out.println("4.getDiaryList");
		
		ArrayList<DiaryDTO> diaryList = null;
		
		//싱글톤 디자인 패턴으로 생성된 DiaryDAO 인스턴스 활용
		Connection con = getConnection();
		DiaryDAO dao = DiaryDAO.getInstance();
		dao.setConnection(con);
		
		diaryList = dao.selectDiaryList(pageNum, listLimit);
//		System.out.println(campaignReviewList);
		
		close(con);

		return diaryList;
	}
	

}
