package com.happybook.happybook.infra.out.persistence;

import com.happybook.happybook.application.mapper.BookMapper;
import com.happybook.happybook.domain.model.Book;
import com.happybook.happybook.domain.port.out.BookRepository;
import com.happybook.happybook.infra.out.persistence.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookJpaAdapter implements BookRepository {

    private BookMapper bookMapper;
    private final SpringDataBookRepository repository;

    public BookJpaAdapter(BookMapper bookMapper, SpringDataBookRepository repository) {
        this.bookMapper = bookMapper;
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        repository.save(bookEntity);
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        Optional<BookEntity> bookEntity = repository.findById(id);

        return bookEntity.map(bookMapper::toDomain);
    }


    @Override
    public List<Book> findAll() {
        List<BookEntity> books = repository.findAll();
        return bookMapper.toDomainList(books);
    }

    @Override
    public void saveAll(List<BookEntity> books) {
        repository.saveAll(books);
    }
}
