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
public class CustomerProfile {
     private String name;
    private String address;
    private String contact;
    private Account account;
    private Loan loan;

    @Override
    public String toString() {
        String accountType = (account != null) ? account.getAccountType() : "No Account";
        String loanType = (loan != null) ? loan.getLoanType() : "No Loan";

        return "Name: " + name + "\nAddress: " + address + "\nContact: " + contact
                + "\nAccount: " + accountType + "\nLoan: " + loanType;
    }

    // setters
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setContact(String contact) { this.contact = contact; }
    public void setAccount(Account account) { this.account = account; }
    public void setLoan(Loan loan) { this.loan = loan; }
}
