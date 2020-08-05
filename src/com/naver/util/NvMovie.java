package com.naver.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NvMovie {
	// 그냥 매소드 만들어 봤어요~
	public static void movie() throws IOException {
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();
		System.out.println("Title : 네이버 영화 크롤링한거");
		// CSS 선택자를 사용해 링크 추출하기
		Elements menus = doc.select("#old_content > table > tbody > tr:nth-child(3) > td.title > div > a");
		// 제목 링크 가져오기
		// #old_content > table > tbody > tr:nth-child(2) > td.title > div > a
		// #old_content > table > tbody > tr:nth-child(3) > td.title > div > a
		// #old_content > table > tbody > tr:nth-child(4) > td.title > div > a
		// ...
		// #old_content > table > tbody > tr:nth-child(11) > td.title > div > a
		
		// 위 링크에 각각 접속 해서 이미지 주소를 가져온다
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
//			Document nextDoc = Jsoup.connect(nextUrl).get();
			// 상세 내용 추출하기
//			String content = nextDoc.select("div.mw-parser-output").html();
//			System.out.println(content);
		}
	}

}
