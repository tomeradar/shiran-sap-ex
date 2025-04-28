package classes;

import classes.books.Book;
import classes.books.Loanable;

import java.time.LocalDate;

public class LoanRecord {
    private Long id;
    private User user;
    private Loanable book;
    private LocalDate borrowDate;
    private LocalDate returnDate; // null אם עדיין לא הוחזר

    public LoanRecord(Long id, User user, Loanable book, LocalDate borrowDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public void markAsReturned() {
        this.returnDate = LocalDate.now();
    }

    public boolean isActive() {
        return returnDate == null;
    }

    // Getters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public Loanable getBook() { return book; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}