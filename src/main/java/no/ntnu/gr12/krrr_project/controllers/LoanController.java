package no.ntnu.gr12.krrr_project.controllers;

import no.ntnu.gr12.krrr_project.services.LoanService;
import no.ntnu.gr12.krrr_project.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class LoanController {
    @Autowired
    private LoanService loanService;

    /**
     * Returns the Loan list through the /orders mapping.
     * @return the loans as a list
     */
    @GetMapping("/loans")
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
    @GetMapping("/loans/{id}")
    public Loan getLoan(@PathVariable Long id) {
        Iterator<Loan> it = loanService.readLoans().iterator();

        while (it.hasNext()) {
            Loan loanFound = it.next();
            if (loanFound.getId() == (id)) {
                return loanFound;
            }
        }
        return null;
    }

    /**
     * Adds a loan to the loans list in loanService class through the /loans mapping
     * @param loan the order to be added
     */
    @PostMapping( "/loans/createLoan")
    public void createLoan(@RequestBody Loan loan) {
        loanService.createLoan(loan);
    }

    /**
     * Updates a specific loan with a new loan through the mapping.
     * @param loan the updated order
     */
    @PutMapping("/loans/updateLoan")
    public void updateLoan(@RequestBody Loan loan) {
        loanService.updateLoan(loan);
    }

    /**
     * Deletes a specific loan through the mapping
     */
    @DeleteMapping("/loans/deleteLoan")
    public void deleteLoan(@RequestBody Loan loan) {
        loanService.deleteLoan(loan);
    }
}
