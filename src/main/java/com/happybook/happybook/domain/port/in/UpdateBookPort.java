package com.happybook.happybook.domain.port.in;

import com.happybook.happybook.domain.model.Book;

public interface UpdateBookPort {

    Book updateQuantity(Long id, Long quantity);
}
