package com.concretepage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concretepage.entity.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>  {
	
}
