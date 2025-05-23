package com.canesblack.spring_project1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.canesblack.spring_project1.entity.User;

@Mapper
//자동으로 @Component기능비슷하게 스프링컨테이너에 등록이됨(인터페이스)
//자바언어와mysql언어를 통역해주는 역할을 하는게 
public interface UserMapper {

	
//	CRUD의 CREATE에 해당하는 기능중하나
	@Insert("INSERT INTO backend_spring_project.user(username,password,writer,role)"
			+ " VALUES(#{username},#{password},#{writer},#{role})")
	void insertUser(User user);
//	void=> 우리가 데이터베이스에서 백엔드영역(스프링프레임워크)으로 데이터를 
//	가져오는게 없기 떄문에 void로 가져오는게 없다고 작성한다.
//	CRUD의 READ에 해당하는 기능중하나
	 @Select("SELECT username,password,writer,role FROM backend_spring_project.user WHERE username=#{username}")
	User findByUsername(String username);
	
	@Select("SELECT writer FROM backend_spring_project.user WHERE username=#{username}")
	String findWriter(String username);
	
	
//	CRUD의 UPDATE에 해당하는 기능중하나
//	@Update()
//	CRUD의 DELETE에 해당하는 기능중하나
//	@Delete()
}
