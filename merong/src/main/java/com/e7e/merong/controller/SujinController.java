package com.e7e.merong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e7e.merong.service.SujinService;
import com.e7e.merong.vo.SujinVO;

// 컨트롤러는 접수창고다, 모든 고객요청은 접수창고를 거쳐야 한다!
@RestController	// @Controller + @ResponseBody
@RequestMapping("/api")
public class SujinController {
	
	/*
		Restful api 서비스는
		get 조회, post 생성, put 수정, delete 삭제를 의미
		강제 아니고, 관례!
	*/
	
	@Autowired	// 컨토를러는 서비스를 부름!
	private SujinService sujinService;
	
	@GetMapping("/sujins")
	public List<SujinVO> listSujin() {
		return sujinService.listSujin();
	}

	@GetMapping("/sujins/{seqNum}")
	public SujinVO getSujin(@PathVariable int seqNum) {
		
		SujinVO sujinVO = new SujinVO();
		sujinVO.setSujinNum(seqNum);
		
		return sujinService.getSujin(sujinVO);
	}
	
	@PostMapping("/sujins")
	public int insertSujin(@RequestBody SujinVO sujinVO) {	// JSON -> VO
		return sujinService.insertSujin(sujinVO);
	}
	
	@PutMapping("/sujins")
	public int updateSujin(@RequestBody SujinVO sujinVO) {	
		return sujinService.updateSujin(sujinVO);
	}
	
	@DeleteMapping("/sujins/{seqNum}")
	public int deleteSujin(@PathVariable int seqNum) {
		SujinVO sujinVO = new SujinVO();
		sujinVO.setSujinNum(seqNum);
		
		return sujinService.deleteSujin(sujinVO);
	}
}
