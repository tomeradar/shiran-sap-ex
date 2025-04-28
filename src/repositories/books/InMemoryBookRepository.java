package repositories.books;

import classes.books.Book;
import classes.books.Loanable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {

    private final Map<Long, Loanable> booksById = new HashMap<>();
    private boolean globalAvailability = true; // מצב זמינות גלובלי
    private int globalVersion = 0; // גרסה גלובלית

    @Override
    public void addBook(Loanable book) {
        booksById.put(book.getId(), book);
    }

    @Override
    public void removeBook(Long bookId) {
        booksById.remove(bookId);
    }

    @Override
    public Loanable getBookById(Long bookId) {
        return booksById.get(bookId);
    }

    @Override
    public List<Loanable> getAllBooks() {
        return new ArrayList<>(booksById.values());
    }

    @Override
    public List<Loanable> getAvailableBooks() {
        List<Loanable> availableBooks = new ArrayList<>();
        for (Loanable book : booksById.values()) {
            if (book.isAvailable(globalVersion, globalAvailability)) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    @Override
    public List<Loanable> getUnavailableBooks() {
        List<Loanable> unavailableBooks = new ArrayList<>();
        for (Loanable book : booksById.values()) {
            if (!book.isAvailable(globalVersion, globalAvailability)) {
                unavailableBooks.add(book);
            }
        }
        return unavailableBooks;
    }

    @Override
    public void setAllAvailability(boolean available) {
        globalAvailability = available;
        globalVersion++; // רק מגדילים את הגרסה!
    }

    @Override
    public void setBookAvailability(Long bookId, boolean available) {
        Loanable book = booksById.get(bookId);
        if (book != null) {
            book.setAvailable(available, globalVersion);
        }
    }

    @Override
    public boolean isBookAvailable(Long bookId) {
        Loanable book = booksById.get(bookId);
        if (book == null) {
            return false;
        }
        return book.isAvailable(globalVersion, globalAvailability);
    }
}