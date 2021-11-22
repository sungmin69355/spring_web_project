package com.sungmin.blog.web.dto;

import com.sungmin.blog.domain.posts.Posts;

public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){ //entity의 일부만 사용하므로 생성자로 entity를 받아서 필드 값에 넣는다.
        this.id = entity.getId();
        this.title= entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
