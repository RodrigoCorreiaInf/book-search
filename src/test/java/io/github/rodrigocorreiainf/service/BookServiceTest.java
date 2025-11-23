package io.github.rodrigocorreiainf.service;

import io.github.rodrigocorreiainf.entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void searchBooks_empty() {
        String searchTerm = "";
        assertThrows(IllegalArgumentException.class, () ->
                bookService.searchBooks(searchTerm));
    }

    @Test
    void searchBooks_null() {
        String searchTerm = null;
        assertThrows(IllegalArgumentException.class, () ->
                bookService.searchBooks(searchTerm));
    }

    @Test
    void searchBooks_valid() {
        String searchTerm = "algorithm";
        List<Book> bookList = bookService.searchBooks(searchTerm);
        assertFalse(bookList.isEmpty());
    }

}