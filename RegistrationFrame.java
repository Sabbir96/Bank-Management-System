import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationFrame extends JFrame implements ActionListener
{
	private JButton submitBtn, backBtn;
	
	private JPanel panel;
	private LoginFrame lf;
	
	public RegistrationFrame(LoginFrame lf)
	{
		super("Register Now !!!");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.lf = lf;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(300, 200, 80, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(390, 200, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			//write codes for Customer Insertion Here
		}
		else if(command.equals(backBtn.getText()))
		{
			this.setVisible(false);
			lf.setVisible(true);
		}
		else{}
	}
}