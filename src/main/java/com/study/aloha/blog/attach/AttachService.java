package com.study.aloha.blog.attach;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.DateFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AttachService {
	@Autowired
	AttachRepository attachRepository;
	
	public List<AttachDto> select() throws Exception {
		List<AttachDto> listDto = new ArrayList<>();
		List<AttachEntity> listEntity = attachRepository.select();
		
		for(AttachEntity entity : listEntity) {
			listDto.add(entity.toDto());
		}
		
		return listDto;
	}
	
	public long insert(AttachDto dto) throws Exception {		
		AttachEntity entity = dto.toEntity();
		
		if(entity.getFrstRegUserId() == null || entity.getFrstRegUserId().length() <= 0) {
			entity.setFrstRegUserId("SYSTEM");
		}
		if(entity.getLastChgUserId() == null || entity.getLastChgUserId().length() <= 0) {
			entity.setLastChgUserId("SYSTEM");
		}
		
		attachRepository.insert(entity);
		log.info("entity = " + entity.toString());
		
		return entity.getId();
	}
	
	public int update(AttachDto dto) throws Exception {
		int result = 0;
		AttachEntity entity = dto.toEntity();

		if(entity.getLastChgDate() == null || entity.getLastChgDate().length() <= 0) {			
			entity.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
		}
		
		result = attachRepository.update(entity);
		
		return result;
	}
	
	public int delete(long id) throws Exception {
		int result = 0;		
		result = attachRepository.delete(id);
		
		return result;
	}
	

}
