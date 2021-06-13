package com.kang.donghun.controller;

import com.kang.donghun.dto.Article;
import com.kang.donghun.oauth.LoginUser;
import com.kang.donghun.oauth.dto.SessionUser;
import com.kang.donghun.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("")
    public String setArticle(Article article, Model model , @LoginUser SessionUser user) {
        article.setRegisterDate(LocalDateTime.now());
        articleRepository.save(article);
        return "redirect:/article/" + article.getId();
    }

    @GetMapping("/{id}")
    public String getArticle(Model model, @PathVariable Long id , @LoginUser SessionUser user) {
        Article article = articleRepository.findById(id).get();

        model.addAttribute("article", article);
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userId", user.getId());
        }
        return "/view";
    }

    @GetMapping("/update/{id}")
    public String getArticleUpdate(Model model, @PathVariable Long id , @LoginUser SessionUser user) {
        Article article = articleRepository.findById(id).get();

        model.addAttribute("article", article);
        model.addAttribute("userName", user.getName());

        return "/update";
    }

    @PostMapping("/update/{id}")
    public String setArticleUpdate(Model model, @PathVariable Long id, Article updatedArticle) {
        Article article = articleRepository.findById(id).get();

        article.update(updatedArticle.getTitle(),updatedArticle.getContent(), LocalDateTime.now());
        articleRepository.save(article);
        return "redirect:/article/" + article.getId();

    }

    @GetMapping("/delete/{id}")
    public String setArticleDelete(Model model, @PathVariable Long id, Article deleteArticle) {
        Article article = articleRepository.findById(id).get();
        articleRepository.deleteById(id);

//        return "redirect:/article/" + deleteArticle.getId();
        return  "redirect:/bbsPage";
    }


}
