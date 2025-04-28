package repositories.books;

import classes.Book;

import java.util.*;

public interface BookRepository {
    void save(Book book);
    Book findById(Long id);
    List<Book> findAll();
}
