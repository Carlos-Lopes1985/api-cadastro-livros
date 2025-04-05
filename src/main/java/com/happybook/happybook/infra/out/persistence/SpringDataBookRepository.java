package com.happybook.happybook.infra.out.persistence;

import com.happybook.happybook.infra.out.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBookRepository extends JpaRepository<BookEntity, Long> {
}
