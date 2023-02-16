package com.crawlTest.demo.controller;


import com.crawlTest.demo.domain.dto.BookInfoDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class JSoupController {

    @GetMapping("munPia")
    @ResponseBody
    public List<BookInfoDto> testMunpia() throws IOException {
        String url="https://novel.munpia.com/page/hd.platinum/view/search/keyword/%EB%B3%80%EB%B0%A9/order/search_result";

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("dl[class=detail]");
        String searchData="";

        List<BookInfoDto> infos=new ArrayList<>();
        for (Element link : links) {
            String title=link.select("dt").text();
            String tags=link.select("dd[class=genre]").select("strong").text();
            String author=link.select("dd[class=author]").select("strong").text();
            String plot=link.select("dd[class=synopsis]").text();

            BookInfoDto bookInfo=BookInfoDto.builder()
                    .title(title)
                    .tags(tags)
                    .author(author)
                    .plot(plot)
                    .build();
            infos.add(bookInfo);

            //searchData+=(title+tags+author);
        }

        return infos;
    }


    @GetMapping("kakaoPage")
    @ResponseBody
    public String test() throws IOException {
        String url="https://page.kakao.com/search/result?keyword=%EC%B2%9C&categoryUid=11";

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("dt");
        String searchData="";
        for (Element link : links) {
            searchData+=link.text()+" "+"\n";
        }
        return searchData;
    }
}
