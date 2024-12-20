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
public class CustomerProfileBuilder {
     private CustomerProfile profile;

    public CustomerProfileBuilder() {
        this.profile = new CustomerProfile();
    }


    public CustomerProfileBuilder setName(String name) {
        profile.setName(name);
        return this;
    }

    public CustomerProfileBuilder setAddress(String address) {
        profile.setAddress(address);
        return this;
    }

    public CustomerProfileBuilder setContact(String contact) {
        profile.setContact(contact);
        return this;
    }

    public CustomerProfileBuilder setAccount(Account account) {
        profile.setAccount(account);
        return this;
    }

    public CustomerProfileBuilder setLoan(Loan loan) {
        profile.setLoan(loan);
        return this;
    }

    public CustomerProfile build() {
        return profile;
    }

    Object setAccount(LoginGUI.Account selectedAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
