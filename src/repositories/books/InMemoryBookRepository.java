package repositories.books;

import classes.books.Book;
import classes.books.Loanable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {
    private final Map<Long, Loanable> books = new HashMap<>();

    @Override
    public void save(Loanable book) {
        books.put(book.getId(), book);
    }

    @Override
    public Loanable findById(Long id) {
        return books.get(id);
    }

    @Override
    public List<Loanable> findAll() {
        return new ArrayList<>(books.values());
    }
}