package com.study.aloha.request;

import lombok.Data;

@Data
public class RequestBoard {
	int boardNo;
	String title;
	String writer;
	String content;
	String regDate;
	String updDate;
	int views;

	public RequestBoard(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
}
