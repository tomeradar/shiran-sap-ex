import classes.Book;
import classes.User;
import repositories.books.BookRepository;
import repositories.books.InMemoryBookRepository;
import repositories.loans.InMemoryLoanRepository;
import repositories.loans.LoanRepository;
import services.LoanService;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new InMemoryBookRepository();
        LoanRepository loanRepository = new InMemoryLoanRepository();
        LoanService loanService = new LoanService(bookRepository, loanRepository);

        // יצירת משתמשים
        User user1 = new User(1L, "Alice", "alice@example.com");

        // הוספת ספרים
        Book book1 = new Book(101L, "Effective Java");
        Book book2 = new Book(102L, "Clean Code");

        bookRepository.save(book1);
        bookRepository.save(book2);

        // השאלת ספר
        System.out.println("Borrowing book: " + loanService.borrowBook(user1, 101L)); // true

        // ניסיון להשאיל שוב ספר שכבר הושאל
        System.out.println("Borrowing again: " + loanService.borrowBook(user1, 101L)); // false

        // החזרת ספר
        System.out.println("Returning book: " + loanService.returnBook(user1, 101L)); // true
    }
}