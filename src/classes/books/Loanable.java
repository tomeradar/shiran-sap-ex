package classes.books;

import classes.User;

public interface Loanable {
    boolean canBeBorrowedBy(User user);
    Long getId();
    boolean isAvailable();
    void setAvailable(boolean available);
}