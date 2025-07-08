import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}


class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println(" Welcome to the ATM!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1.  Deposit");
            System.out.println("2.  Withdraw");
            System.out.println("3.  Check Balance");
            System.out.println("4.  Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdraw();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit must be greater than zero.");
        } else {
            account.deposit(amount);
            System.out.println("Deposit successful. Current balance: ₹" + account.getBalance());
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal must be greater than zero.");
        } else if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Current balance: ₹" + account.getBalance());
        } else {
            System.out.println("Insufficient balance. Transaction failed.");
        }
    }

    private void handleCheckBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }
}


class ATMApp {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
