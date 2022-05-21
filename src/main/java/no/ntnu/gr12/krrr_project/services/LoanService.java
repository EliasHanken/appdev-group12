package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.Loan;
import no.ntnu.gr12.krrr_project.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Transactional
    public String createLoan(Loan loan){
        try{
            if(!loanRepository.existsById(Long.toString(loan.getId()))){

                loanRepository.save(loan);
                return "Loan inserted!";
            }else{
                return "Loan already exists in the DB";
            }
        }catch (Exception e){
            throw e;
        }

    }

    public List<Loan> readLoans(){
        return loanRepository.findAll();
    }

    @Transactional
    public String updateLoan(Loan loan){
        if(loanRepository.existsById(Long.toString(loan.getId()))){
            try{
                Loan loanToBeUpdate = loanRepository.findById(Long.toString(loan.getId())).get();
                loanToBeUpdate.setBikeId(loan.getBikeId());
                loanToBeUpdate.setBorrow_date(loan.getBorrow_date());
                loanToBeUpdate.setDue_date(loan.getDue_date());
                loanToBeUpdate.setId(loan.getId());
                loanToBeUpdate.setUserId(loan.getUserId());
                loanRepository.save(loanToBeUpdate);
                return "Loan info updated!";
            }catch(Exception e){
                throw e;
            }
        }else{
            return "Loan does not exist in DB";
        }
    }

    @Transactional
    public String deleteLoan(Loan loan){
        if(loanRepository.existsById(Long.toString(loan.getId()))){
            try{
                loanRepository.delete(loan);
                return "Loan is deleted successfully!";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Loan does not exist in DB";
        }
    }
}
