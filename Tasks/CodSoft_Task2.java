//CODESOFT -Task 2 
//ATM INTERFACE

import java.util.Scanner;
public class BankAccount
{
    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance=initialBalance;
    }
    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)   // function for depositing amount money
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Deposit of Rs. " + amount + " Successful.\nCurrent Balance : Rs. " + balance);
        } else
        {
            System.out.println("\nInvalid deposit amount.");
        }
    }

    public void withdraw(double amount) // function for withdrawing money
    {
        if(amount > 0 && amount <= balance) // Checking the availability of money
        {
            balance -= amount;
            System.out.println("Withdrawal of Rs. " + amount + " Successful.\nCurrent balance: Rs. "+balance);
        }
        else
        {
            System.out.println("\nInvalid withdrawal amount or insufficient balance.");
        }
    }
}


class ATM
{
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount)
    {
        this.bankAccount=bankAccount;
    }

    public void displayMenu() // function for Menu
    {
        // Menu for User
        System.out.println("|--------------------|");
        System.out.println("|    ATM MENU        |");
        System.out.println("|--------------------|");
        System.out.println("|  1. Check Balance  |");
        System.out.println("|  2. Deposit        |");
        System.out.println("|  3. Withdraw       |");
        System.out.println("|  4. Exit           |");
        System.out.println("|--------------------|");

    }

    public void performTransaction(int choice , Scanner scanner)
    {
        switch(choice)
        {
            case 1:
                System.out.println("Current balance : Rs. "+bankAccount.getBalance());
                break;

            case 2:
                System.out.println("Enter deposit amount: Rs. ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;

            case 3:
                System.out.println("Enter withdrawal amount : Rs. ");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;

            case 4:
                System.out.println("Exiting ATM . Thank you!");
                scanner.close();
                System.exit(0);

            default:
                System.out.println("Invalid choice !! Please select a valid option .");
        }
    }
}
class ATM_Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial account balance:"); // Taking Initial Account Balance from User
        double initialBalance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Select an option :");
            int choice = scanner.nextInt();
            atm.performTransaction(choice, scanner);

        }
    }

}


