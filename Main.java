import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Bank {
    private Map<String, Double> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addUser(String username, double initialBalance) {
        if (!accounts.containsKey(username)) {
            accounts.put(username, initialBalance);
            System.out.println("User " + username + " added with initial balance: " + initialBalance);
        } else {
            System.out.println("User " + username + " already exists.");
        }
    }

    public void deposit(String username, double amount) {
        if (accounts.containsKey(username)) {
            double currentBalance = accounts.get(username);
            currentBalance += amount;
            accounts.put(username, currentBalance);
            System.out.println("Deposited " + amount + " to user " + username);
        } else {
            System.out.println("User " + username + " not found.");
        }
    }

    public void withdraw(String username, double amount) {
        if (accounts.containsKey(username)) {
            double currentBalance = accounts.get(username);
            if (currentBalance >= amount) {
                currentBalance -= amount;
                accounts.put(username, currentBalance);
                System.out.println("Withdrawn " + amount + " from user " + username);
            } else {
                System.out.println("Insufficient balance for user " + username);
            }
        } else {
            System.out.println("User " + username + " not found.");
        }
    }

    public void showBalance(String username) {
        if (accounts.containsKey(username)) {
            double balance = accounts.get(username);
            System.out.println("Balance for user " + username + ": " + balance);
        } else {
            System.out.println("User " + username + " not found.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add User\n2. Deposit\n3. Withdraw\n4. Show Balance\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.addUser(username, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String depositUser = scanner.next();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositUser, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter username: ");
                    String withdrawUser = scanner.next();
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(withdrawUser, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter username: ");
                    String balanceUser = scanner.next();
                    bank.showBalance(balanceUser);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}