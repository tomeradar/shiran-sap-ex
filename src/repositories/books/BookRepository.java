package repositories.books;

import classes.books.Loanable;

import java.util.List;

public interface BookRepository {

    // מוסיף ספר חדש
    void addBook(Loanable book);

    // מוחק ספר לפי מזהה
    void removeBook(Long bookId);

    // מחזיר ספר בודד לפי מזהה
    Loanable getBookById(Long bookId);

    // מחזיר רשימה של כל הספרים
    List<Loanable> getAllBooks();

    // מחזיר רשימה של כל הספרים הזמינים בלבד
    List<Loanable> getAvailableBooks();

    // מחזיר רשימה של כל הספרים הלא זמינים בלבד
    List<Loanable> getUnavailableBooks();

    // מעדכן את כל הספרים בפעולה אחת (setAll)
    void setAllAvailability(boolean available);

    // מעדכן את אחד הספרים
    void setBookAvailability(Long bookId, boolean available);

    // בודק האם ספר ספציפי זמין
    boolean isBookAvailable(Long bookId);
}