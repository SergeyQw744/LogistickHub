package org.example.mapper.impl;

import org.example.dto.CommentDtoCreate;
import org.example.entity.Comment;
import org.example.mapper.DtoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoCreateMapper implements DtoMapper<CommentDtoCreate, Comment> {

    private final ModelMapper modelMapper;

    @Autowired
    public CommentDtoCreateMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDtoCreate toDto(Comment comment) {
        return modelMapper.map(comment, CommentDtoCreate.class);
    }

    @Override
    public Comment toModel(CommentDtoCreate commentDtoCreate) {
        return modelMapper.map(commentDtoCreate, Comment.class);
    }
}
