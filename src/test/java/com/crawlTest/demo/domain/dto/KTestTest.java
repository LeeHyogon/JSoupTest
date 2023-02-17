package com.crawlTest.demo.domain.dto;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



class KTestTest {

    @Test
    public void kTest() throws Exception {
        //given
        String url="https://page.kakao.com/search/result?keyword=%EC%B2%9C&categoryUid=11";
        //when

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("div");
        System.out.println("실행확인");
        for(Element link : links){
            System.out.println(link.text());

        }


        //then
    }

}