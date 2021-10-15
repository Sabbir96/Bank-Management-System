import java.lang.*;
import java.util.ArrayList;

public class AccountRepo implements IAccountRepo 
{
	DatabaseConnection dbc;
	
	public AccountRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Account a)
	{
		String query = "INSERT INTO customers_information  VALUES ('"+a.getAccountNumber()+"','"+a.getName()+"','"+a.getAccountType()+"',"+a.getAmount()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String accountNumber)
	{
		String query = "DELETE from customers_information WHERE accountNumber='"+accountNumber+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	 public void updateInDB(Account a)
	 {
		 String query = "UPDATE customers_information SET name='"+a.getName()+"', accountType = '"+a.getAccountType()+"', amount = "+a.getAmount()+" WHERE accountNumber='"+a.getAccountNumber()+"'";
		
		 try
		 {
			 dbc.openConnection();
			 dbc.st.executeUpdate(query);
			 dbc.closeConnection();
		 }
		 catch(Exception ex){System.out.println(ex.getMessage());}
	 }
	public Account searchCustomer(String accountNumber)
	{
		Account acn = null;
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
				
				acn = new Account();
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
	public String[][] getAllCustomer()
	{
		ArrayList<Account> ar = new ArrayList<Account>();
		String query = "SELECT * FROM customers_information;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String accountNumber = dbc.result.getString("accountNumber");
				String name = dbc.result.getString("name");
				String accountType = dbc.result.getString("accountType");
				double amount = dbc.result.getDouble("amount");
				
				 Account a = new Account(accountNumber,name,accountType,amount);
				ar.add(a);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Account)obj[i]).getAccountNumber();
			data[i][1] = ((Account)obj[i]).getName();
			data[i][2] = ((Account)obj[i]).getAccountType();
			data[i][3] = (((Account)obj[i]).getAmount())+"";
		}
		return data;
	}
}












































