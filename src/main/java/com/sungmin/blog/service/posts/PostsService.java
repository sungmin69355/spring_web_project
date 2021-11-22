package com.sungmin.blog.service.posts;

import com.sungmin.blog.domain.posts.Posts;
import com.sungmin.blog.domain.posts.PostsRepository;
import com.sungmin.blog.web.dto.PostsResponseDto;
import com.sungmin.blog.web.dto.PostsSaveRequestDto;
import com.sungmin.blog.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) { //여기서 쿼리를 DB에 안날려도 기능이 돌아가는이유는 JPA에서 영속성 컨텍스트 떄문이다.
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 개시글이 없습니다. id =" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

}
