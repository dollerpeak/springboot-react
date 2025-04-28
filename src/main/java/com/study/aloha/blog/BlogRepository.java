package com.study.aloha.blog;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BlogRepository {
	String namespace = "com.study.aloha.blog.";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(BlogEntity blogEntity) throws Exception {
		log.info("blog - insert");
		return sqlSessionTemplate.insert(namespace + "insert", blogEntity);
	}

	public List<BlogEntity> select() throws Exception {
		log.info("repository - select");
		return sqlSessionTemplate.selectList(namespace + "select");
	}

	public BlogEntity detail(long id) throws Exception {
		log.info("blog - detail");
		return sqlSessionTemplate.selectOne(namespace + "detail", id);
	}

	public int update(BlogEntity blogEntity) throws Exception {
		log.info("blog - update");
		return sqlSessionTemplate.update(namespace + "update", blogEntity);
	}

	public int delete(long id) throws Exception {
		log.info("blog - delete");
		return sqlSessionTemplate.delete(namespace + "delete", id);
	}

}
