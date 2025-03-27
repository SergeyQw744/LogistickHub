package org.example.service.impl;

import org.example.entity.Cargo;
import org.example.entity.Comment;
import org.example.repository.CargoRepository;
import org.example.repository.CommentRepository;
import org.example.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CargoRepository cargoRepository;
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CargoRepository cargoRepository){
        this.commentRepository = commentRepository;
        this.cargoRepository = cargoRepository;
    }

    @Override
    @Transactional
    public void addComment(Comment comment, Long cargoId) {
        Cargo cargo = cargoRepository.findById(cargoId).orElseThrow(() -> new RuntimeException("Cargo not found!"));
        Comment commentSaved = commentRepository.save(comment);
        cargo.getComments().add(commentSaved);
        commentSaved.setCargo(cargo);
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        Comment commentDeleted = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found!"));
        Cargo cargo = cargoRepository.findByComments_Id(id).orElseThrow(() -> new RuntimeException("Cargo not found!"));
        cargo.setComments(cargo.getComments()
                .stream()
                .filter(comment -> !comment.getId().equals(commentDeleted.getId()))
                .collect(Collectors.toList())
        );
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Comment> getCommentsByCargo(Long cargoId) {
        return cargoRepository.findById(cargoId)
                .orElseThrow(() -> new RuntimeException("Cargo not found!"))
                .getComments();
    }
}
