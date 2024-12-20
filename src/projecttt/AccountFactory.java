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
public class AccountFactory {

    // Factory method that creates an Account based on the account type
    public static Account createAccount(String accountType) {
        switch (accountType) {
            case "Savings":
                return new SavingsAccount();
            case "Checking":
                return new CheckingAccount();
            case "Loan":
                return new LoanAccount();
            default:
                throw new IllegalArgumentException("Invalid account type: " + accountType);
        }
    }
}

