package main;

class TestBankAccountMain {
    public static void main(String[] args) {
		BankAccountMain Anthony = new BankAccountMain();
        Anthony.depositMoney(100.49, "checking");
        Anthony.depositMoney(3.00, "savings");
    

		System.out.println(BankAccountMain.totalAmount);
		Anthony.withdrawMoney(50, "checking");
		Anthony.withdrawMoney(50, "savings");


		System.out.println(BankAccountMain.totalAmount);

        BankAccountMain Agnes = new BankAccountMain();
        
        Agnes.depositMoney(3, "checking");
        Agnes.depositMoney(99, "savings");
        Agnes.withdrawMoney(50, "checking");
	}
}