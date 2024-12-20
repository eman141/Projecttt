/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttt;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Memo
 */
class TransactionReport {
    private String accountType;
    private Date startDate;
    private Date endDate;
    private double totalCredits;
    private double totalDebits;

    public TransactionReport(String accountType, Date startDate, Date endDate, double totalCredits, double totalDebits) {
        this.accountType = accountType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCredits = totalCredits;
        this.totalDebits = totalDebits;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Account Type: " + accountType +
               "\nStart Date: " + dateFormat.format(startDate) +
               "\nEnd Date: " + dateFormat.format(endDate) +
               "\nTotal Credits: " + totalCredits +
               "\nTotal Debits: " + totalDebits;
    }
}
