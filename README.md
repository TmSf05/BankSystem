# BankSystem
This Bank System code is like e-Bank 



Create a simple banking system.
1.The system should be able to
	a.enroll new account holders
	b.check how much balance an account holder have
	c.The bank owner should be able to see how much total money 	the bank have.


2.Implement BankAccount with(),withdraw(), and a transaction history list. Bonus: Throw InsufficientFundsException.


3.Introduce Different account types
Objective: Teach trainees about inheritance and polymorphism by creating different types of bank accounts with unique behaviors.

Description:
Extend the existing banking app to support multiple account types, such as SavingsAccount and CheckingAccount. Each account types should have its own rules for depositing, withdrawing, and calculating interest.

Requirments:
Create a base class BankAccount with common properties like accountNumber, accountHolderName, and balance.
Derive two subclasses: SavingsAccount and CheckingAccount.
SavingsAccount:Sgould include an interest rate (e.g., 5% annualy.) Add a method to calculate and apply interest.
CheckinAccount:Should allow overdrafts up to certain limit (e.g., 5000). if the withdrawal exceeds the balance but is within the overdraft limit. allow it but charge a fee(e.g.,30).
Modify the Bank class to handle both types of accounts
Add a method in the Bank class to display all accounts along with their balances and interest/overdraft details. 


4.Implement User Authentication and Roles
Objective: Teach trainees about encapsulation and abstraction by implementing user authentication and role-based access control.

Description:
Enhance the banking app to include user roles(Admin,Customer) with different levels of access to the system.

Requirements:
Create a User class with like username, password, and role.
Define two roles:
Admin:Can view all accounts, calculate total money in the bank, and perform administrative tasks.
Customer: Can only view and manage their own  account (deposit, withdraw, view transaction history).
Implement a login system where users must authenticate before accessing the system.
User encapsulation to ensure sensitive data(like passwords)is not exposed directly.
Abstract the behavior of different roles using interfaces or abstract classes.
