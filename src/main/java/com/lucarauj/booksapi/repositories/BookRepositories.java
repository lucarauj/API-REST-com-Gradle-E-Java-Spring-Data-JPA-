package com.lucarauj.booksapi.repositories;

import com.lucarauj.booksapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositories extends JpaRepository<Book, String> {
}
