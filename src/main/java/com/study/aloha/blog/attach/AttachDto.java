package com.study.aloha.blog.attach;

import lombok.Data;

@Data
public class AttachDto {
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
	
	public AttachEntity toEntity() {
		AttachEntity entity = new AttachEntity();
		
		entity.blogId = blogId;
		entity.originalName = originalName;
		entity.saveName = saveName;
		entity.path = path;
		entity.size = size;
		entity.frstRegDate = frstRegDate;
		entity.frstRegUserId = frstRegUserId;
		entity.lastChgDate = lastChgDate;
		entity.lastChgUserId = lastChgUserId;
		
		return entity;
	}
}
