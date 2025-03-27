package org.example.service;

import org.example.entity.Comment;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment, Long cargoId);

    void deleteComment(Long id);

    List<Comment> getCommentsByCargo(Long cargoId);
}
