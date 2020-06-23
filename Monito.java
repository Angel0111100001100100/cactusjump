import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.lang.Class;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;



public class Monito{


	Juego jueguito;

	static boolean saltando=false;
	boolean sube = false;
	boolean baja = false;

	Area derecha,izquierda,cuerpo,cactus;
	int anchoPersonaje = 112;
	int altoPersonaje = 78;

	static int x_inicial = 50;
	static int y_inicial = 270;

	int x_auxiliar = 0;
	int y_auxiliar = 0;


	public Monito(Juego jueguito){

		

		this.jueguito = jueguito;
	}
	public void mover(){
		if(x_inicial + x_auxiliar > 0 && x_inicial + x_auxiliar < jueguito.getWidth()-anchoPersonaje){
			x_inicial += x_auxiliar;
		}
		if(saltando){
			if(y_inicial == 270){
				sube = true;
				y_auxiliar =- 2;
				baja = false;
			}
			if (y_inicial == 150){
				baja = true;
				y_auxiliar = 2;
				sube = false;
			}
			if(sube){
				y_inicial += y_auxiliar;
			}
			if(baja){
				y_inicial += y_auxiliar;
				if (y_inicial == 270){
					saltando = false;
				
				}
			}
			if(jueguito.puntos >= 12){
			if(y_inicial == 270){
				sube = true;
				y_auxiliar =- 4;
				baja = false;
			}
			if (y_inicial == 150){
				baja = true;
				y_auxiliar = 4;
				sube = false;
			}
			if(sube){
				y_inicial += y_auxiliar;
			}
			if(baja){
				y_inicial += y_auxiliar;
				if (y_inicial == 270){
					saltando = false;
				
				}
			}
			}

		}







	}

	public void paint(Graphics2D g){
		ImageIcon monito = new ImageIcon(getClass().getResource("/multimedia/cactus.png"));
		
		g.drawImage(monito.getImage(), x_inicial, y_inicial, anchoPersonaje, altoPersonaje,null);


	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()== KeyEvent.VK_SPACE){
			saltando = true;
		}
	}
	public Area getBounds(){
		Rectangle forma1 = new Rectangle(x_inicial, y_inicial, 95, 62);
		cuerpo = new Area(forma1);

		Ellipse2D forma2 = new Ellipse2D.Double(x_inicial, y_inicial+28, 48, 48);
		izquierda = new Area(forma2);

		Ellipse2D forma3 = new Ellipse2D.Double(x_inicial+73, y_inicial+39, 38, 38);
		derecha = new Area(forma3); 

		cactus = cuerpo;
		cactus.add(cuerpo);
		cactus.add(izquierda);
		cactus.add(derecha);

		return cactus;
	}
}