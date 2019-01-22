package kr.green.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.vo.BoardVo;

@Controller
@RequestMapping(value="/bbs")
public class BoardController{
	@RequestMapping(value="/list")
	public String list() {
		return "bbs/list";
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(BoardVo board) {
		System.out.println(board);
		return "bbs/register";
	}
}
