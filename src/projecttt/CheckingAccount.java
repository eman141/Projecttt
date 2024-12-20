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
public class CheckingAccount extends Account {

    public CheckingAccount() {
        super("Checking");
    }

    @Override
    public String getAccountType() {
        return accountType;
    }
}
