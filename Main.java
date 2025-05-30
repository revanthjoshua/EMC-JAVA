import java.util.Scanner;

// Class representing a user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Amount deposited: ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance! Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("✅ Amount withdrawn: ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.printf("💰 Current Balance: ₹%.2f\n", balance);
    }
}

// Class representing the ATM interface
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. 💵 Deposit");
            System.out.println("2. 💸 Withdraw");
            System.out.println("3. 📊 Check Balance");
            System.out.println("4. 🚪 Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    userAccount.checkBalance();
                    break;

                case 4:
                    System.out.println("🚪 Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        } while (choice != 4); // ✅ Corrected do-while condition
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Starting with ₹1000
        ATM atm = new ATM(account);
        atm.start();
    }
}
