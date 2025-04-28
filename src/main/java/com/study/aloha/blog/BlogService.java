package com.study.aloha.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BlogService {
	@Autowired
	BlogRepository blogRepository;

	public List<BlogDto> select() throws Exception {
		List<BlogDto> listDto = new ArrayList<>();
		List<BlogEntity> listEntity = blogRepository.select();

		log.info("service - select = " + listEntity.size());
		for (BlogEntity entity : listEntity) {
			log.info("service - writer = " + entity.getWriter());
			listDto.add(entity.toDto());
		}

		return listDto;
	}
}
