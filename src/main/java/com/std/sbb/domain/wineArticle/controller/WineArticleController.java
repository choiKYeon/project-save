package com.std.sbb.domain.wineArticle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class WineArticleController {

    @GetMapping("/list")
    public String list(){
        return "wineArticle_list";
    }

    @GetMapping("/create")
    public String articleCreate(){
        return "wineArticle_form";
    }

    @GetMapping("/detail")
    public String detail(){
        return "wineArticle_detail";
    }

    @GetMapping("/start")
    public String open(){
        return "open_site";
    }

    @GetMapping("/search")
    public String search() {
        return "idPasswordSearch_form";
    }
}