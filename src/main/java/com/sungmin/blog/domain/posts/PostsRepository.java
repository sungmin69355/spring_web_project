package com.sungmin.blog.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Entity와 Repository는 항상 함께 위치해야한다. 그래서 도메인끼리 관리
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
