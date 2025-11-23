package io.github.rodrigocorreiainf.Controller;

import io.github.rodrigocorreiainf.entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void searchBooks() {
        String searchTerm = "algorithm";
        ResponseEntity<Book[]> response = restTemplate.getForEntity("/books/search?searchTerm={searchTerm}",
                Book[].class, searchTerm);

        Book[] books = response.getBody();
        assertNotNull(books);
        assertTrue(books.length > 0);

        for (Book book : books) {
            System.out.println(">>>> Book Title: " + book.getTitle());
        }
    }

}