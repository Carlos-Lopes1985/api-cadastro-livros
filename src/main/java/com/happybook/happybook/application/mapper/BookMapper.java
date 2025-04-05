package com.happybook.happybook.application.mapper;

import com.happybook.happybook.application.dto.BookRequest;
import com.happybook.happybook.domain.model.Book;
import com.happybook.happybook.infra.out.persistence.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true) // Não estamos passando o id do BookRequest
    Book toBook(BookRequest bookRequest);

    BookEntity toModel(Book book);

    Book toDomain(BookEntity bookEntity);

    List<Book> toDomainList(List<BookEntity> bookEntities);

    List<BookEntity> toEntityList(List<Book> books);

}
