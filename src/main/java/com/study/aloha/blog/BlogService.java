package com.study.aloha.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.DateFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BlogService {
	@Autowired
	BlogRepository blogRepository;

	// repository로 mapper연결할때
	public List<BlogDto> select() throws Exception {
		List<BlogDto> listDto = new ArrayList<>();
		List<BlogEntity> listEntity = blogRepository.select();

		log.info("service - select = " + listEntity.size());
		for (BlogEntity entity : listEntity) {
			//log.info("service - writer = " + entity.getWriter());
			listDto.add(entity.toDto());
		}

		return listDto;
	}
	
	@Autowired
	BlogMapper blogMapper;
	// interface mapper연결할때
	public List<BlogDto> select_mapper() throws Exception {
		List<BlogDto> listDto = new ArrayList<>();
		List<BlogEntity> listEntity = blogMapper.select();

		log.info("service - select_mapper = " + listEntity.size());
		for (BlogEntity entity : listEntity) {
			//log.info("service - writer = " + entity.getWriter());
			listDto.add(entity.toDto());
		}

		return listDto;
	}

	public BlogDto detail(long id) throws Exception {
		BlogEntity blogEntity = blogRepository.detail(id);
		BlogDto blogDto = blogEntity.toDto();

		return blogDto;
	}
	
	public long insert(BlogDto blogDto) throws Exception {
		BlogEntity blogEntity = blogDto.toEntity();
		if(blogEntity.getFrstRegUserId() == null || blogEntity.getFrstRegUserId().length() <= 0) {
			blogEntity.setFrstRegUserId("SYSTEM");
		}
		if(blogEntity.getLastChgUserId() == null || blogEntity.getLastChgUserId().length() <= 0) {
			blogEntity.setLastChgUserId("SYSTEM");
		}
		log.info("before blogEntity = " + blogEntity.toString());
		blogRepository.insert(blogEntity);
		log.info("after blogEntity = " + blogEntity.toString());

		return blogEntity.getId();
	}
	
	public int update(BlogDto blogDto) throws Exception {
		BlogEntity blogEntity = blogDto.toEntity();
		if(blogEntity.getFrstRegDate() == null || blogEntity.getFrstRegDate().length() <= 0) {
			blogEntity.setFrstRegDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
		}
		if(blogEntity.getLastChgDate() == null || blogEntity.getLastChgDate().length() <= 0) {
			blogEntity.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
		}
		int result = blogRepository.update(blogEntity);

		return result;
	}

	public int delete(long id) throws Exception {		
		int result = blogRepository.delete(id);

		return result;
	}

}
