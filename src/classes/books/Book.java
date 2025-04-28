package classes.books;

import classes.User;

public class Book implements Loanable {
    private Long id;
    private String title;
    private boolean available = true;

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters and Setters
    public String getTitle() { return title; }

    @Override
    public Long getId() { return id; }
    @Override
    public boolean isAvailable() { return available; }
    @Override
    public void setAvailable(boolean available) { this.available = available; }
    @Override
    public boolean canBeBorrowedBy(User user) {
        return true;
    }
}
