package com.happybook.happybook.domain.port.out;


import com.happybook.happybook.domain.model.Book;
import com.happybook.happybook.infra.out.persistence.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
        Book save(Book book);
        Optional<Book> findById(Long id);
        List<Book> findAll();

        void saveAll(List<BookEntity>books);
    }

