package com.example.test.vo;




import lombok.Data;



@Data
public class BoardVO{ //DB안에 데이터를  담을 변수들
	
	private String boardId; //게시판번호
	private String title;	 //제목
	private String contents; //내용
	private String createId;//작성자id
	private String createDtime;//작성일
	private String userNm;	 //사용자명
	



}
