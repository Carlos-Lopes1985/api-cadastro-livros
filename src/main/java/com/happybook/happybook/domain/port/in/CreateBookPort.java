package com.happybook.happybook.domain.port.in;

import com.happybook.happybook.application.dto.BookRequest;
import com.happybook.happybook.domain.model.Book;

public interface CreateBookPort {

    Book create(BookRequest book);

}
