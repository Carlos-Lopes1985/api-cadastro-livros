package com.happybook.happybook.application.usecase;

import com.happybook.happybook.application.dto.BookRequest;
import com.happybook.happybook.application.mapper.BookMapper;
import com.happybook.happybook.domain.model.Book;
import com.happybook.happybook.domain.port.in.CreateBookPort;
import com.happybook.happybook.domain.port.out.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class CreateBookUseCase implements CreateBookPort {

    private final BookRepository bookRepository;
    private BookMapper bookMapper;

    public CreateBookUseCase(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Book create(BookRequest book) {
        return bookRepository.save(bookMapper.toBook(book));
    }

}
