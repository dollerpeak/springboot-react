package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringbootReactApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootReactApplication.class, args);

		// di test
		TestDI(applicationContext);
		
		// http test
		TestHttp();
	}
	
	static void TestDI(ApplicationContext nApplicationContext) {
//		TestDi testDi = new TestDi(nApplicationContext);
//		testDi.beanPrint();
//		nApplicationContext.getBean(Total.class).print();
	}
	
	static void TestHttp() {
		//TestRestTemplate testRestTemplate = new TestRestTemplate();
		//testRestTemplate.request();
		
		//TestWebClient testWebClient = new TestWebClient();
		//testWebClient.request();
		
//		TestRestClient testRestClient = new TestRestClient();
//		testRestClient.request();
	}

}
