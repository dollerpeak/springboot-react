package com.study.aloha.test.reponse;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.aloha.test.request.RequestBoard;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/aloha/test/response")
public class ControllerResponse {

	@GetMapping(value = "/login")
	//public String user() {
	public void user() {
		log.info("[GET] - /login - 로그인 페이지");
		//return "/aloha/test/response/login";
	}

	@GetMapping(value = { "/", "" })
	public String home() {
		log.info("[GET] - / - 메인 페이지");
		return "/aloha/test/response/index";
	}

	@ResponseBody
	@GetMapping(value = "/hello")
	public String hello() {
		log.info("[GET] - /hello - 뷰가 아닌 문자열 본문을 응답합니다.");
		return "Hello Spring Boot~!";
	}
	
	@ResponseBody
	@GetMapping(value = "/object")
	public RequestBoard object() {
		RequestBoard requestBoard = new RequestBoard("제목", "작성자", "내용");
		return requestBoard;
	}
	
	@ResponseBody
	@GetMapping(value = "/entity")
	public ResponseEntity<String> entity() {		
		//return new ResponseEntity<>("success", HttpStatus.OK);
		return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
	}
	
	@ResponseBody
	@GetMapping(value = "/image")
	public ResponseEntity<byte[]> image() throws IOException {
		log.info("[GET] - image");
		//ClassPathResource imageFile = new ClassPathResource("/static/img/hamburger.png");
		ClassPathResource imageFile = new ClassPathResource("/static/img/beef.jpg");
		byte[] imageByte = imageFile.getContentAsByteArray();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		//httpHeaders.setContentType(MediaType.IMAGE_PNG);
		httpHeaders.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<>(imageByte, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping(value = "/download")
	public ResponseEntity<byte[]> download() throws IOException {
		log.info("[GET] - image");
		ClassPathResource imageFile = new ClassPathResource("/static/img/beef.jpg");
		byte[] imageByte = imageFile.getContentAsByteArray();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		httpHeaders.setContentDispositionFormData("attchment", "beef.jpg");

		return new ResponseEntity<>(imageByte, httpHeaders, HttpStatus.OK);
	}
	
	

}



