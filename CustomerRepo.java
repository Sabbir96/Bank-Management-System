import java.lang.*;
import java.util.ArrayList;

public class CustomerRepo implements ICustomerRepo 
{
	DatabaseConnection dbc;
	
	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	
	 public void updateInDB(Customer c)
	 {
		 String query = "UPDATE customers_information SET name='"+c.getName()+"', accountType = '"+c.getAccountType()+"', amount = "+c.getAmount()+" WHERE accountNumber='"+c.getAccountNumber()+"'";
		
		 try
		 {
			 dbc.openConnection();
			 dbc.st.executeUpdate(query);
			 dbc.closeConnection();
		 }
		 catch(Exception ex){System.out.println(ex.getMessage());}
	 }
	public Customer searchCustomer(String accountNumber)
	{
		Customer acn = null;
		String query = "SELECT `name`, `accountType`, `amount` FROM `customers_information` WHERE `accountNumber`='"+accountNumber+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("name");
				String accountType = dbc.result.getString("accountType");
				double amount = dbc.result.getDouble("amount");
				
				acn = new Customer();
				acn.setAccountNumber(accountNumber);
				acn.setName(name);
				acn.setAccountType(accountType);
				acn.setAmount(amount);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return acn;
	}
}












































