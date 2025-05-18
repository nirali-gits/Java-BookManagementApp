package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.repository.PublisherRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PublisherServiceTest {

    @Mock
    private PublisherRepository publisherRepository;

    @InjectMocks
    private PublisherService publisherService;

    private Publisher publisher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("HarperCollins");
        publisher.setAddress("London");
    }

    @Test
    void testFindAll() {
        when(publisherRepository.findAll()).thenReturn(List.of(publisher));
        List<Publisher> result = publisherService.findAll();
        assertThat(result).containsExactly(publisher);
    }

    @Test
    void testFindById() {
        when(publisherRepository.findById(1L)).thenReturn(Optional.of(publisher));
        Optional<Publisher> result = publisherService.findById(1L);
        assertThat(result).isPresent().contains(publisher);
    }

    @Test
    void testSave() {
        when(publisherRepository.save(publisher)).thenReturn(publisher);
        Publisher result = publisherService.save(publisher);
        assertThat(result).isEqualTo(publisher);
    }

    @Test
    void testDeleteById() {
        doNothing().when(publisherRepository).deleteById(1L);
        publisherService.deleteById(1L);
        verify(publisherRepository, times(1)).deleteById(1L);
    }
}
