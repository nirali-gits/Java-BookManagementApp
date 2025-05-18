package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.Genre;
import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.repository.BookRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("Fiction");

        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("Penguin");
        publisher.setAddress("NY");

        book = new Book();
        book.setId(1L);
        book.setTitle("Sample Book");
        book.setAuthor("John Doe");
        book.setGenre(genre);
        book.setPublisher(publisher);
    }

    @Test
    void testFindAll() {
        when(bookRepository.findAll()).thenReturn(List.of(book));
        List<Book> result = bookService.findAll();
        assertThat(result).containsExactly(book);
    }

    @Test
    void testFindById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Optional<Book> result = bookService.findById(1L);
        assertThat(result).isPresent().contains(book);
    }

    @Test
    void testSave() {
        when(bookRepository.save(book)).thenReturn(book);
        Book result = bookService.save(book);
        assertThat(result).isEqualTo(book);
    }

    @Test
    void testDeleteById() {
        doNothing().when(bookRepository).deleteById(1L);
        bookService.deleteById(1L);
        verify(bookRepository, times(1)).deleteById(1L);
    }
}
