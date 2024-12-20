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
public class TransactionProxy implements TransactionService {
    private TransactionManager transactionManager;
    private boolean isAuthenticated;

    public TransactionProxy(boolean isAuthenticated) {
        this.transactionManager = TransactionManager.getInstance();
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public void processTransaction(String accountId, double amount) {
        if (isAuthenticated) {
            transactionManager.processTransaction(accountId, amount);
        } else {
            System.out.println("Access Denied: User not authenticated!");
        }
    }
}
