package com.codegym.dating.dto;


import com.codegym.dating.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;

public class ClassPostDto {

    private Integer idPost;
    private String content;
    private String media;
    private LocalDateTime time;
    private ClassUserDto userDto;

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public ClassUserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(ClassUserDto userDto) {
        this.userDto = userDto;
    }
}
