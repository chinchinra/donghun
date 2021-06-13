package com.kang.donghun.controller;

import com.kang.donghun.dto.Article;
import com.kang.donghun.oauth.LoginUser;
import com.kang.donghun.oauth.dto.SessionUser;
import com.kang.donghun.repository.ArticleRepository;
import com.kang.donghun.service.PageN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    PageN page;

    @GetMapping("/")
    public String goToMain(Model model , @LoginUser SessionUser user){

        if (user != null) {
            model.addAttribute("userName",user.getEmail());
        }

        return "main";
    }

    @GetMapping("bbsPage")
    public String getArticleList(Model model, @LoginUser SessionUser user) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        articleList.forEach(System.out::println);

        if (user != null) {
            model.addAttribute("userName", user.getName()); }

        model.addAttribute("articleList", articleRepository.findAll(PageRequest.of(page.getPageNumber()-1,5)));
        model.addAttribute("pageNumber", page.getPageNumber());

        return "bbsPage";
    }

    @GetMapping("next/")
    public String nextPage( Model model ) {

        page.nextPageNumber();
        model.addAttribute("articleList", articleRepository.findAll(PageRequest.of(page.getPageNumber()-1,5)));
        model.addAttribute("pageNumber", page.getPageNumber());
        return "bbsPage";
    }
    @GetMapping("prev/")
    public String prevPage( Model model) {

        if(page.getPageNumber() > 1){
            page.prevPageNumber();

        }
        model.addAttribute("articleList", articleRepository.findAll(PageRequest.of(page.getPageNumber()-1,5)));
        model.addAttribute("pageNumber",page.getPageNumber());
        //페이지가 0이 될떄 를 작성
        return "bbsPage";
    }

    @GetMapping("index")
    public String index(Model model ,@LoginUser SessionUser user ){

        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userId", user.getId());
        }

        return "index";
    }
}
