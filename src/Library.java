import java.util.List;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) { books.add(book); }
    public void removeBook(Book book) { books.remove(book); }

    public void borrowBook(User user, Book book) {
        if (books.contains(book) && book.isAvailable()) {
            book.setAvailable(false);
            user.getBorrowedBooks().add(book);
        }
    }

    public void returnBook(User user, Book book) {
        if (user.getBorrowedBooks().contains(book)) {
            book.setAvailable(true);
            user.getBorrowedBooks().remove(book);
        }
    }
}