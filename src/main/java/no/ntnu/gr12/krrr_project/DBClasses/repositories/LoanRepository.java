package no.ntnu.gr12.krrr_project.DBClasses.repositories;

import no.ntnu.gr12.krrr_project.DBClasses.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, String> {

    /*
    @Query("select loan.bikeId from Loan l")
    public Loan findLoanedBike();

     */
}
