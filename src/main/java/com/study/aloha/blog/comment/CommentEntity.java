package com.study.aloha.blog.comment;

import lombok.Data;

@Data
public class CommentEntity {
	long id;
	long blogId;
	String writer;
	String contents;
	String frstRegDate;
	String frstRegUserId;
	String lastChgDate;
	String lastChgUserId;
	
	public CommentDto toDto() {
		CommentDto dto = new CommentDto();
		
		dto.blogId = blogId;
		dto.writer = writer;
		dto.contents = contents;
		dto.frstRegDate = frstRegDate;
		dto.frstRegUserId = frstRegUserId;
		dto.lastChgDate = lastChgDate;
		dto.lastChgUserId = lastChgUserId;
		
		return dto;
	}
}
