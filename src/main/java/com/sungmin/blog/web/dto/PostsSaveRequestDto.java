package com.sungmin.blog.web.dto;

import com.sungmin.blog.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    // Entity 클래스는 req/res 클래스로 사용하면안되고 Dto 클래스를 이용해서 구현 이유는 Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스이기떄문에
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
