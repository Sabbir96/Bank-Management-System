import java.lang.*;

public interface IEmployeeRepo
{
	public void insertInDB(Employee e);
	public void deleteFromDB(String empId);
	public void updateInDB(Employee e);
	public Employee searchEmployee(String empId);
	public String[][] getAllEmployee();
}