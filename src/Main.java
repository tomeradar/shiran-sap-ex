import classes.books.Book;
import classes.User;
import classes.books.DigitalBook;
import classes.books.RareBook;
import classes.books.RegularBook;
import enums.UserType;
import repositories.books.BookRepository;
import repositories.books.InMemoryBookRepository;
import repositories.loans.InMemoryLoanRepository;
import repositories.loans.LoanRepository;
import services.LoanService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new InMemoryBookRepository();
        LoanRepository loanRepository = new InMemoryLoanRepository();
        LoanService loanService = new LoanService(bookRepository, loanRepository);

        // יצירת משתמשים
        User user1 = new User(1L, "Alice", "alice@example.com", UserType.REGULAR);
        User user2 = new User(2L, "Tomer", "Tomer@example.com", UserType.LIBRARIAN);
        User user3 = new User(3L, "Shiran", "Shiran@example.com", UserType.VIP);

        // הוספת ספרים
        DigitalBook digitalBook = new DigitalBook(101L, "Effective Java");
        RareBook rareBook = new RareBook(102L, "Clean Code");
        RegularBook regularBook = new RegularBook(103L, "Clean Code");

        bookRepository.addBook(digitalBook);
        bookRepository.addBook(rareBook);
        bookRepository.addBook(regularBook);

        // השאלת ספר
        System.out.println("UserType.REGULAR Borrowing digitalBook: " + loanService.borrowBook(user1, digitalBook.getId())); // false
        System.out.println("UserType.REGULAR Borrowing rareBook: " + loanService.borrowBook(user1, rareBook.getId())); // false
        System.out.println("UserType.REGULAR Borrowing regularBook: " + loanService.borrowBook(user1, regularBook.getId())); // true
        // החזרת ספר
        System.out.println("UserType.REGULAR Returning book: " + loanService.returnBook(user1, regularBook.getId())); // true

        // השאלת ספר
        System.out.println("UserType.LIBRARIAN Borrowing digitalBook: " + loanService.borrowBook(user2, digitalBook.getId())); // true
        System.out.println("UserType.LIBRARIAN Borrowing rareBook: " + loanService.borrowBook(user2, rareBook.getId())); // true
        System.out.println("UserType.LIBRARIAN Borrowing regularBook: " + loanService.borrowBook(user2, regularBook.getId())); // true
        // החזרת ספר
        System.out.println("UserType.LIBRARIAN Returning book: " + loanService.returnBook(user2, digitalBook.getId())); // true
        System.out.println("UserType.LIBRARIAN Returning book: " + loanService.returnBook(user2, rareBook.getId())); // true
        System.out.println("UserType.LIBRARIAN Returning book: " + loanService.returnBook(user2, regularBook.getId())); // true

        bookRepository.setAllAvailability(false);
        // השאלת ספר
        System.out.println("UserType.VIP Borrowing digitalBook: " + loanService.borrowBook(user3, digitalBook.getId())); // false
        System.out.println("UserType.VIP Borrowing rareBook: " + loanService.borrowBook(user3, rareBook.getId())); // true
        System.out.println("UserType.VIP Borrowing regularBook: " + loanService.borrowBook(user3, regularBook.getId())); // true
        // ניסיון להשאיל שוב ספר שכבר הושאל
        System.out.println("Borrowing again: " + loanService.borrowBook(user3, rareBook.getId())); // false
        // החזרת ספר
        System.out.println("UserType.VIP Returning book: " + loanService.returnBook(user3, rareBook.getId())); // true
        System.out.println("UserType.VIP Returning book: " + loanService.returnBook(user3, regularBook.getId())); // true
    }
}