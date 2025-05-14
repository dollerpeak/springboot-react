package com.study.aloha.blog.attach;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.study.common.DateFormat;
import com.study.common.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class AttachService {
	@Autowired
	Properties properties;
	@Autowired
	AttachRepository attachRepository;

	public List<AttachDto> select() throws Exception {
		List<AttachDto> listDto = new ArrayList<>();
		List<AttachEntity> listEntity = attachRepository.select();

		for (AttachEntity entity : listEntity) {
			listDto.add(entity.toDto());
		}

		return listDto;
	}

	public long insert(AttachDto dto) throws Exception {
		AttachEntity entity = dto.toEntity();

		if (entity.getFrstRegUserId() == null || entity.getFrstRegUserId().length() <= 0) {
			entity.setFrstRegUserId("SYSTEM");
		}
		if (entity.getLastChgUserId() == null || entity.getLastChgUserId().length() <= 0) {
			entity.setLastChgUserId("SYSTEM");
		}

		attachRepository.insert(entity);
		log.info("entity = " + entity.toString());

		return entity.getId();
	}

	public int update(AttachDto dto) throws Exception {
		int result = 0;
		AttachEntity entity = dto.toEntity();

		if (entity.getLastChgDate() == null || entity.getLastChgDate().length() <= 0) {
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

	public boolean upload(long id, MultipartFile multipartFile) throws Exception {
		boolean result = false;

		AttachDto dto = null;
		byte[] fileData = null;
		File file = null;

//		log.info("file, getOriginalFilename = " + multipartFile.getOriginalFilename());
//		log.info("file, getName = " + multipartFile.getName());
//		log.info("file, getContentType = " + multipartFile.getContentType());
//		log.info("file, getSize = " + multipartFile.getSize());
//		log.info("file, getResource = " + multipartFile.getResource());

		dto = new AttachDto();
		dto.setBlogId(id);
		dto.setOriginalName(multipartFile.getOriginalFilename());
		// UUID.randomUUID().toString();
		dto.setSaveName(DateFormat.getFormatString(System.currentTimeMillis(), "yyyyMMddHHmmssSSS") + "_" + multipartFile.getOriginalFilename());
		dto.setPath(properties.getProperties("spring.servlet.multipart.location"));
		dto.setSize(Long.toString(multipartFile.getSize()));
		dto.setFrstRegUserId("SYSTEM");
		dto.setLastChgUserId("SYSTEM");
		log.info("dto = " + dto.toString());

		// 실제 파일 저장
		// File 사용		
		file = new File(dto.getPath(), dto.getSaveName());
		fileData = multipartFile.getBytes();
		FileCopyUtils.copy(fileData, file);
		
		// MultipartFile 사용
		//multipartFile.transferTo(new File(dto.getPath(), dto.getSaveName()));
		
		attachRepository.insert(dto.toEntity());
		
		return result;
	}

}
