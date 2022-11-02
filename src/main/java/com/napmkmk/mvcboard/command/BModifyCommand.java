package com.napmkmk.mvcboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.napmkmk.mvcboard.dao.BoardDao;

public class BModifyCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		//원래 리퀘스느 객체인데 모델안의 리퀘스트 객체 찾아야함
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		//model 객체를 request객체로 매핑
				
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bid = request.getParameter("bid");
				
		BoardDao dao =  new BoardDao();
		dao.modify(bname, btitle, bcontent, bid); //차례대로 하는게 좋음

	}

}
