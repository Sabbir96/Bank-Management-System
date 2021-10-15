import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AccountFrame extends JFrame implements ActionListener
{
	private JLabel accountNoLabel, accountNameLabel, accountTypeLabel, accountAmountLabel;
	private JTextField accountNoTextField, accountNameTextField, accountTypeTextField, accountAmountTextField;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable accountTable;
	private JScrollPane accountTableSP;
	
	private User user;
	private AccountRepo ar;
	private UserRepo ur;
	
	public AccountFrame(User user)
	{
		super("Bank Management System - Account Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		ar = new AccountRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		String data[][] = {{"", "", "", ""}};		
		String head[] = {"Account No", "Name", "Account Type", "Amount"};
		
		accountTable = new JTable(data,head);
		accountTableSP = new JScrollPane(accountTable);
		accountTableSP.setBounds(350, 100, 400, 150);
		accountTable.setEnabled(false);
		panel.add(accountTableSP);
		
		accountNoLabel = new JLabel("Account No :");
		accountNoLabel.setBounds(100,100,100,30);
		panel.add(accountNoLabel);
		
		accountNoTextField = new JTextField();
		accountNoTextField.setBounds(220,100,100,30);
		panel.add(accountNoTextField);
		
		accountNameLabel = new JLabel("Name :");
		accountNameLabel.setBounds(100,150,100,30);
		panel.add(accountNameLabel);
		
		accountNameTextField = new JTextField();
		accountNameTextField.setBounds(220,150,100,30);
		panel.add(accountNameTextField);
		
		accountTypeLabel = new JLabel("Account Type: ");
		accountTypeLabel.setBounds(100,200,100,30);
		panel.add(accountTypeLabel);
		
		accountTypeTextField = new JTextField();
		accountTypeTextField.setBounds(220,200,100,30);
		panel.add(accountTypeTextField);
		
		accountAmountLabel = new JLabel("Amount: ");
		accountAmountLabel.setBounds(100,250,100,30);
		panel.add(accountAmountLabel);
		
		accountAmountTextField = new JTextField();
		accountAmountTextField.setBounds(220,250,100,30);
		panel.add(accountAmountTextField);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!accountNoTextField.getText().equals("") || !accountNoTextField.getText().equals(null))
			{
				Account a = ar.searchCustomer(accountNoTextField.getText());
				if(a!= null)
				{
					accountNameTextField.setText(a.getName());
					accountTypeTextField.setText(a.getAccountType());
					accountAmountTextField.setText(a.getAmount()+"");
					
					accountNoTextField.setEnabled(false);
					accountNameTextField.setEnabled(true);
					accountTypeTextField.setEnabled(true);
					accountAmountTextField.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Account a = new Account();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			a.setAccountNumber(accountNoTextField.getText());
			a.setName(accountNameTextField.getText());
			a.setAccountType(accountTypeTextField.getText());
			a.setAmount(Double.parseDouble(accountAmountTextField.getText()));
			
			u.setUserId(accountNoTextField.getText());
			u.setPassword(x+"");
			
			u.setStatus(2);
			
			ar.insertInDB(a);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+accountNoTextField.getText()+"and Password: "+x);
			
			accountNoTextField.setText("");
			accountNameTextField.setText("");
			accountTypeTextField.setText("");
			accountAmountTextField.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			accountNoTextField.setText("");
			accountNameTextField.setText("");
			accountTypeTextField.setText("");
			accountAmountTextField.setText("");
			
			accountNoTextField.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Account a = new Account();
			
			a.setAccountNumber(accountNoTextField.getText());
			a.setName(accountNameTextField.getText());
			a.setAccountType(accountTypeTextField.getText());
			a.setAmount(Double.parseDouble(accountAmountTextField.getText()));
			
			ar.updateInDB(a);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			accountNoTextField.setText("");
			accountNameTextField.setText("");
			accountTypeTextField.setText("");
			accountAmountTextField.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			accountNoTextField.setEnabled(true);
			accountNameTextField.setEnabled(true);
			accountTypeTextField.setEnabled(true);
			accountAmountTextField.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			ar.deleteFromDB(accountNoTextField.getText());
			ur.deleteUser(accountNoTextField.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			accountNoTextField.setText("");
			accountNameTextField.setText("");
			accountTypeTextField.setText("");
			accountAmountTextField.setText("");
			
			accountNoTextField.setEnabled(true);
			accountNameTextField.setEnabled(true);
			accountTypeTextField.setEnabled(true);
			accountAmountTextField.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = ar.getAllCustomer();
			String head[] = {"Account No", "Name", "Account Type", "Amount"};
			
			panel.remove(accountTableSP);
			
			accountTable = new JTable(data,head);
			accountTable.setEnabled(false);
			accountTableSP = new JScrollPane(accountTable);
			accountTableSP.setBounds(350, 100, 400, 150);
			panel.add(accountTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}