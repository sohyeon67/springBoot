package com.e7e.merong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration	// 얘만 붙이면 설정 파일로 인식!
//@EnableWebMvc, 그냥 스프링에서 필요
public class MyConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("요기가 실행되었는지 check?");
		registry.addResourceHandler("/mcimg/**")             // 웹 접근 경로 
		        .addResourceLocations("file:///c:/myUpload/");  // 서버내 실제 경로
		// file://는 프로토콜, /는 최상위 루트(윈도우 조상인 유닉스, 리눅스의 경우 c드라이브 없음)
		// mcimg는 다 저 폴더에서 찾아라
	}

}