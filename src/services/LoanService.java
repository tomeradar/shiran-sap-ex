package services;
import classes.books.Book;
import classes.LoanRecord;
import classes.User;
import classes.books.Loanable;
import repositories.books.BookRepository;
import repositories.loans.LoanRepository;

import java.time.LocalDate;
import java.util.List;

public class LoanService {
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;
    private static long loanIdSequence = 0;

    public LoanService(BookRepository bookRepository, LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    public boolean borrowBook(User user, Long bookId) {
        Loanable book = bookRepository.getBookById(bookId);
        if (book != null && bookRepository.isBookAvailable(bookId) && book.canBeBorrowedBy(user)) {
            bookRepository.setBookAvailability(bookId,false);

            LoanRecord loanRecord = new LoanRecord(++loanIdSequence, user, book, LocalDate.now());
            loanRepository.save(loanRecord);

            return true;
        }
        return false;
    }

    public boolean returnBook(User user, Long bookId) {
        List<LoanRecord> userLoans = loanRepository.findLoansByUser(user);
        for (LoanRecord loan : userLoans) {
            if (loan.getBook().getId().equals(bookId) && loan.isActive()) {
                loan.markAsReturned();
                loanRepository.save(loan);

                Loanable book = loan.getBook();
                bookRepository.setBookAvailability(bookId,true);
                return true;
            }
        }
        return false;
    }
}
