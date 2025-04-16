package com.study.aloha.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/aloha/request")
public class ControllerRequest {
	@GetMapping("/selects")
	public List<RequestBoard> requests() {
		// public ResponseEntity<List<RequestBoard>> Requests() {
		List<RequestBoard> requestBoardList = new ArrayList<>();
		requestBoardList.add(new RequestBoard("제목1", "작성자1", "내용1"));
		requestBoardList.add(new RequestBoard("제목2", "작성자2", "내용2"));
		requestBoardList.add(new RequestBoard("제목3", "작성자3", "내용3"));
		
		log.info(requestBoardList.toString());

		return requestBoardList;
		// return new ResponseEntity<>(requestBoardList, HttpStatus.OK);
	}
}
