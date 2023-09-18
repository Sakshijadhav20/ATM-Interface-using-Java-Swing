import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMApp extends JFrame {
    private JPanel welcomePanel, mainPanel;
    private JButton loginButton, signupButton, depositButton, transferButton, historyButton, quitButton;
    private CardLayout cardLayout;

    public ATMApp() {
        setTitle("ATM Interface");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        welcomePanel = createWelcomePanel();
        add(welcomePanel, "Welcome");

        mainPanel = createMainPanel();
        add(mainPanel, "Main");

        cardLayout.show(this.getContentPane(), "Welcome");
    }

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Unity First Bank");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        loginButton = new JButton("Login");
        signupButton = new JButton("Signup");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulated user credentials (replace with actual validation)
                String username = "user123";
                String password = "password123";
        
                // Simulated input from user (replace with actual input)
                String enteredUsername = JOptionPane.showInputDialog("Enter username:");
                String enteredPassword = JOptionPane.showInputDialog("Enter password:");
        
                if (enteredUsername != null && enteredPassword != null &&
                    enteredUsername.equals(username) && enteredPassword.equals(password)) {
                    // Successful login, switch to the main menu
                    cardLayout.show(getContentPane(), "Main");
                } else {
                    // Failed login, show an error message
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulated input from user (replace with actual input fields)
                String newUsername = JOptionPane.showInputDialog("Enter a new username:");
                String newPassword = JOptionPane.showInputDialog("Enter a new password:");
        
                if (newUsername != null && newPassword != null && !newUsername.isEmpty() && !newPassword.isEmpty()) {
                    // Successful signup (simulated)
                    JOptionPane.showMessageDialog(null, "Signup successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
                    // Here, you can save the new user's information to a database or other storage mechanism.
        
                    // After signup, switch to the main menu
                    cardLayout.show(getContentPane(), "Main");
                } else {
                    // Invalid input or user canceled the signup
                    JOptionPane.showMessageDialog(null, "Invalid input or signup canceled", "Signup Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        panel.add(welcomeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        depositButton = new JButton("Deposit");
        transferButton = new JButton("Transfer");
        historyButton = new JButton("Transaction History");
        quitButton = new JButton("Quit");

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulated account balance (replace with actual account balance)
                double accountBalance = 1000.0;
        
                // Simulated input from user (replace with actual input fields)
                String depositAmountStr = JOptionPane.showInputDialog("Enter the deposit amount:");
                
                try {
                    double depositAmount = Double.parseDouble(depositAmountStr);
        
                    if (depositAmount > 0) {
                        // Update the account balance
                        accountBalance += depositAmount;
        
                        // Simulated: Show the updated balance (replace with your UI)
                        JOptionPane.showMessageDialog(null, "Deposit successful!\nNew balance: $" + accountBalance, "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        // Invalid deposit amount
                        JOptionPane.showMessageDialog(null, "Invalid deposit amount", "Deposit Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    // Invalid input (not a valid number)
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Deposit Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulated account balances (replace with actual account balances)
                double senderBalance = 1000.0;
                double recipientBalance = 1500.0;
        
                JOptionPane.showInputDialog("Enter recipient's account:");
                String transferAmountStr = JOptionPane.showInputDialog("Enter the transfer amount:");
                
                try {
                    double transferAmount = Double.parseDouble(transferAmountStr);
        
                    if (transferAmount > 0 && senderBalance >= transferAmount) {
                        // Update the sender's balance
                        senderBalance -= transferAmount;
                        
                        // Update the recipient's balance
                        recipientBalance += transferAmount;
        
                        // Simulated: Show the updated balances (replace with your UI)
                        JOptionPane.showMessageDialog(null, "Transfer successful!\nYour balance: $" + senderBalance +
                                "\nRecipient's balance: $" + recipientBalance, "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else if (transferAmount <= 0) {
                        // Invalid transfer amount
                        JOptionPane.showMessageDialog(null, "Invalid transfer amount", "Transfer Failed", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Insufficient funds
                        JOptionPane.showMessageDialog(null, "Insufficient funds", "Transfer Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    // Invalid input (not a valid number)
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Transfer Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulated transaction history (replace with actual database query)
                String[] transactions = {
                    "2023-09-01: Deposit $500",
                    "2023-09-05: Transfer to UserXYZ $200",
                    "2023-09-10: Withdraw $100",
                    // Add more transaction records here
                };
        
                // Create a dialog to display the transaction history
                JTextArea historyTextArea = new JTextArea(10, 30);
                historyTextArea.setEditable(false);
        
                // Populate the transaction history text area
                for (String transaction : transactions) {
                    historyTextArea.append(transaction + "\n");
                }
        
                JScrollPane scrollPane = new JScrollPane(historyTextArea);
        
                // Create a dialog to display the transaction history
                JOptionPane.showMessageDialog(null, scrollPane, "Transaction History", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(depositButton);
        panel.add(transferButton);
        panel.add(historyButton);
        panel.add(quitButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMApp().setVisible(true);
            }
        });
    }
}
