import java.lang.*;

public class Account
{
	private String accountNumber;
	private String name;
	private String accountType;
	private double amount;
	
	public Account(){}
	public Account(String accountNumber, String name, String accountType, double amount)
	{
		this.accountNumber = accountNumber;
		this.name = name;
		this.accountType = accountType;
		this.amount = amount;
	}
	
	public void setAccountNumber(String accountNumber){this.accountNumber = accountNumber;}
	public void setName(String name){this.name = name;}
	public void setAccountType(String accountType){this.accountType = accountType;}
	public void setAmount(double amount){this.amount = amount;}
	
	public String getAccountNumber(){return accountNumber;}
	public String getName(){return name;}
	public String getAccountType(){return accountType;}
	public double getAmount(){return amount;}
}