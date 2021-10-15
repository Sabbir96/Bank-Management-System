import java.lang.*;

public interface ICustomerRepo
{
	public void updateInDB(Customer c);
	public Customer searchCustomer(String accountNumber);
}







