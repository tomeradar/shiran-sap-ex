package classes.books;

import classes.User;

public interface Loanable {
    boolean canBeBorrowedBy(User user);
    Long getId();
    boolean isAvailable(int currentGlobalVersion, boolean globalAvailability);

    void setAvailable(boolean available, int currentGlobalVersion);
}