package com.crawlTest.demo.domain.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MunpiaInfoDto {

    private String title;
    private String tags;
    private String author;
    private String plot;

    @Builder
    public MunpiaInfoDto(String title, String tags, String author, String plot){
        this.title=title;
        this.tags=tags;
        this.author=author;
        this.plot=plot;
    }
}
