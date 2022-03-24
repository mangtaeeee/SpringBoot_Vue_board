package com.example.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test.vo.BoardVO;
import com.example.test.vo.ParamVO;

@Mapper
public interface BoardDAO {
	public List<BoardVO> boardList(ParamVO pvo);
	
}
 
