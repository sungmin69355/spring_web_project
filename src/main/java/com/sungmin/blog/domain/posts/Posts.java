package com.sungmin.blog.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //롬곡 어노테이션
@NoArgsConstructor //롬곡 어노테이션 기본생성자 알아서 추가
@Entity //JPA의 어노테이션으로 테이블과 링크될 클래스임을 나타낸다. 여기서는 Posts, Entity 클래스는 setter를 생성하면 안된다.(차후에 복잡해짐...)
public class Posts {
    @Id //해당 테이블의 pk필드를 나타낸다. pk값은 long타입의 auto_increment를 추천
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk의 생성규칙 GenerationType.IDENTITY를 사용하면 auto_increment가 된다.
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼설정
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더패턴 클래스를 생
    public Posts(String title, String content,String author){
        this.title = title;
        this.content =content;
        this.author = author;
    }
}
