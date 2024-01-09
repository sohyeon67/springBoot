package com.e7e.merong.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString	// 디버깅에 유리, 1개씩 안 찍고 전체 속성 찍어줌
public class SujinVO {
	private int sujinNum;
	private String sujinName;
	private String sujinContent;
	private String sujinFile;			// 파일 경로 ex) /mcimg/호랑이.jpg
	private MultipartFile sujinFile2;	// form태그의 file
}
