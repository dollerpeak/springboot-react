package com.study.aloha.blog.attach;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AttachRepository {
	String namespace = "com.study.aloha.blog.attach.";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(AttachEntity entity) throws Exception {
		log.info("blog - insert");
		return sqlSessionTemplate.insert(namespace + "insert", entity);
	}

	public List<AttachEntity> select() throws Exception {
		log.info("repository - select");
		return sqlSessionTemplate.selectList(namespace + "select");
	}

	public int update(AttachEntity entity) throws Exception {
		log.info("blog - update");
		return sqlSessionTemplate.update(namespace + "update", entity);
	}

	public int delete(long id) throws Exception {
		log.info("blog - delete");
		return sqlSessionTemplate.delete(namespace + "delete", id);
	}

}
