package org.example.dto;

import java.util.Date;

public class CommentDtoRead extends CommentDtoCreate{

    private Date timestampOfRegistration;

    public CommentDtoRead(){
        super();
    }

    public CommentDtoRead(String text, Date timestampOfRegistration) {
        super(text);
        this.timestampOfRegistration = timestampOfRegistration;
    }

    public Date getTimestampOfRegistration() {
        return timestampOfRegistration;
    }

    public void setTimestampOfRegistration(Date timestampOfRegistration) {
        this.timestampOfRegistration = timestampOfRegistration;
    }
}
