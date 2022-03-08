package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class LoanController {
    @Autowired
    private LoanService loanService;

    /**
     * Returns the Loan list through the /orders mapping.
     * @return the loans as a list
     */
    @RequestMapping("/loans")
    public List<Loan> getLoans() {
        return StreamSupport
                .stream(loanService.readLoans()
                        .spliterator(),false)
                .collect(Collectors.toList());
    }

    /**
     * Returns a specific loan through the /orders mapping
     * @param id the id of the loan to be requested
     * @return the specific loan
     */
    @RequestMapping("/loans/{id}")
    public Loan getLoan(@PathVariable String id) {
        Iterator<Loan> it = loanService.readLoans().iterator();

        while (it.hasNext()) {
            Loan loanFound = it.next();
            if (loanFound.getId().equals(id)) {
                return loanFound;
            }
        }
        return null;
    }

    /**
     * Adds a loan to the loans list in loanService class through the /loans mapping
     * @param loan the order to be added
     */
    @RequestMapping(method = RequestMethod.POST, value = "/loans")
    public void createLoan(@RequestBody Loan loan) {
        loanService.createLoan(loan);
    }

    /**
     * Updates a specific loan with a new loan through the mapping.
     * @param loan the updated order
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/loans/{id}")
    public void updateLoan(@RequestBody Loan loan) {
        loanService.updateLoan(loan);
    }

    /**
     * Deletes a specific loan through the mapping
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/loans/{id}")
    public void deleteLoan(@PathVariable Loan loan) {
        loanService.deleteLoan(loan);
    }
}
