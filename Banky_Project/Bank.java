

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    private static Map<String, BankAccount> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to BankY");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Account");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    viewAccount();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account with this number already exists.");
        } else {
            BankAccount newAccount = new BankAccount(accountNumber, accountHolderName);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created successfully!");
        }
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void transfer() {
        System.out.print("Enter your account number: ");
        String fromAccountNumber = scanner.nextLine();
        BankAccount fromAccount = accounts.get(fromAccountNumber);

        if (fromAccount != null) {
            System.out.print("Enter recipient account number: ");
            String toAccountNumber = scanner.nextLine();
            BankAccount toAccount = accounts.get(toAccountNumber);

            if (toAccount != null) {
                System.out.print("Enter transfer amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                fromAccount.transfer(toAccount, amount);
            } else {
                System.out.println("Recipient account not found.");
            }
        } else {
            System.out.println("Your account not found.");
        }
    }

    private static void viewAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = accounts.get(accountNumber);

        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found.");
        }
    }
}
