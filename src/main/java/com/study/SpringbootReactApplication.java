package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

//import com.study.aloha.tutorial.Test;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@SpringBootApplication
public class SpringbootReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootReactApplication.class, args);
	}

//	public static void main(String[] args) {
//		ApplicationContext applicationContext = SpringApplication.run(SpringbootReactApplication.class, args);
//
//		// IoC 컨테이너에 등록된 모든 빈의 이름 조회
//		log.info(">>>>> 빈 이름");
//		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
//		// 조회된 빈 이름 출력
//		for (String beanName : allBeanNames) {
//			if (beanName.contains("person") == true || beanName.contains("student") == true
//					|| beanName.contains("test") == true) {
//				log.info(beanName);
//			}
//		}
//
//		// getBean() : 빈 이름으로 빈 객체를 가져옴
//		Test test = applicationContext.getBean(Test.class);
//		test.print();
//		log.info("<<<<< 빈 이름");
//	}

}
