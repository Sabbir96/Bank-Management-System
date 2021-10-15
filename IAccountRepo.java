import java.lang.*;

public interface IAccountRepo
{
	public void insertInDB(Account a);
	public void updateInDB(Account a);
	public void deleteFromDB(String accountNumber);
	public Account searchCustomer(String accountNumber);
	public String[][] getAllCustomer();
}