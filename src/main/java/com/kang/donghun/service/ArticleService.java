package com.kang.donghun.service;

import com.kang.donghun.dto.Article;
import com.kang.donghun.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {



    @Autowired
    ArticleRepository articleRepository;

//    @Transactional
//    public Long save(Article article){
//        return articleRepository.save(article.toEntity()).getId();
//    }
//
//    @Transactional
//    public Long update(Long id, PostsUpdaterequestDto requestDto){
//        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다."));
//
//        posts.update(requestDto.getTitle(),requestDto.getContent());
//
//        return id;
//    }

    @Transactional
    public Long delete (Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));
        articleRepository.deleteById(id);
//        postsRepository.delete(posts);

        return id;

    }

}
