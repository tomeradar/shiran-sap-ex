import classes.User;
import classes.books.DigitalBook;
import classes.books.RareBook;
import classes.books.RegularBook;
import enums.UserType;
import repositories.books.InMemoryBookRepository;
import repositories.loans.InMemoryLoanRepository;
import services.LoanService;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InMemoryBookRepository bookRepository = new InMemoryBookRepository();
        InMemoryLoanRepository loanRepository = new InMemoryLoanRepository();
        LoanService loanService = new LoanService(bookRepository, loanRepository);
        // יצירת משתמשים
        User user1 = new User(1L, "Alice", "alice@example.com", UserType.REGULAR);
        User user2 = new User(2L, "Tomer", "Tomer@example.com", UserType.LIBRARIAN);
        User user3 = new User(3L, "Shiran", "Shiran@example.com", UserType.VIP);

        initializeBooks(bookRepository);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            executorService.submit(() -> {
                int randomId = random.nextInt(30);
                boolean success = loanService.borrowBook(user2, (long) randomId);
                if (success) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " successfully borrowed book ID " + randomId);
                } else {
                    System.out.println("Thread " + Thread.currentThread().getName() + " failed to borrow book ID " + randomId);
                }
            });
        }

        executorService.shutdown();
    }

    private static void initializeBooks(InMemoryBookRepository repository) {
        for (int i = 0; i < 10; i++) {
            repository.addBook(new RegularBook((long) i, "Book " + i));
        }
        for (int i = 10; i < 20; i++) {
            repository.addBook(new DigitalBook((long) i, "Book " + i));
        }
        for (int i = 20; i < 30; i++) {
            repository.addBook(new RareBook((long) i, "Book " + i));
        }
    }
}