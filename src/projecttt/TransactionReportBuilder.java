/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttt;

import java.util.Date;

/**
 *
 * @author Memo
 */
public class TransactionReportBuilder {
    private String accountType;
    private Date startDate;
    private Date endDate;
    private double totalCredits;
    private double totalDebits;

    // طريقة تعيين نطاق التاريخ
    public TransactionReportBuilder setDateRange(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        return this;
    }

    // باقي الطرق الأخرى
    public TransactionReportBuilder setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public TransactionReportBuilder setTotalCredits(double totalCredits) {
        this.totalCredits = totalCredits;
        return this;
    }

    public TransactionReportBuilder setTotalDebits(double totalDebits) {
        this.totalDebits = totalDebits;
        return this;
    }

    // طريقة بناء التقرير النهائي
    public TransactionReport build() {
        return new TransactionReport(accountType, startDate, endDate, totalCredits, totalDebits);
    }
}

