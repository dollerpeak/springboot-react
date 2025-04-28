package com.study.aloha.blog;

import lombok.Data;

@Data
public class BlogEntity {
	long id;
	String title;
	String writer;
	String contents;
	long hits;
	String frstRegDate;
	String frstRegUserId;
	String lastChgDate;
	String lastChgUserId;
	
	public BlogDto toDto() {
		BlogDto dto = new BlogDto();
		
		dto.setId(id);
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContents(contents);
		dto.setHits(hits);
		dto.setFrstRegDate(frstRegDate);
		dto.setFrstRegUserId(frstRegUserId);
		dto.setLastChgDate(lastChgDate);
		dto.setLastChgUserId(lastChgUserId);
		
		return dto;
	}
	
}
