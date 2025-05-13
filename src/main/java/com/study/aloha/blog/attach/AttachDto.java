package com.study.aloha.blog.attach;

import lombok.Data;

@Data
public class AttachDto {
	long id;
	long blogId;
	String name;
	String path;
	String frstRegDate;
	String frstRegUserId;
	String lastChgDate;
	String lastChgUserId;
	
	public AttachEntity toEntity() {
		AttachEntity entity = new AttachEntity();
		
		entity.blogId = blogId;
		entity.name = name;
		entity.path = path;
		entity.frstRegDate = frstRegDate;
		entity.frstRegUserId = frstRegUserId;
		entity.lastChgDate = lastChgDate;
		entity.lastChgUserId = lastChgUserId;
		
		return entity;
	}
}
