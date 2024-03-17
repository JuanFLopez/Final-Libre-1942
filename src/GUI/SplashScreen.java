package GUI;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {
	private int duration;

	public SplashScreen(int d) {
		
		duration = d;
		setBounds(100, 100, 932, 647);

		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true); // Lo mantenemos siempre al frente al ejecutar

		Image img = Toolkit.getDefaultToolkit()
				.getImage(SplashScreen.class.getResource("/GraficasSpritesExtra/SplashScreen.png"));
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("");
		ImageIcon ii = new ImageIcon();
		ii.setImage(img);
		lblNewLabel.setIcon(ii);
		add(lblNewLabel);
		repaint();

	}

	// A simple little method to show a title screen in the center
	// of the screen for the amount of time given in the constructor
	public void showSplash() {
		this.setVisible(true);
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispose();
	}

}
