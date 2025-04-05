package com.happybook.happybook.application.usecase;

import com.happybook.happybook.domain.model.Book;
import com.happybook.happybook.domain.port.in.FindBookPort;
import com.happybook.happybook.domain.port.out.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindBookUseCase implements FindBookPort {

    private final BookRepository bookRepository;

    public FindBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}
