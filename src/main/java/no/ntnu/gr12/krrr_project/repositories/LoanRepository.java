package no.ntnu.gr12.krrr_project.repositories;

import no.ntnu.gr12.krrr_project.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, String> {

    /*
    @Query("select loan.bikeId from Loan l")
    public Loan findLoanedBike();

     */
}
