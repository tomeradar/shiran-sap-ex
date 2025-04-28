package classes.books;

import classes.User;

public class Book implements Loanable {
    private Long id;
    private String title;
    private boolean available = true;
    private int version;
    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters and Setters
    public String getTitle() { return title; }

    @Override
    public Long getId() { return id; }
    @Override
    public boolean isAvailable(int globalVersion,boolean globalAvailability) {
        if (version < globalVersion) {
            return globalAvailability;
        }
        return available;
    }
    @Override
    public void setAvailable(boolean available, int currentGlobalVersion) {
        this.available = available;
        this.version = currentGlobalVersion;
    }
    @Override
    public boolean canBeBorrowedBy(User user) {
        return true;
    }
}
