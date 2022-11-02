package com.napmkmk.mvcboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.napmkmk.mvcboard.command.BCommand;
import com.napmkmk.mvcboard.command.BContentViewCommand;
import com.napmkmk.mvcboard.command.BDeleteCommand;
import com.napmkmk.mvcboard.command.BListCommand;
import com.napmkmk.mvcboard.command.BModifyCommand;
import com.napmkmk.mvcboard.command.BReplyCommand;
import com.napmkmk.mvcboard.command.BWriteCommand;

@Controller
public class BoardController {

	BCommand command = null;
	
	@RequestMapping(value = "/")
	public String goList() {
		return "redirect:list";// 요청을 다시 넣기
	}

	@RequestMapping(value = "list")

	public String list(Model model) {

		command = new BListCommand();
		command.excute(model);

		return "list";
	}
	
	@RequestMapping(value = "write_form")
	public String write_form() {
		return "write_form";
		
	}
	@RequestMapping(value = "write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	@RequestMapping(value= "content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentViewCommand();
		command.excute(model);
		
		
		return "content_view";
		
	}
	
	@RequestMapping(value = "modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentViewCommand();
		command.excute(model);
		
		return "modify_view";
	}
	
	@RequestMapping(value = "modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BModifyCommand();
		command.excute(model);
		
		return "redirect:list";// 요청을 다시 넣기
	}
	
	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BDeleteCommand();
		command.excute(model);
		
		return "redirect:list";// 요청을 다시 넣기
	}
	@RequestMapping (value = "reply_write")
	public String reply_write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentViewCommand();// 원 글 내용 불러오기
		command.excute(model);
		
		
		return "reply_write";
		
	}
	
	@RequestMapping (value = "reply")
	public String reply(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BReplyCommand(); // 댓글 새로 쓰기 (DB 새글 삽입)
		command.excute(model);
		
		
		return "redirect:list";// 요청을 다시 넣기
		
	}
	
}