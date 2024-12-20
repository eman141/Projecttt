/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttt;

/**
 *
 * @author Memo
 */
public interface Loan {
    String getLoanType();
}

class HomeLoan implements Loan {
    @Override
    public String getLoanType() {
        return "Home Loan";
    }
}

class PersonalLoan implements Loan {
    @Override
    public String getLoanType() {
        return "Personal Loan";
    }
}

class CarLoan implements Loan {
    @Override
    public String getLoanType() {
        return "Car Loan";
    }
}
