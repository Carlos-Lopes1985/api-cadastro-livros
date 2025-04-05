package com.happybook.happybook.domain.port.in;

import com.happybook.happybook.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface FindBookPort {

    List<Book> findAllBooks();

    Optional<Book> findById(Long id);
}
