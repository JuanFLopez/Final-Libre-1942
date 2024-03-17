package GUI;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Logica.Juego;

import javax.swing.JLabel;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Gui extends JFrame {

	private FondoPanel panelJuego;
	private Juego juego;
	private Thread hiloJuego;
	private JLabel vida, vidaMaxima, nivelTanda;
	private JLabel[] vidas;
	private JLabel[] estados;
	private JLabel fondoJuego;
	private JLabel score;
	private JLabel hiScore;
	private JLabel hiScoreLogico;
	private JLabel scoreLogico;
	
	
	public Gui(int dificultad) {
		
		this.setResizable(false);
		
		setIconImage(new ImageIcon(getClass().getResource("/GraficasSpritesExtra/icon.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 700);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		panelJuego = new FondoPanel();
		panelJuego.setBounds(0, 60, 933, 601);
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setLayout(null);
		contentPane.add(panelJuego);
		
		fondoJuego = new JLabel("New label");
		fondoJuego.setIcon(new ImageIcon(Gui.class.getResource("/GraficasSpritesNiveles/FONDO-LVL01.png")));
		fondoJuego.setBounds(0, 0, 933,601);
		reDimensionar(fondoJuego, (ImageIcon) fondoJuego.getIcon());
		panelJuego.add(fondoJuego);
		panelJuego.moveToBack(fondoJuego);
		
		panelJuego.repaint();
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBounds(0, 0, 933, 60);
		contentPane.add(barraSuperior);
		barraSuperior.setLayout(null);
		barraSuperior.setBackground(Color.BLACK);
		
		JPanel panelVidas = new JPanel();
		panelVidas.setBounds(870,0,43,60); //Agregar bounds reales
		panelVidas.setBackground(Color.BLACK);
		panelVidas.setVisible(true);
		vidas = new JLabel[2];
		for (int i = 0; i < 2; i++) {
			vidas[i] = new JLabel();
			vidas[i].setSize(43, 15); 
			panelVidas.add(vidas[i]);
			

		}
		
		vidas[0].setIcon(new ImageIcon(getClass().getResource("/GraficasSpritesExtra/vidas.png")));
		
		for (int i = 0; i < 2; i++) {
			vidas[i].setIcon(new ImageIcon(getClass().getResource("/GraficasSpritesExtra/vidas.png")));
			
		}

		barraSuperior.add(panelVidas);
		
		
		
		
		JPanel panelMejoras = new JPanel();

		panelMejoras.setBounds(415, 0, 258, 60);
		panelMejoras.setBackground(Color.BLACK);
		panelMejoras.setLayout(new GridLayout(1, 4));
		panelMejoras.setVisible(true);
		estados = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			estados[i] = new JLabel();
			estados[i].setSize(50, 50); 
			panelMejoras.add(estados[i]);
			estados[i].setEnabled(false);

		}
		
		estados[0].setIcon(new ImageIcon(getClass().getResource("/GraficasSpritesPowerups/inmunidad.png")));
		estados[1].setIcon(new ImageIcon(getClass().getResource("/GraficasSpritesPowerups/superArma.png")));
		estados[2].setIcon(new ImageIcon(getClass().getResource("/GraficasSpritesPowerups/velocidad.png")));
		for (int i = 0; i < 3; i++) {
			reDimensionar(estados[i], (ImageIcon) estados[i].getIcon());
		}

		barraSuperior.add(panelMejoras);
		
		hiScore = new JLabel();
		hiScore.setSize(90, 23);
		hiScore.setIcon(new ImageIcon(getClass().getResource("/GraficasSpritesExtra/HiScore.gif")));
		hiScore.setBounds(670, 0, 90, 23);
		barraSuperior.add(hiScore);
		
		score = new JLabel();
		score.setSize(90, 23);
		score.setIcon(new ImageIcon(getClass().getResource("/GraficasSpritesExtra/scoreActual.gif")));
		score.setBounds(770, 0, 90, 23);
		barraSuperior.add(score);
		
		
		
		vida = new JLabel();
		vida.setBackground(new Color(51, 91, 17));
		vida.setBounds(10, 11, 0, 38);
		vida.setOpaque(true);
		vida.setBorder(new LineBorder(Color.BLACK, 2));
		barraSuperior.add(vida);

		vidaMaxima = new JLabel();
		vidaMaxima.setBackground(new Color(242, 78, 133));
		vidaMaxima.setBounds(10, 11, 300, 38);
		vidaMaxima.setOpaque(true);
		vidaMaxima.setBorder(new LineBorder(Color.BLACK, 2));
		barraSuperior.add(vidaMaxima);

		nivelTanda = new JLabel("");
		nivelTanda.setIcon(new ImageIcon(getClass().getResource("/GraficasSpritesExtrasNivelTanda/nivel1tanda1.png")));

		nivelTanda.setBounds(310, 0, 95, 60);
		barraSuperior.add(nivelTanda);

		this.setFocusable(true);

		setContentPane(contentPane);
		setLocationRelativeTo(null);

		juego = Juego.getJuego();
		juego.setGUI(this);
		

		this.addKeyListener(new OyenteTeclado(juego));

		hiloJuego = new Thread() {
			public void run() {
				juego.run();
				
			}
		};

		
		hiloJuego.start();
		scoreLogico = new JLabel(juego.puntaje());
		scoreLogico.setSize(90,23);
		scoreLogico.setBounds(770,30,90,23);
		Font font = scoreLogico.getFont();
		scoreLogico.setFont(font.deriveFont(Font.PLAIN, 28));
		scoreLogico.setForeground(Color.WHITE);
		barraSuperior.add(scoreLogico);
		
		hiScoreLogico = new JLabel(juego.puntajeMaximo());
		hiScoreLogico.setSize(90,23);
		hiScoreLogico.setBounds(670,30,90,23);
		Font ffont = hiScoreLogico.getFont();
		hiScoreLogico.setFont(ffont.deriveFont(Font.PLAIN, 28));
		hiScoreLogico.setForeground(Color.WHITE);
		barraSuperior.add(hiScoreLogico);
		
		this.repaint();
		panelJuego.repaint();
		
	}
	
	
	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.setIcon(grafico);
			label.repaint();
		}
	}

	
	public void gano() {
		this.juego.nuevoHiScore(Integer.parseInt(juego.puntaje()));
		GameOver_Win win = new GameOver_Win(1);
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
		this.juego = null;
		win.setVisible(true);
		
	}


	public void perdio() {
		
		this.juego = null;
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
		GameOver_Win go = new GameOver_Win(0);
		go.setVisible(true);
		
	}


	public Container getMapa() {
		return panelJuego;
	}

	
	public void cambioNivel(int nivel) {
		this.reDimensionar(fondoJuego, new ImageIcon(Gui.class.getResource("/GraficasSpritesNiveles/FONDO-LVL0"+nivel+".png")));
		panelJuego.moveToBack(fondoJuego);
		panelJuego.pantallaNivel(nivel - 1);
		juego.pausa();
		if(nivel>1) {
		juego.reiniciarVidas();
		for(int i = 0; i<2; i++) {
			vidas[i].setEnabled(true);
		}}
		panelJuego.siguienteNivel();
		panelJuego.repaint();
	}

	
	public void actualizarBarraVida(int damage) {
		vida.setSize((vidaMaxima.getWidth() / 100) * damage, vida.getHeight());
		this.repaint();
	}

	public void actualizarPuntaje() {
		if(juego!=null) {
		scoreLogico.setText(juego.puntaje());
		this.repaint();}
	}
	
	public void actualizarNivelTanda(int nivel, int tanda) {
		ImageIcon im = new ImageIcon(getClass().getResource("/GraficasSpritesExtrasNivelTanda/nivel" + nivel + "tanda" + tanda + ".png"));
		this.nivelTanda.setIcon(im);
	}

	
	public void actualizarPowerUps(boolean[] mejoras) {
		for (int i = 0; i < estados.length; i++) {
			estados[i].setEnabled(mejoras[i]);
		}
	}
	

	
	public void sonidoDisparar() {
		try {
			
			Clip disparo = AudioSystem.getClip();
			disparo.open(AudioSystem
					.getAudioInputStream(getClass().getResource("/Sonidos/disparo_normal.wav")));
			disparo.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}


	public void perderUnaVida(int vidasRestantes) {
		vidas[vidasRestantes].setEnabled(false);
		this.repaint();
	}
}
