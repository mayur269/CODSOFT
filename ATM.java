import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showATMInterface() {
        JFrame frame = new JFrame("ATM Interface");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create UI components
        JLabel label = new JLabel("Choose an option:");
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton balanceButton = new JButton("Check Balance");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        
        JPanel panel = new JPanel();
        panel.setLayout(null);

       
        label.setBounds(150, 20, 150, 30);
        withdrawButton.setBounds(50, 70, 120, 30);
        depositButton.setBounds(200, 70, 120, 30);
        balanceButton.setBounds(125, 120, 150, 30);
        resultArea.setBounds(50, 170, 300, 50);

        
        panel.add(label);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(balanceButton);
        panel.add(resultArea);

     
        frame.add(panel);
        frame.setVisible(true);

        // Action listeners 
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                double amount = Double.parseDouble(amountStr);
                if (account.withdraw(amount)) {
                    resultArea.setText("Withdrawal of ₹" + amount + " successful.\nNew Balance: ₹" + account.getBalance());
                } else {
                    resultArea.setText("Insufficient balance or invalid amount.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                double amount = Double.parseDouble(amountStr);
                account.deposit(amount);
                resultArea.setText("Deposit of ₹" + amount + " successful.\nNew Balance: ₹" + account.getBalance());
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("Current Balance: ₹" + account.getBalance());
            }
        });
    }
}
