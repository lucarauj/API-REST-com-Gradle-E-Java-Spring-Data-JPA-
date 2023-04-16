package com.lucarauj.booksapi.controllers;

import com.lucarauj.booksapi.models.Author;
import com.lucarauj.booksapi.models.AuthorRequest;
import com.lucarauj.booksapi.repositories.AuthorRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorControllers {

    private final AuthorRepositories authorRepositories;

    public AuthorControllers(AuthorRepositories authorRepositories) {
        this.authorRepositories = authorRepositories;
    }

    @PostMapping
    public Author createBook(@RequestBody AuthorRequest authorRequest) {

        Author author = new Author(
                null,
                authorRequest.getName(),
                Collections.emptyList()
        );
        return authorRepositories.save(author);
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorRepositories.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAuthorId(@PathVariable UUID id) {

        Optional<Author> existingAuthor = authorRepositories.findById(id.toString());

        if(existingAuthor.isEmpty()) {
            return ResponseEntity.badRequest().body("Author not found");
        }

        return ResponseEntity.ok(existingAuthor.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable UUID id, @RequestBody AuthorRequest request) {

        Optional<Author> existingAuthor = authorRepositories.findById(id.toString());

        if(existingAuthor.isEmpty()) {
            return ResponseEntity.badRequest().body("Author not found");
        }

        Author authorToUpdate = existingAuthor.get();

        authorToUpdate.setName(request.getName());

        return  ResponseEntity.ok(authorRepositories.save(authorToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable UUID id) {

        Optional<Author> author = authorRepositories.findById(id.toString());

        if(!author.isPresent()) {
            return ResponseEntity.badRequest().body("Author not found");
        }

        if(!author.get().getBooks().isEmpty()) {
            return ResponseEntity.badRequest().body("Author is related to a Book");
        }

        authorRepositories.deleteById(id.toString());

        return ResponseEntity.noContent().build();
    }
}
