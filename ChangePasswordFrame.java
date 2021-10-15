import javax.swing.*;
import java.awt.event.*;

public class ChangePasswordFrame extends JFrame implements ActionListener, MouseListener{
	
	JPanel panel;
	JLabel oldPassLabel, newPassLabel, idLabel;
	JTextField idTF;
	JPasswordField oldPassPF, newPassPF;
	JButton changeButton, backButton, showButtonOP, showButtonNP;
	EmployeeHome eh;
	private User user;
	private UserRepo ur;
	
	public ChangePasswordFrame(EmployeeHome eh, User user){
		super("Bank Management System - Change Password");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.eh = eh;
		this.user = user;
		
		ur = new UserRepo();

		panel = new JPanel();
		panel.setLayout(null);
		

		idLabel = new JLabel("Enter ID : ");
		idLabel.setBounds(280,50,100,30);
		panel.add(idLabel);

		idTF = new JTextField();
		idTF.setBounds(400,50,100,30);
		panel.add(idTF);

		oldPassLabel = new JLabel("Old Password : ");
		oldPassLabel.setBounds(280,100,100,30);
		panel.add(oldPassLabel);
		
		oldPassPF = new JPasswordField();
		oldPassPF.setBounds(400,100,100,30);
		oldPassPF.setEchoChar('*');
		panel.add(oldPassPF);

		showButtonOP = new JButton("Show");
		showButtonOP.setBounds(510,100,70,30);
		showButtonOP.addMouseListener(this);
		panel.add(showButtonOP);
		
		newPassLabel = new JLabel("New Password : ");
		newPassLabel.setBounds(280,150,100,30);
		panel.add(newPassLabel);
		
		newPassPF = new JPasswordField();
		newPassPF.setBounds(400,150,100,30);
		newPassPF.setEchoChar('*');
		panel.add(newPassPF);

		showButtonNP = new JButton("Show");
		showButtonNP.setBounds(510,150,70,30);
		showButtonNP.addMouseListener(this);
		panel.add(showButtonNP);
		
		changeButton = new JButton("Change");
		changeButton.setBounds(280,250,100,30);
		changeButton.addActionListener(this);
		panel.add(changeButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(400,250,100,30);
		backButton.addActionListener(this);
		panel.add(backButton);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(command.equals(backButton.getText()))
		{
			this.setVisible(false);
			eh.setVisible(true);
		}
		else if(command.equals(changeButton.getText())){
			
			user.setUserId(idTF.getText());
			user.setPassword(newPassPF.getText());

			ur.updateUserPassword(user);
			
			idTF.setText("");
			oldPassPF.setText("");
			newPassPF.setText("");

			JOptionPane.showMessageDialog(this,"Password changed");
		}
	}

	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mousePressed(MouseEvent me){
		if(me.getSource() == showButtonOP){
			oldPassPF.setEchoChar((char)0);
		}
		else if(me.getSource() == showButtonNP){
			newPassPF.setEchoChar((char)0);
		}
		
	}
	public void mouseReleased(MouseEvent me){
		if(me.getSource() == showButtonOP){
			oldPassPF.setEchoChar('*');
		}
		else if(me.getSource() == showButtonNP){
			newPassPF.setEchoChar('*');
		}
	}
}








