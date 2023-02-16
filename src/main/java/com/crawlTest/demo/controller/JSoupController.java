package com.crawlTest.demo.controller;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@Controller
public class JSoupController {

    @GetMapping("munPia")
    @ResponseBody
    public String testJSoup() throws IOException {
        String url="https://novel.munpia.com/page/hd.platinum/view/search/keyword/%EB%B3%80%EB%B0%A9/order/search_result";

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("dt");
        String searchData="";
        for (Element link : links) {

            searchData+=link.text()+" "+"\n";
        }

        return searchData;
    }
}
