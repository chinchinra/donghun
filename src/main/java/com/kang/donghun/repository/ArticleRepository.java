package com.kang.donghun.repository;

import com.kang.donghun.dto.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
