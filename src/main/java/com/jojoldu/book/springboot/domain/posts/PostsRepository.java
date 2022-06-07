package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // Entity 클래스와 Repository 함께 위치.
    // 기본적인 CRUD메소드 자동 생성됨
}
