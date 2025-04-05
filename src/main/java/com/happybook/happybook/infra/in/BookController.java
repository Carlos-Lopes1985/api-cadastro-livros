package com.happybook.happybook.infra.in;

import com.happybook.happybook.application.dto.BookRequest;
import com.happybook.happybook.domain.model.Book;
import com.happybook.happybook.domain.port.in.CreateBookPort;
import com.happybook.happybook.domain.port.in.FindBookPort;
import com.happybook.happybook.domain.port.in.UpdateBookPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookPort createBookPort;

    private  final UpdateBookPort updateBookPort;
    private final FindBookPort findBookPort;

    public BookController(CreateBookPort createBookPort, UpdateBookPort updateBookPort, FindBookPort findBookPort) {
        this.createBookPort = createBookPort;
        this.updateBookPort = updateBookPort;
        this.findBookPort = findBookPort;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok(createBookPort.create(bookRequest));
    }

    @GetMapping
    public ResponseEntity<List<Book>>findAllBooks(){
        var books = findBookPort.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> findByIdBook(@PathVariable Long bookId) {
        return findBookPort.findById(bookId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{bookId}/quantity")
    public Book updateQuantity(@PathVariable Long bookId, @RequestParam Long quantity) {
        return updateBookPort.updateQuantity(bookId, quantity);
    }
}

