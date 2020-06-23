import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.InterruptedException;
import java.awt.image.ImageObserver;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import java.lang.Class;
import javax.swing.ImageIcon;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.ImageIcon;




public class Principal extends JFrame{

	
		
	
		
	
	public static int reiniciaJuego =- 1;


	public static void main(String[] args){

		MiReproductor mr2 = new MiReproductor();
		mr2.inicializar();
		mr2.reproducirNota2(60, 1, 600);

		
	JOptionPane.showMessageDialog(null,"INICIANDO JUEGO...", "Cactus Jump !!!", JOptionPane.INFORMATION_MESSAGE);

	JFrame ventana = new JFrame("CACTUS JUMP !!!");
	Juego jueguito = new Juego();
	ventana.add(jueguito);
	ventana.setSize(1300,400);
	ventana.setLocation(70,200);
	ventana.setVisible(true);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	try{
			Image img =ImageIO.read(new File("Icon.jpg"));
			ventana.setIconImage(img);

		}
		catch(Exception e){System.out.println(e);}

		ImageIcon c = new ImageIcon("/multimedia/cactusJack.png");

	while(true){
		if(jueguito.juegoFinalizado){
			reiniciaJuego = JOptionPane.showConfirmDialog(null,"¿Quiere guardar su datos?","Guardar o Salir", JOptionPane.YES_NO_OPTION,1,c);
			String inputValue = JOptionPane.showInputDialog("Introduzca su nombre de usuario:");

			String nombreUsuario = inputValue;
			Archivo.guardarTodo(nombreUsuario, "puntuacion");
			






			if(reiniciaJuego == 0){
				reiniciaValores();
			}else if(reiniciaJuego == 1){
				System.exit(0);
			}
		}else{
					jueguito.repaint();
				try{
					Thread.sleep(10);
				}catch(InterruptedException ex){
					//Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
				}
			if(Juego.pierdeVida == true){

				JOptionPane.showMessageDialog(null,"-1 POR BURRO");
				Juego.pierdeVida = false;
				Juego.vidas--;
				Monito.y_inicial = 270;
				Monito.saltando = false;
				Obstaculo.x_inicial = 1300; 
						
			}

		}

		jueguito.repaint();
		try{
			Thread.sleep(10);
		}catch(InterruptedException ex){
			//Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	public static void reiniciaValores(){
		Juego.juegoFinalizado = false;
		Obstaculo.x_auxiliar =- 4;
		Juego.puntos = 0;
		Juego.nivel = 1;
		Juego.vidas = 3;
		reiniciaJuego =-1;
		Obstaculo.x_inicial = 1300;
	}
}
