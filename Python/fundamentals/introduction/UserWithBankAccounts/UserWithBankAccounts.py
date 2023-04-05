class User: 
    def __init__(self,name="unassigned",starting_balance=0,interest_rate=0.04):
        self.name = name
        self.account = BankAccount(starting_balance,interest_rate)
    def make_withdrawl(self,amount):
        self.account.withdraw(amount)
        return self
    def make_deposit(self,amount):
        self.account.deposit(amount)
        return self 
    def display_user_balance(self):
        print(self.name)
        self.account.display_account_info()
        return self 
    def yield_interest(self):
        self.account.yield_interest()
        return self
class BankAccount: 
    bank_name = "first national dojo"
    all_accounts = []

    def __init__(self, balance=0, interest=.4):
        self.balance=balance 
        self.interest_rate=interest
        BankAccount.all_accounts.append(self)
    
    def deposit(self,amount):
        print("Depositing $" + str(amount))
        self.balance += amount
        return self 
    
    def withdraw(self,amount):
        if self.balance < amount:
            print("Insufficient Funds")
        else:
            print("Withdrawing $"+ amount)
            self.balance -= amount
        return self 
    
    def display_account_info(self):
        print("Account Balance: $" + str(self.balance))
        print("Interest Rate:," + self.interest_rate)
        return self 
    
    def yield_interest(self):
        print("Yielding Interest")
        self.balance += self.balance * self.interest_rate
        return self 

    @classmethod
    def all_balances(cls):
        sum = 0
        for account in cls.all_accounts:
            sum += account.balance
        return sum

    @classmethod
    def print_all(cls):
        for account in cls.all_accounts:
            account.display_account_info()
        return cls