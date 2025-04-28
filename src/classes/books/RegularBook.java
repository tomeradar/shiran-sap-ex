package classes.books;

import classes.User;
import enums.UserType;

public class RegularBook extends Book {
    public RegularBook(Long id, String title) {
        super(id,title);
    }
    @Override
    public boolean canBeBorrowedBy(User user) {
        return user.getUserType() == UserType.REGULAR ||
                user.getUserType() == UserType.VIP ||
                user.getUserType() == UserType.LIBRARIAN;
    }
}
