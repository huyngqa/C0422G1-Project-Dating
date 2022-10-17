package com.codegym.dating.dto;

import com.codegym.dating.model.Post;
import com.codegym.dating.model.User;

public class ClassCommentDto {

    private Integer idComment;
    private String content;
    private ClassPostDto postDto;
    private ClassUserDto userDto;

    public ClassCommentDto() {
    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ClassPostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(ClassPostDto postDto) {
        this.postDto = postDto;
    }

    public ClassUserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(ClassUserDto userDto) {
        this.userDto = userDto;
    }
}
