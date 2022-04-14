package com.example.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.dao.BoardDAO;
import com.example.test.vo.BoardVO;
import com.example.test.vo.ParamVO;

import lombok.Setter;

@Service 
public class BoardServiceImpl implements BoardService{
	

	@Resource 
	private BoardDAO boardDao;
	
	@Override
	public List<BoardVO> boardList(ParamVO pvo) {
		//BoardVO형태로 받아온 리스트에 Dao에서 실행한 쿼리 값 담아서 반환
		List<BoardVO> list = boardDao.boardList(pvo);
		return list;
	}

}

