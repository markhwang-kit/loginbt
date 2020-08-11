package com.naver.dao;

import java.util.ArrayList;

import com.naver.dto.HugiDto;
import com.naver.dto.HugiPrintDto;

public interface HugiDao {

	// 데이터 넣고 
	public void insert(HugiDto dto);
	
	// 전체 데이터 가져오기
	public ArrayList<HugiPrintDto> select();
	
	// 점수 정보 업데이트
	public void update(HugiDto dto);
}