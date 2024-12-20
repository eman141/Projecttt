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
public class TransactionManager {
     private static TransactionManager instance;

    // Singleton: ضمان وجود نسخة واحدة فقط من TransactionManager
    private TransactionManager() {}

    public static TransactionManager getInstance() {
        if (instance == null) {
            instance = new TransactionManager();
        }
        return instance;
    }

    public void processTransaction(String accountId, double amount) {
        // منطق معالجة المعاملات هنا
        System.out.println("Processing transaction of $" + amount + " for account: " + accountId);
    }
}
