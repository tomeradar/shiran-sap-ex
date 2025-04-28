package repositories.books;

import classes.books.Book;
import classes.books.Loanable;

import java.util.*;

public interface BookRepository {
    void save(Loanable book);
    Loanable findById(Long id);
    List<Loanable> findAll();
}
