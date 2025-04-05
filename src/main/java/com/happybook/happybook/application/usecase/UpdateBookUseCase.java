package com.happybook.happybook.application.usecase;

import com.happybook.happybook.domain.model.Book;
import com.happybook.happybook.domain.port.in.UpdateBookPort;
import com.happybook.happybook.domain.port.out.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookUseCase implements UpdateBookPort {

    private final BookRepository bookRepository;

    public UpdateBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book updateQuantity(Long id, Long quantity) {
        // Busca o livro pelo ID
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Verifica se a quantidade solicitada é maior que a disponível
        if (quantity > book.getQuantity()) {
            throw new RuntimeException("Quantidade solicitada não pode ser maior que a de estoque");
        }

        // Atualiza a quantidade do estoque
        book.setQuantity(book.getQuantity() - quantity);

        // Salva e retorna o livro atualizado
        return bookRepository.save(book);
    }
}
