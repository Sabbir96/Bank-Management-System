import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class EmployeeHome extends JFrame implements ActionListener
{
	JButton logoutBtn, manageEmpBtn, accountBtn, changePasswordBtn, transactionButton;
	JPanel panel;
	
	User user;
	
	public EmployeeHome(User user)
	{
		super("Bank Management System - Welcome Employee");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(600, 100, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		manageEmpBtn = new JButton("Manage Employee");
		manageEmpBtn.setBounds(50, 100, 150, 30);
		manageEmpBtn.addActionListener(this);
		panel.add(manageEmpBtn);
		
		accountBtn = new JButton("Account");
		accountBtn.setBounds(225, 100, 150, 30);
		accountBtn.addActionListener(this);
		panel.add(accountBtn);
		
		transactionButton = new JButton("Transaction");
		transactionButton.setBounds(400, 100, 150, 30);
		transactionButton.addActionListener(this);
		panel.add(transactionButton);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(manageEmpBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				EmployeeFrame ef = new EmployeeFrame(user);
				ef.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(accountBtn.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1)
			{
				AccountFrame af = new AccountFrame(user);
				af.setVisible(true);
				this.setVisible(false);
			}
		}
		else if(command.equals(transactionButton.getText()))
		{
			if(user.getStatus()==0 || user.getStatus()==1 || user.getStatus()==2)
			{
				TransactionFrame tf = new TransactionFrame(user);
				tf.setVisible(true);
				this.setVisible(false);
			}
		}
		
		else if(command.equals(changePasswordBtn.getText()))
		{
			ChangePasswordFrame cpf = new ChangePasswordFrame(this, this.user);
			this.setVisible(false);
			cpf.setVisible(true);
		}
		
		else{}
	}
}

