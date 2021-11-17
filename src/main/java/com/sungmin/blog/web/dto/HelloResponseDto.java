package com.sungmin.blog.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든필드의 get 메소드를 생성
@RequiredArgsConstructor //선언된 모든 final필드가 포함된 생성자를 생성해준다.
public class HelloResponseDto {
        private final String name;
        private final int amount;

}
