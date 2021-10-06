package com.bitacademy.myportal.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.repository.BoardVo;
import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardServiceImpl;

	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<BoardVo> list= boardServiceImpl.getList();
		model.addAttribute("list",list);
		return "board/list";
	}

	//	게시물 작성 폼
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(HttpSession session) {
		//	로그인 사용자 확인
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if (authUser == null) {
			System.err.println("로그인 사용자가 아님!");
			return "redirect:/";
		}

		return "board/write";
	}

	//	게시물 작성
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo, 
						HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/";
		}
		//	작성자 정보 추가
		boardVo.setUserNo(authUser.getNo());
		//	삽입
		boardServiceImpl.write(boardVo);

		return "redirect:/board/list";
	}
	// 게시물 삭제
	@RequestMapping(value="/delete/{no}")
	public String delete(@PathVariable Long no) {
		
		boolean deleteSuccess = boardServiceImpl.delete(no);
		if(deleteSuccess) {
			return "redirect:/board";
		}
		return "redirect:/";
	}
	//게시물 수정
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVo vo) {
		boolean updateSuccess = boardServiceImpl.update(vo);
		if(updateSuccess) {
			return "redirect:/board/" + vo.getNo();
		}
		return "redirect:/board";
		
	}
	
	//게시물 수정
	@RequestMapping(value="/update/{boardIndex}",method=RequestMethod.GET)
	public String updateForm(@PathVariable Long boardIndex, Model model) {
		
		model.addAttribute("boardNo", boardIndex);
		
		
		return "/board/modify";
	}
	
	
	@RequestMapping("/{boardIndex}")
	public String view(@PathVariable Long boardIndex, Model model) {
		
		BoardVo content = boardServiceImpl.getContent(boardIndex);
		model.addAttribute("content", content);
		
		return "/board/view";
	}
    
}
