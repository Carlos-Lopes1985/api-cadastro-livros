package com.happybook.happybook.domain.port.in;

import com.happybook.happybook.domain.enums.Operation;
import com.happybook.happybook.domain.model.Book;

public interface UpdateBookPort {

    Book updateQuantity(Long id, Long quantity, Enum<Operation> Operation);
}
