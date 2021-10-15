import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class TransactionFrame extends JFrame implements ActionListener
{
	private JLabel accountNoLabel, accountNameLabel, accountTypeLabel, accountAmountLabel, wthDpoLabel;
	private JTextField accountNoTextField, accountNameTextField, accountTypeTextField, accountAmountTextField, wthDpoTextField;
	private JButton loadBtn, DepositeBtn, withdrawBtn, deleteBtn, refreshBtn, backBtn;
	private JPanel panel;
	
	private User user;
	private CustomerRepo cr;
	private UserRepo ur;
	
	public TransactionFrame(User user)
	{
		super("Bank Management System - Transaction Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		cr = new CustomerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		accountNoLabel = new JLabel("Account No :");
		accountNoLabel.setBounds(50,50,100,30);
		panel.add(accountNoLabel);
		
		accountNoTextField = new JTextField();
		accountNoTextField.setBounds(170,50,100,30);
		panel.add(accountNoTextField);
		
		accountNameLabel = new JLabel("Name :");
		accountNameLabel.setBounds(50,100,100,30);
		panel.add(accountNameLabel);
		
		accountNameTextField = new JTextField();
		accountNameTextField.setBounds(170,100,100,30);
		accountNameTextField.setEditable(false);
		panel.add(accountNameTextField);
		
		accountTypeLabel = new JLabel("Account Type: ");
		accountTypeLabel.setBounds(50,150,100,30);
		panel.add(accountTypeLabel);
		
		accountTypeTextField = new JTextField();
		accountTypeTextField.setBounds(170,150,100,30);
		accountTypeTextField.setEditable(false);
		panel.add(accountTypeTextField);
		
		accountAmountLabel = new JLabel("Amount: ");
		accountAmountLabel.setBounds(50,200,100,30);
		panel.add(accountAmountLabel);
		
		accountAmountTextField = new JTextField();
		accountAmountTextField.setBounds(170,200,100,30);
		accountAmountTextField.setEditable(false);
		panel.add(accountAmountTextField);
		
		wthDpoLabel = new JLabel("Withdraw/Deposite:");
		wthDpoLabel.setBounds(50,250,120,30);
		panel.add(wthDpoLabel);
		
		wthDpoTextField = new JTextField();
		wthDpoTextField.setBounds(170,250,100,30);
		wthDpoTextField.setEditable(false);
		panel.add(wthDpoTextField);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(290,50,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		
		DepositeBtn = new JButton("Deposite");
		DepositeBtn.setBounds(50,300,100,30);
		DepositeBtn.addActionListener(this);
		DepositeBtn.setEnabled(false);
		panel.add(DepositeBtn);
		
		withdrawBtn = new JButton("Withdraw");
		withdrawBtn.setBounds(170,300,100,30);
		withdrawBtn.setEnabled(false);
		withdrawBtn.addActionListener(this);
		panel.add(withdrawBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(290,300,100,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(410, 300, 100, 30);
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
				Customer c = cr.searchCustomer(accountNoTextField.getText());
				if(c!= null)
				{
					accountNameTextField.setText(c.getName());
					accountTypeTextField.setText(c.getAccountType());
					accountAmountTextField.setText(c.getAmount()+"");
					
					accountNoTextField.setEnabled(false);
					wthDpoTextField.setEditable(true);
					
					DepositeBtn.setEnabled(true);
					withdrawBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		
		else if(command.equals(refreshBtn.getText()))
		{
			accountNoTextField.setText("");
			accountNameTextField.setText("");
			accountTypeTextField.setText("");
			accountAmountTextField.setText("");
			wthDpoTextField.setText("");
			wthDpoTextField.setEditable(false);
			
			accountNoTextField.setEnabled(true);
			loadBtn.setEnabled(true);
			DepositeBtn.setEnabled(false);
			withdrawBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(DepositeBtn.getText()))
		{
			Customer c = new Customer();
			
			c.setAccountNumber(accountNoTextField.getText());
			c.setName(accountNameTextField.getText());
			c.setAccountType(accountTypeTextField.getText());
			
			double currentAmount = Double.parseDouble(accountAmountTextField.getText());
			double depositeAmount = Double.parseDouble(wthDpoTextField.getText());
			
			c.setAmount(currentAmount+depositeAmount);
			
			cr.updateInDB(c);
			
			JOptionPane.showMessageDialog(this, "Deposite Successful");
			
			accountNoTextField.setText("");
			accountNameTextField.setText("");
			accountTypeTextField.setText("");
			accountAmountTextField.setText("");
			wthDpoTextField.setText("");
			
			wthDpoTextField.setEditable(false);
			loadBtn.setEnabled(true);
			DepositeBtn.setEnabled(false);
			withdrawBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			accountNoTextField.setEnabled(true);
			accountNameTextField.setEnabled(true);
			accountTypeTextField.setEnabled(true);
			accountAmountTextField.setEnabled(true);
		}
		
		else if(command.equals(withdrawBtn.getText())){
			Customer c = new Customer();
			
			c.setAccountNumber(accountNoTextField.getText());
			c.setName(accountNameTextField.getText());
			c.setAccountType(accountTypeTextField.getText());
			
			double currentAmount = Double.parseDouble(accountAmountTextField.getText());
			double withdrawAmount = Double.parseDouble(wthDpoTextField.getText());
			
			if(withdrawAmount > currentAmount){
				JOptionPane.showMessageDialog(this, "Sorry! can't withdraw more than " + currentAmount);
			}
			else{
				c.setAmount(currentAmount-withdrawAmount);
				cr.updateInDB(c);
				JOptionPane.showMessageDialog(this, "Withdraw Successful");
			}
			
			accountNoTextField.setText("");
			accountNameTextField.setText("");
			accountTypeTextField.setText("");
			accountAmountTextField.setText("");
			wthDpoTextField.setText("");
			
			wthDpoTextField.setEditable(false);
			loadBtn.setEnabled(true);
			DepositeBtn.setEnabled(false);
			withdrawBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			accountNoTextField.setEnabled(true);
			accountNameTextField.setEnabled(true);
			accountTypeTextField.setEnabled(true);
			accountAmountTextField.setEnabled(true);
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