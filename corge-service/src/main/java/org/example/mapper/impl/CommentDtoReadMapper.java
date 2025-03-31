package org.example.mapper.impl;

import org.example.dto.CommentDtoRead;
import org.example.entity.Comment;
import org.example.mapper.DtoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoReadMapper implements DtoMapper<CommentDtoRead, Comment> {

    private final ModelMapper modelMapper;

    @Autowired
    public CommentDtoReadMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDtoRead toDto(Comment comment) {
        return modelMapper.map(comment, CommentDtoRead.class);
    }

    @Override
    public Comment toModel(CommentDtoRead commentDtoRead) {
        return modelMapper.map(commentDtoRead, Comment.class);
    }
}
