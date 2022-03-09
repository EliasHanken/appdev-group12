package no.ntnu.gr12.krrr_project.DBClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoanRepository extends JpaRepository<Loan, String> {

    /*
    @Query("select loan.bikeId from Loan l")
    public Loan findLoanedBike();

     */
}
