package com.study.aloha.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.common.DateFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/aloha/blog/multipart")
public class BlogMultipartController {
	@Autowired
	BlogService blogService;

	@GetMapping("/select")
	public String select(Model model) throws Exception{

		// repository로 mapper연결할때
		model.addAttribute("blogList", blogService.select());
		// interface mapper연결할때
		//model.addAttribute("blogList", blogService.select_mapper());
		log.info("controller - select");
		
		return "/aloha/blog/multipart/select";
	}
	
	@GetMapping("/insert")
	public String insert() throws Exception {
		return "/aloha/blog/multipart/insert";
	}
	
	@PostMapping("/insert")
	public String insert(BlogDto dto) throws Exception {		
		log.info("dto = " + dto.toString());
		
		long id = blogService.insert(dto);
		log.info("id = " + id);
		
		//test
//		Blog test = new Blog(0, "test", "test", "test", 
//				DateFormat.getFormatString(System.currentTimeMillis(), null),
//				DateFormat.getFormatString(System.currentTimeMillis(), null));		
//		model.addAttribute("blog", test);
		
		return "redirect:/aloha/blog/multipart/select";
	}
	
	
}
