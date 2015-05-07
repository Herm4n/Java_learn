import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class JSliderTest extends JFrame implements ChangeListener
{
	private JLabel lblCel, lblFah;
	private JSlider sldCel, sldFah;
	private int tempCel, tempFah;
	
	public JSliderTest()
	{
		setSize(700,300);
		setTitle("Test JSlider'a");
		setLayout(null);
		
		sldCel = new JSlider(0, 100, 0);
		sldCel.setBounds(20, 50, 500, 50);
		sldCel.setMajorTickSpacing(10);
		sldCel.setMinorTickSpacing(5);
		sldCel.setPaintTicks(true);
		sldCel.setPaintLabels(true);
		sldCel.addChangeListener(this);
		add(sldCel);
		
		sldFah = new JSlider(30, 212, 30);
		sldFah.setBounds(20, 150, 500, 50);
		sldFah.setMajorTickSpacing(20);
		sldFah.setMinorTickSpacing(16);
		sldFah.setPaintTicks(true);
		sldFah.setPaintLabels(true);
		sldFah.addChangeListener(this);
		sldFah.setEnabled(false);
		add(sldFah);
		
		lblCel = new JLabel("Celsius: 0");
		lblCel.setBounds(550, 50, 250, 25);
		add(lblCel);
		
		lblFah = new JLabel("Fahrenheit: 0");
		lblFah.setBounds(550, 150, 250, 25);
		add(lblFah);
		
		// *************************************************************************************
		// **************************** Zmiana stylu graficznego okna **************************
		// *************************************************************************************
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		SwingUtilities.updateComponentTreeUI(this);
		// ***************************************
	}
	public static void main(String[] args)
	{
		JSliderTest app = new JSliderTest();
		app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		app.setVisible(true);

	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		Object z = e.getSource();
		if (z == sldCel)
		{
			tempCel = sldCel.getValue();
			lblCel.setText("Celsius: " + tempCel);
			tempFah = (int)Math.round(32 + (9.0/5.0)*tempCel);
			sldFah.setValue(tempFah);
			lblFah.setText("Fahrenheit: " + tempFah);
		}
		else if (z == sldFah)
		{
			tempFah = sldFah.getValue();
			lblFah.setText("Fahrenheit: " + tempFah);
			tempCel = (int)Math.round((tempFah - 32.0) * (5.0 / 9.0));
			sldCel.setValue(tempCel);
			lblCel.setText("Celsius: " + tempCel);
		}
	}

}
