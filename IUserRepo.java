import java.lang.*;

public interface IUserRepo
{
	User getUser(String userId, String password);
	void insertUser(User u);
	void updateUser(User u);
	void updateUserPassword(User u);
	void deleteUser(String userId);
}