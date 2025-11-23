package io.github.rodrigocorreiainf.service;

import io.github.rodrigocorreiainf.entity.Book;
import io.github.rodrigocorreiainf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            throw new IllegalArgumentException("Search term cannot be null.");
        }
        return bookRepository.searchBooks(searchTerm);
    }

}
