package com.example.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Service.BoardService;
import com.example.test.vo.BoardVO;
import com.example.test.vo.ParamVO;

import lombok.Setter;

@RestController
public class BoardController {
	
	@Setter(onMethod_= @Autowired)
	private BoardService boardservice;
	
	
	@GetMapping("/list") //get에 url에있는 파라미터로 가져와 req에 저장
	public List<BoardVO> BoardList(HttpServletRequest req,BoardVO bvo) {
		ParamVO pvo = new ParamVO();
		//json으로 받아온 값을 pvo 에 있는 값에 설정
		pvo.setParam(req.getParameter("param"));
		pvo.setType(req.getParameter("type"));
		//값 확인을 위한 출력문
		System.out.println(pvo);
		//받아온 값으로 boardList 실행
		List<BoardVO> boardList = boardservice.boardList(pvo);
		return boardList;
			
	}
	//@RequestBody json형태의 http안에 body값의 내용을 javaObject로 변환해줌
	@PostMapping("/list")
	public List<BoardVO> PostBoardList(@RequestBody ParamVO pvo ,BoardVO bvo){
		pvo.setParam(pvo.getParam());
		pvo.setType(pvo.getType());
		List<BoardVO> boardList = boardservice.boardList(pvo);
		return boardList;
	}
	
	
}
