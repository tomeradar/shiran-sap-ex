package repositories.loans;

import classes.LoanRecord;
import classes.User;

import java.util.*;

public interface LoanRepository {
    void save(LoanRecord loanRecord);
    List<LoanRecord> findLoansByUser(User user);
    List<LoanRecord> findActiveLoans();
}
