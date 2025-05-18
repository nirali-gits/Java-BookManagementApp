package com.example.bookmanagement.repository;

import com.example.bookmanagement.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
