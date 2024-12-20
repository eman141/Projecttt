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
public class LoanFactory {
     public static Loan createLoan(String type) {
        switch (type) {
            case "Home":
                return new HomeLoan();
            case "Personal":
                return new PersonalLoan();
            case "Car":
                return new CarLoan();
            default:
                return null;
        }
    }
}
