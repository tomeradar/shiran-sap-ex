package repositories.loans;

import classes.LoanRecord;
import classes.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryLoanRepository implements LoanRepository {
    private final Map<Long, LoanRecord> loans = new HashMap<>();

    @Override
    public void save(LoanRecord loanRecord) {
        loans.put(loanRecord.getId(), loanRecord);
    }

    @Override
    public List<LoanRecord> findLoansByUser(User user) {
        List<LoanRecord> results = new ArrayList<>();
        for (LoanRecord loan : loans.values()) {
            if (loan.getUser().getId().equals(user.getId())) {
                results.add(loan);
            }
        }
        return results;
    }

    @Override
    public List<LoanRecord> findActiveLoans() {
        List<LoanRecord> results = new ArrayList<>();
        for (LoanRecord loan : loans.values()) {
            if (loan.isActive()) {
                results.add(loan);
            }
        }
        return results;
    }
}