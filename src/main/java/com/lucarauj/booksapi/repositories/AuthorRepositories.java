package com.lucarauj.booksapi.repositories;

import com.lucarauj.booksapi.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepositories extends JpaRepository<Author, String> {
}
