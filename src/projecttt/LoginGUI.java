package projecttt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

class LoginGUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public void show() {
        frame = new JFrame("Login - Banking System");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // إعدادات الحقول
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        panel.add(new JLabel());  // حجز مكان فارغ في اللوحة
        panel.add(loginButton);

        frame.add(panel, BorderLayout.CENTER);

        // إعدادات زر الدخول
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                AuthenticationProxy authProxy = new AuthenticationProxy();

                // التحقق من البيانات المدخلة عبر Proxy
                boolean isAuthenticated = authProxy.authenticate(username, password);

                if (isAuthenticated) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    frame.dispose();
                    showMainMenu();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials. Please try again.");
                }
            }
        });

        frame.setVisible(true);
    }

    // تعديل واجهة المستخدم الرئيسية بعد تسجيل الدخول
    private void showMainMenu() {
        // إنشاء واجهة المستخدم الرئيسية بعد تسجيل الدخول
        JFrame mainMenuFrame = new JFrame("Main Menu - Banking System");
        mainMenuFrame.setSize(400, 300);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setLayout(new FlowLayout());

        JButton createAccountButton = new JButton("Create Account");
        JButton createLoanButton = new JButton("Create Loan");
        JButton createCustomerProfileButton = new JButton("Create Customer Profile");
        JButton createTransactionReportButton = new JButton("Create Transaction Report");
        JButton makePaymentButton = new JButton("Make Payment");

        mainMenuFrame.add(createAccountButton);
        mainMenuFrame.add(createLoanButton);
        mainMenuFrame.add(createCustomerProfileButton);
        mainMenuFrame.add(createTransactionReportButton);
        mainMenuFrame.add(makePaymentButton);  // إضافة زر الدفع

        createAccountButton.addActionListener(e -> createAccount());
        createLoanButton.addActionListener(e -> createLoan());
        createCustomerProfileButton.addActionListener(e -> createCustomerProfile());
        createTransactionReportButton.addActionListener(e -> createTransactionReport());

        // إضافة حدث زر الدفع
        makePaymentButton.addActionListener(e -> makePayment());

        mainMenuFrame.setVisible(true);
    }

    // منطق الدفع باستخدام Adapter
    private void makePayment() {
        String amountStr = JOptionPane.showInputDialog(frame, "Enter payment amount:");

        if (amountStr != null) {
            try {
                double amount = Double.parseDouble(amountStr);

                if (amount <= 0) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid amount greater than zero.");
                    return;
                }

                ExternalPaymentGateway externalGateway = new ExternalPaymentGateway();
                PaymentGatewayAdapter paymentService = new PaymentGatewayAdapter(externalGateway);

                String customerId = "user123"; // استخدم المعرف الفعلي للعميل

                paymentService.processTransaction(customerId, amount);
                JOptionPane.showMessageDialog(frame, "Payment of $" + amount + " has been processed successfully for customer: " + customerId);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid amount entered. Please enter a valid number.");
            }
        }
    }

    private void createAccount() {
        // تنفيذ منطق إنشاء الحساب
        String[] accountTypes = {"Savings", "Checking", "Loan"};
        String selectedType = (String) JOptionPane.showInputDialog(frame, "Select Account Type:", "Account Factory",
                JOptionPane.QUESTION_MESSAGE, null, accountTypes, accountTypes[0]);
        if (selectedType == null) {
            JOptionPane.showMessageDialog(frame, "Please select an account type.");
            return;
        }
        projecttt.Account account = AccountFactory.createAccount(selectedType);
        JOptionPane.showMessageDialog(frame, "Created: " + account.getAccountType());
    }

    private void createLoan() {
        // تنفيذ منطق إنشاء القرض
        String[] loanTypes = {"Home", "Personal", "Car"};
        String selectedType = (String) JOptionPane.showInputDialog(frame, "Select Loan Type:", "Loan Factory",
                JOptionPane.QUESTION_MESSAGE, null, loanTypes, loanTypes[0]);
        if (selectedType == null) {
            JOptionPane.showMessageDialog(frame, "Please select a loan type.");
            return;
        }
        Loan loan = LoanFactory.createLoan(selectedType);
        JOptionPane.showMessageDialog(frame, "Created: " + loan.getLoanType());
    }

    private void createCustomerProfile() {
        // تنفيذ منطق إنشاء ملف العميل
        JTextField nameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField contactField = new JTextField(20);

        // إنشاء قائمة لاختيار الحسابات والقروض
        String[] accountTypes = {"Savings", "Checking", "Loan"};
        JComboBox<String> accountComboBox = new JComboBox<>(accountTypes);
        String[] loanTypes = {"Home", "Personal", "Car"};
        JComboBox<String> loanComboBox = new JComboBox<>(loanTypes);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Contact:"));
        panel.add(contactField);
        panel.add(new JLabel("Account:"));
        panel.add(accountComboBox);
        panel.add(new JLabel("Loan:"));
        panel.add(loanComboBox);

        int option = JOptionPane.showConfirmDialog(frame, panel, "Create Customer Profile", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String address = addressField.getText();
            String contact = contactField.getText();

            // تحقق من الحقول الفارغة
            if (name.isEmpty() || address.isEmpty() || contact.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill out all fields.");
                return;
            }

            // تحقق من اختيار حساب وقرض
            if (accountComboBox.getSelectedItem() == null || loanComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(frame, "Please select an account type and a loan type.");
                return;
            }

            projecttt.Account selectedAccount = AccountFactory.createAccount((String) accountComboBox.getSelectedItem());
            Loan selectedLoan = LoanFactory.createLoan((String) loanComboBox.getSelectedItem());

            CustomerProfile profile = new CustomerProfileBuilder()
                .setName(name)
                .setAddress(address)
                .setContact(contact)
                .setAccount(selectedAccount)
                .setLoan(selectedLoan)
                .build();

            JOptionPane.showMessageDialog(frame, "Customer Profile Created:\n" + profile);
        }
    }

    private void createTransactionReport() {
        JTextField accountTypeField = new JTextField(20);
        JTextField startDateField = new JTextField(20);
        JTextField endDateField = new JTextField(20);
        JTextField totalCreditsField = new JTextField(20);
        JTextField totalDebitsField = new JTextField(20);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Account Type:"));
        panel.add(accountTypeField);
        panel.add(new JLabel("Start Date:"));
        panel.add(startDateField);
        panel.add(new JLabel("End Date:"));
        panel.add(endDateField);
        panel.add(new JLabel("Total Credits:"));
        panel.add(totalCreditsField);
        panel.add(new JLabel("Total Debits:"));
        panel.add(totalDebitsField);

        int option = JOptionPane.showConfirmDialog(frame, panel, "Create Transaction Report", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String accountType = accountTypeField.getText();

            // استخدام SimpleDateFormat لتحويل النصوص المدخلة إلى تواريخ
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = null;
            Date endDate = null;
            
            try {
                startDate = dateFormat.parse(startDateField.getText());  // تحويل نص إلى تاريخ
                endDate = dateFormat.parse(endDateField.getText());      // تحويل نص إلى تاريخ
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Invalid date format. Please use yyyy-MM-dd.");
                return;  // إذا كانت صيغة التاريخ غير صحيحة
            }

            double totalCredits = Double.parseDouble(totalCreditsField.getText());
            double totalDebits = Double.parseDouble(totalDebitsField.getText());

            TransactionReport report = new TransactionReportBuilder()
                .setAccountType(accountType)
                .setDateRange(startDate, endDate)
                .setTotalCredits(totalCredits)
                .setTotalDebits(totalDebits)
                .build();

            JOptionPane.showMessageDialog(frame, "Transaction Report Created:\n" + report);
        }
    }

    static class Account {
        public Account() {
        }
    }
}
