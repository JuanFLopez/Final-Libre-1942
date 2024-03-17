package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SplashScreen splash = new SplashScreen(2000);
		splash.showSplash();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Menu frame = new Menu();

					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
					e.getMessage();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {

		setIconImage(new ImageIcon(getClass().getResource("/GraficasSpritesExtra/icon.png")).getImage());

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton botonJugar = new JButton("");
		botonJugar.setBorder(new LineBorder(Color.BLACK));
		botonJugar.setBackground(new Color(0, 255, 0));
		botonJugar.setIcon(new ImageIcon(Menu.class.getResource("/GraficasSpritesExtra/play.gif")));
		
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Gui frame = new Gui(0);
				frame.setVisible(true);
				
				dispose();
			}
		});
		botonJugar.setBounds(45, 301, 233, 76);
		contentPane.add(botonJugar);

	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/GraficasSpritesExtra/FONDO MENU.png")));
		lblNewLabel.setBounds(12, 0, 932, 647);
		contentPane.add(lblNewLabel);

	}

}
