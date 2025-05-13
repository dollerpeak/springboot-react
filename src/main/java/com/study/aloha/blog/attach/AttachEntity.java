package com.study.aloha.blog.attach;

import lombok.Data;

@Data
public class AttachEntity {
	long id;
	long blogId;
	String name;
	String path;
	String frstRegDate;
	String frstRegUserId;
	String lastChgDate;
	String lastChgUserId;
	
	public AttachDto toDto() {
		AttachDto dto = new AttachDto();
		
		dto.blogId = blogId;
		dto.name = name;
		dto.path = path;
		dto.frstRegDate = frstRegDate;
		dto.frstRegUserId = frstRegUserId;
		dto.lastChgDate = lastChgDate;
		dto.lastChgUserId = lastChgUserId;
		
		return dto;
	}
}
