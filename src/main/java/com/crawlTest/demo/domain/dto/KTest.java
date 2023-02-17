package com.crawlTest.demo.domain.dto;

import lombok.Data;

@Data
public class KTest {
    private final String url;

    public KTest(String url) {
        this.url = url;
    }

}
