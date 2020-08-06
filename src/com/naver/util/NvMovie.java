package com.naver.util;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.naver.dto.MovieDto;

public class NvMovie {
	// 그냥 매소드 만들어 봤어요~
	public static ArrayList<MovieDto> movie() throws IOException {
		// Dto 를 전달 하는 리스트
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();
		System.out.println("Title : 네이버 영화 크롤링한거");
		for (int i = 2; i < 12; i++) {
			System.out.println(i);
//			System.out.println("#old_content > table > tbody > tr:nth-child(" + i + ") > td.title > div > a");

			// CSS 선택자를 사용해 링크 추출하기
			Elements menus = doc.select("#old_content > table > tbody > tr:nth-child(" + i + ") > td.title > div > a");
			// 제목 링크 가져오기
			// #old_content > table > tbody > tr:nth-child(2) > td.title > div > a
			// #old_content > table > tbody > tr:nth-child(3) > td.title > div > a
			// #old_content > table > tbody > tr:nth-child(4) > td.title > div > a
			// ...
			// #old_content > table > tbody > tr:nth-child(11) > td.title > div > a

			// 위 링크에 각각 접속 해서 이미지 주소를 가져온다
			// #content > div.article > div.mv_info_area > div.poster > a > img
			// #content > div.article > div.mv_info_area > div.poster > a > img
			// 위 선택자를 doc.select() 에 넣어서 이미지 주소 가져 오기( menu.absUrl("src") )
			//
			// 반복문 적용하기
			for (Element menu : menus) {
				// 링크의 "title" 속성 값 추출하기
				String title = menu.attr("title").trim();
				// 링크의 URL 추출하기 (절대경로)
				String nextUrl = menu.absUrl("href");
				// log
				System.out.println(String.format("%s\n\t%s", title, nextUrl));
				// 링크 대상 페이지에 접근하기
				Document nextDoc = Jsoup.connect(nextUrl).get();
				// 상세 내용 추출하기
				String content = nextDoc.select("#content > div.article > div.mv_info_area > div.poster > a > img")
						.attr("src");
				System.out.println(content);

				// 크롤링 해온 데이터들을 Dto에 담는다.
				MovieDto dto = new MovieDto();
				dto.setTitle(title);
				dto.setLink(nextUrl);
				dto.setImgsrc(content);
				// Dto 담은 데이터를 list 에 담는다
				list.add(dto);
			}
		}
		return list;
	}

}
