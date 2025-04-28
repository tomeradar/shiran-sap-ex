package classes.books;

import classes.User;
import enums.UserType;

public class RareBook extends Book {
    public RareBook(Long id, String title) {
        super(id,title);
    }
    @Override
    public boolean canBeBorrowedBy(User user) {
        return user.getUserType() == UserType.VIP ||
                user.getUserType() == UserType.LIBRARIAN;
    }
}
