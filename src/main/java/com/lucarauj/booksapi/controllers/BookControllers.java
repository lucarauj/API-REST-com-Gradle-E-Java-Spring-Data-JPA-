package com.lucarauj.booksapi.controllers;

import com.lucarauj.booksapi.models.Author;
import com.lucarauj.booksapi.models.Book;
import com.lucarauj.booksapi.models.BookRequest;
import com.lucarauj.booksapi.repositories.AuthorRepositories;
import com.lucarauj.booksapi.repositories.BookRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookControllers {

    private final List<Book> books = new ArrayList<>();

    private final BookRepositories bookRepositories;
    private final AuthorRepositories authorRepositories;

    public BookControllers(final BookRepositories bookRepositories, final AuthorRepositories authorRepositories) {
        this.bookRepositories = bookRepositories;
        this.authorRepositories = authorRepositories;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepositories.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookId(@PathVariable UUID id) {

        Optional<Book> existingBook = bookRepositories.findById(id.toString());

        if(existingBook.isEmpty()) {
            return ResponseEntity.badRequest().body("Book not found");
        }

        return ResponseEntity.ok(existingBook.get());
    }

    @PostMapping
    public ResponseEntity<Object> createBook(@RequestBody BookRequest request) {

        Optional<Author> existingAuthor = authorRepositories.findById(request.getAuthorId());

        if(existingAuthor.isEmpty()) {
           return ResponseEntity.badRequest().body("Author not found");
        }

        Book book = new Book(
                null,
                request.getTitle(),
                request.getDescription(),
                existingAuthor.get()
        );

        return ResponseEntity.ok(bookRepositories.save(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable UUID id, @RequestBody BookRequest request) {

        Optional<Book> existingBook = bookRepositories.findById(id.toString());

        if(existingBook.isEmpty()) {
            return ResponseEntity.badRequest().body("Book not found");
        }

        Optional<Author> existingAuthor = authorRepositories.findById(request.getAuthorId());

        if(existingAuthor.isEmpty()) {
            return ResponseEntity.badRequest().body("Author not found");
        }

        Book bookToUpdate = existingBook.get();

        if(request.getTitle() != null) {
            bookToUpdate.setTitle(request.getTitle());
        }

        if(request.getDescription() != null) {
            bookToUpdate.setDescription(request.getDescription());
        }

        if(request.getAuthorId() != null) {
            bookToUpdate.setAuthor(existingAuthor.get());
        }

        return  ResponseEntity.ok(bookRepositories.save(bookToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable UUID id) {

        boolean existingBook = bookRepositories.existsById(id.toString());

        if(!existingBook) {
            return ResponseEntity.badRequest().body("Book not found");
        }

        bookRepositories.deleteById(id.toString());

        return ResponseEntity.noContent().build();
    }

}
