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
public class ExternalPaymentGateway {
    
    public void processPayment(String accountId, double amount) {
        // منطق معالجة الدفع عبر بوابة الدفع
        System.out.println("Processing payment of $" + amount + " for account: " + accountId);
    }
}
