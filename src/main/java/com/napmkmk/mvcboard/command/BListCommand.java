package com.napmkmk.mvcboard.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.napmkmk.mvcboard.dao.BoardDao;
import com.napmkmk.mvcboard.dto.BoardDto;

public class BListCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub


		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> dtos = dao.list();
		//DB에서 가져온 글 목록을 모두가지고 있는 ArrayList 자료구조의 dtos를 저장
		int count = dao.board_count(); //모든 게시글의 수를 반환
		model.addAttribute("boardCount", count);
		model.addAttribute("list", dtos);//글 목록 ArrayList를 모델객체안에 저장
	}

}