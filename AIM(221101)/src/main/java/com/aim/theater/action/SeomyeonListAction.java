package com.aim.theater.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aim.theater.db.SceduleDAO;

public class SeomyeonListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : SeomyeonListAction_execute()");
		
		//DB에 저장된 정보를 가져오기
		SceduleDAO dao = new SceduleDAO();
		
		List scheduleList = dao.getScheList();
		
		//연결된 view 페이지로 정보 전달
		request.setAttribute("scheduleList", scheduleList);
		
		//페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./theater/selectedTheater.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
