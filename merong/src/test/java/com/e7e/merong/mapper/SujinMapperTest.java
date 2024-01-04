package com.e7e.merong.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.e7e.merong.vo.SujinVO;

// 맵퍼 동작은 서비스/컨트롤러 만들기 전에 테스트로 검증하는 것이 유리!
@SpringBootTest
public class SujinMapperTest {

	@Autowired
	private SujinMapper sujinMapper;
	
	@Test
	@DisplayName("길동테스트")
	@Disabled	// 이젠 안 할거얌!!
	public void insertTest() {
		SujinVO sujinVO;
		int effectedLine = 0;
		for(int i=1; i<=10; i++) {
			sujinVO = new SujinVO();
			sujinVO.setSujinName("길동"+i);
			sujinVO.setSujinContent("내용"+i);
			sujinVO.setSujinFile("파일"+i);
			effectedLine += sujinMapper.insertSujin(sujinVO);
		}
		// 테스트 결과는 effectedLine가 10이어야 한다. 아니면 실패
		assertEquals(11, effectedLine);
	}
	
	@Test
	@DisplayName("길동테스트")
	public void deleteTest() {
		SujinVO sujinVO;
		int effectedLine = 0;
		for(int i=1; i<=41; i++) {
			sujinVO = new SujinVO();
			sujinVO.setSujinNum(i);
			effectedLine += sujinMapper.deleteSujin(sujinVO);
		}
		// 테스트 결과는 effectedLine가 10이어야 한다. 아니면 실패
		assertEquals(40, effectedLine);
	}
}
