package com.study.aloha.blog;

import lombok.Data;

@Data
public class BlogDto {
	long id;
	String title;
	String writer;
	String contents;
	long hits;
	String frstRegDate;
	String frstRegUserId;
	String lastChgDate;
	String lastChgUserId;
	
	public BlogEntity toEntity() {
		BlogEntity entity = new BlogEntity();
		
		entity.setId(id);
		entity.setTitle(title);
		entity.setWriter(writer);
		entity.setContents(contents);
		entity.setHits(hits);
		entity.setFrstRegDate(frstRegDate);
		entity.setFrstRegUserId(frstRegUserId);
		entity.setLastChgDate(lastChgDate);
		entity.setLastChgUserId(lastChgUserId);
		
		return entity;
	}
}
