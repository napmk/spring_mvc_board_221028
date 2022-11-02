package com.napmkmk.mvcboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.napmkmk.mvcboard.dao.BoardDao;
import com.napmkmk.mvcboard.dto.BoardDto;

public class BContentViewCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bid = request.getParameter("bid");
		
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.content_view(bid);
		
		model.addAttribute("content", dto);
	}

}
