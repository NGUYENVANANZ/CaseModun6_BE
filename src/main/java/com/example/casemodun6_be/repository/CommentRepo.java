package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment,Long> {
}
