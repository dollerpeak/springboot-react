package com.study.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/")
//@Slf4j
//@RequiredArgsConstructor
public class ControllerMain {

	@GetMapping("/")
	String main() {
		return "/main";
	}

}
