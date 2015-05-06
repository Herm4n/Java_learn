import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class PasswordFieldTest extends JFrame implements ActionListener
{
	JPasswordField psfHaslo;
	
	public PasswordFieldTest()
	{
		setTitle("Test hasla");
		setSize(400 , 400);
		setLayout(null);
		
		psfHaslo = new JPasswordField();
		psfHaslo.setBounds(50, 50, 150, 25);
		psfHaslo.setEchoChar('x');
		psfHaslo.addActionListener(this);
		
		add(psfHaslo);
	}
	
	
	
	public static void main(String[] args)
	{
		PasswordFieldTest app = new PasswordFieldTest();
		app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		app.setVisible(true);

	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(this, Arrays.toString(psfHaslo.getPassword()));
		JOptionPane.showMessageDialog(this, String.valueOf(psfHaslo.getPassword()));
		JOptionPane.showMessageDialog(this, new String(psfHaslo.getPassword()));
	}

}
