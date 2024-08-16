

public class BankAccount {
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	
	
	public BankAccount(String accountNumber, String accountHolderName) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = 0.0;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Deposited: " + amount);
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdraw: " + amount);
		} else {
			System.out.println("Invalid withdrawal amount or insufficient funds.");
		}
	}
	
	public void transfer(BankAccount recipient, double amount) {
		if(amount > 0 && amount <= balance) {
			this.withdraw(amount);
			recipient.deposit(amount);
			System.out.println("Transferred: " + amount + " to " + recipient.getAccountHolderName());
		} else {
			System.out.println("Invalid transfer amount or insufficient funds.");
		}
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", balance="
				+ balance + "]";
	}
	
	
}
