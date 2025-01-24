import java.util.Scanner;

// Class representing a bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the account with an initial balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
            return true;
        }
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class that interacts with the bank account
class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a user's bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the menu and interact with the user
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Current Balance: " + account.checkBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }
}

// Main class to simulate the ATM system
public class Main {
    public static void main(String[] args) {
        // Initialize a bank account with a balance of 1000.00
        BankAccount userAccount = new BankAccount(1000.00);

        // Initialize ATM with the user's bank account
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.displayMenu();
    }
}
