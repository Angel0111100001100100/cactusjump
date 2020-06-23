import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.lang.Class;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;


public class Obstaculo{

	Juego jueguito;

	Area cabeza,cuerpo,dino;

	int anchoObstaculo = 70;
	int altoObstaculo = 70;

	static int x_inicial = 1300;
	static int y_inicial = 270;

	static int x_auxiliar = -4;



	public Obstaculo(Juego jueguito){
		this.jueguito = jueguito;

				
	}
	public void mover(){
		if(x_inicial<=-100){

			jueguito.puntos++;
			x_inicial = 1300;
			if(jueguito.puntos == 3 | jueguito.puntos == 6 | jueguito.puntos == 9 | jueguito.puntos == 12 | jueguito.puntos == 14 | jueguito.puntos == 16 | jueguito.puntos == 18 | jueguito.puntos == 20){
				x_auxiliar+=-2;
				jueguito.nivel++;

			}
		}else{
			if(colision()){
				if(jueguito.vidas == 0){
					jueguito.finJuego();	
				}else{
					jueguito.pierdeVida();
				}
			}else{
				x_inicial+=x_auxiliar;
				
			}
		}		
	}

	public void paint(Graphics2D g){
		ImageIcon dino = new ImageIcon(getClass().getResource("/multimedia/cactusJack.png"));
		g.drawImage(dino.getImage(), x_inicial, y_inicial, anchoObstaculo, altoObstaculo,null);


	}

	public Area getBounds(){
		Ellipse2D forma1 = new Ellipse2D.Double(x_inicial, y_inicial, 40, 40);
		Rectangle forma2 = new Rectangle(x_inicial+12, y_inicial+16, 50, 53);
		cabeza = new Area(forma1);
		cuerpo = new Area(forma2);

		dino = cabeza;
		dino.add(cabeza);
		dino.add(cuerpo);

		return dino;
	}
	public boolean colision(){
		Area areaA = new Area(jueguito.monito.getBounds());
		areaA.intersect(getBounds());

		return !areaA.isEmpty();

	}
}