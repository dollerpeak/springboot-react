package com.study.aloha.blog.attach;

import lombok.Data;

@Data
public class AttachEntity {
	long id;
	long blogId;
	String originalName;
	String saveName;
	String path;
	String size;
	String frstRegDate;
	String frstRegUserId;
	String lastChgDate;
	String lastChgUserId;
	
	public AttachDto toDto() {
		AttachDto dto = new AttachDto();
		
		dto.blogId = blogId;
		dto.originalName = originalName;
		dto.saveName = saveName;
		dto.path = path;
		dto.size = size;
		dto.frstRegDate = frstRegDate;
		dto.frstRegUserId = frstRegUserId;
		dto.lastChgDate = lastChgDate;
		dto.lastChgUserId = lastChgUserId;
		
		return dto;
	}
}
