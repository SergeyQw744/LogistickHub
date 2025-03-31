package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentDtoCreate {
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 2000)
    private String text;

    public CommentDtoCreate(){}

    public CommentDtoCreate(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
