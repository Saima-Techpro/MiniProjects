package BankAccountSystem;

public class Runner_Account {
    public static void main(String[] args) {

        // Create a SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 500, 0.05);
        savingsAccount.deposit(100);
        savingsAccount.calculateInterest();
        savingsAccount.showBalance();


        // Create a CheckingAccount
        CurrentAccounts checkingAccounts = new CurrentAccounts("CA456", 1000, 500);
        checkingAccounts.deposit(200);
        checkingAccounts.withdraw(300);
        checkingAccounts.showBalance();
        checkingAccounts.withdraw(700); // exceed limit
        checkingAccounts.showBalance();
        checkingAccounts.withdraw(1000); // insufficient funds
    }
}