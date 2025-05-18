package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Genre;
import com.example.bookmanagement.repository.GenreRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreService genreService;

    private Genre genre;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        genre = new Genre();
        genre.setId(1L);
        genre.setName("Horror");
    }

    @Test
    void testFindAll() {
        when(genreRepository.findAll()).thenReturn(List.of(genre));
        List<Genre> result = genreService.findAll();
        assertThat(result).containsExactly(genre);
    }

    @Test
    void testFindById() {
        when(genreRepository.findById(1L)).thenReturn(Optional.of(genre));
        Optional<Genre> result = genreService.findById(1L);
        assertThat(result).isPresent().contains(genre);
    }

    @Test
    void testSave() {
        when(genreRepository.save(genre)).thenReturn(genre);
        Genre result = genreService.save(genre);
        assertThat(result).isEqualTo(genre);
    }

    @Test
    void testDeleteById() {
        doNothing().when(genreRepository).deleteById(1L);
        genreService.deleteById(1L);
        verify(genreRepository, times(1)).deleteById(1L);
    }
}
