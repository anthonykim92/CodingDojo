package main;

class BankAccountMain {
	private double checkingBalance;
	private double savingsBalance; 
	public static int numberOfAccounts = 0; 
	public static double totalAmount = 0;
	
	public BankAccountMain() {
		BankAccountMain.numberOfAccounts += 1; 
		this.checkingBalance = 0;
		this.savingsBalance = 0;
	}
	public void depositMoney(double amount, String account) {
		if (account == "checking") {
			this.checkingBalance += amount;
		}
		else {this.savingsBalance += amount;
		}
		
			BankAccountMain.totalAmount += amount; 
	}
	public double getCheckingBalance () {
		return this.checkingBalance;
	}
	public double getSavingsBalance () {
		return this.savingsBalance;
	}
	public void withdrawMoney(double amount, String account) {
		if (account == "checking") {
			if (amount > this.checkingBalance) {
				System.out.println("Not enough money in Bank.");
				return;
			}
			this.checkingBalance -= amount;
		}
		else if (amount > this.savingsBalance) {
			System.out.println("Not enough money in Bank.");
			return;
			}
		{this.savingsBalance -= amount;
		}
		
			BankAccountMain.totalAmount -= amount; 
	}
	
	
	
	
	
	
	
	
	
}
