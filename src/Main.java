import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library(new ArrayList<Book>());

        // יצירת משתמשים
        User user1 = new User(1L, "Alice", "alice@example.com",new ArrayList<>());

        // הוספת ספרים
        Book book1 = new Book(101L, "Effective Java", "Tomer",true);
        Book book2 = new Book(102L, "Clean Code", "Shiran", false);

        library.addBook(book1);
        library.addBook(book2);

        library.borrowBook(user1, book1);
        library.borrowBook(user1, book2);
        library.returnBook(user1, book1);
    }
}