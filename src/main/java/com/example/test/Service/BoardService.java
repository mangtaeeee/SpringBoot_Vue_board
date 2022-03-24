package com.example.test.Service;

import java.util.List;

import com.example.test.vo.BoardVO;
import com.example.test.vo.ParamVO;

public interface BoardService {
	public List<BoardVO> boardList(ParamVO pvo);
}
