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
public class LegacyAccountSystem {
     public void addLegacyAccount(String accountDetails) {
        System.out.println("Account added to legacy system: " + accountDetails);
    }
      // New Account Interface
interface Account {
    String getAccountDetails();
}

class SavingsAccount implements Account {
    private String accountDetails;

    public SavingsAccount(String details) {
        this.accountDetails = details;
    }

    @Override
    public String getAccountDetails() {
        return "Savings Account: " + accountDetails;
    }
}
}
