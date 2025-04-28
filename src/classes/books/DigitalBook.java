package classes.books;

import classes.User;
import enums.UserType;

public class DigitalBook extends Book {
    public DigitalBook(Long id, String title) {
        super(id,title);
    }
    @Override
    public boolean canBeBorrowedBy(User user) {
        return user.getUserType() == UserType.LIBRARIAN;
    }
}
