package repositories.books;

import classes.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    @Override
    public void save(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public Book findById(Long id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}