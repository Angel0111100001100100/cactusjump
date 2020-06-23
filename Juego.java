import javax.swing.JPanel;
import java.applet.Applet;
import java.awt.event.*;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics; 
import java.awt.Font;
import java.awt.Color;

public class Juego extends JPanel{
		//sonido del juego
				/*URL direccionSonidoSalto,direccionSonidoChoque;
				AudioClip sonidoChoque, sonidoSalto;*/

		//objetos de las clases auto, obstaculo y fondo
				Monito monito = new Monito(this);
				Obstaculo obstaculo = new Obstaculo(this);
				Fondo fondo = new Fondo(this);

		//variables para el juego 
				public static boolean juegoFinalizado = false;
				public static boolean pierdeVida=false;
				public static int vidas = 3;
				public static int puntos = 0;
				public static int nivel = 1;

	public Juego(){
		MiReproductor mr = new MiReproductor();
		mr.inicializar();
		mr.reproducirNota(60, 1, 1);
		mr.reproducirNota1(60, 1, 1);

		addKeyListener(new KeyListener(){
		@Override
			public void keyPressed(KeyEvent e)
			{
				//salto espacio
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					mr.reproducirNota(60, 0, 1);

					monito.keyPressed(e);
				}
			}
		@Override
			public void keyReleased(KeyEvent e)
			{
				
			}
		@Override
			public void keyTyped(KeyEvent e)
			{
				
			}


		});
		setFocusable(true);
	}

	public void mover(){
		obstaculo.mover();
		monito.mover();
		fondo.mover();
	}



	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		dibujar(g2);
		dibujarPuntaje(g2);
	}
	public void dibujar(Graphics2D g){
		fondo.paint(g);
		monito.paint(g);
		obstaculo.paint(g);
		mover();


	}

	public void dibujarPuntaje(Graphics2D g){
		Graphics2D g1=g, g2=g;
		Font score = new Font("Action Man Shaded", Font.BOLD,30);
		g.setFont(score);
		g.setColor(Color.black);
		g1.drawString("PUNTOS: " + puntos,1100, 30);
		g1.drawString("VIDAS: " + vidas, 20, 30);
		g1.drawString("NIVEL: " + nivel, 570, 30);

		if(juegoFinalizado){
			g2.setColor(Color.black);
			g2.drawString("GAME OVER",((float)getBounds().getCenterX()/2)+170, 70);
		}
	}
	public void finJuego(){
		MiReproductor mr1 = new MiReproductor();
		mr1.inicializar();
		mr1.reproducirNota1(60, 1, 1);
		juegoFinalizado=true;
	}
	public void pierdeVida(){
		MiReproductor mr1 = new MiReproductor();
		mr1.inicializar();
		mr1.reproducirNota1(60, 1, 1);
		pierdeVida=true;
	}
	
}