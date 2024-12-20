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
public class PaymentGatewayAdapter {
     private ExternalPaymentGateway externalGateway;

    public PaymentGatewayAdapter(ExternalPaymentGateway externalGateway) {
        this.externalGateway = externalGateway;
    }

    public void processTransaction(String accountId, double amount) {
        // تعديل العملية لتتناسب مع النظام الحالي
        externalGateway.processPayment(accountId, amount);
    }
}
