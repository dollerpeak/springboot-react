package com.study.aloha.blog.comment;

import lombok.Data;

@Data
public class CommentDto {
	long id;
	long blogId;
	String writer;
	String contents;
	String frstRegDate;
	String frstRegUserId;
	String lastChgDate;
	String lastChgUserId;
	
	public CommentEntity toEntity() {
		CommentEntity entity = new CommentEntity();
		
		entity.blogId = blogId;
		entity.writer = writer;
		entity.contents = contents;
		entity.frstRegDate = frstRegDate;
		entity.frstRegUserId = frstRegUserId;
		entity.lastChgDate = lastChgDate;
		entity.lastChgUserId = lastChgUserId;
		
		return entity;
	}
}
