import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.lang.Class;




public class Fondo{

	Juego jueguito;

	int anchoFondo = 1300;
	int altoFondo = 400;

	int x1 = 1300;
	int y1 = 0;

	int x2 = 0;
	int y2 = 0;


	public Fondo(Juego jueguito){

		this.jueguito = jueguito;
	}
	public void mover(){
		x1 -= 2;
		x2 -= 2;
		if(x1 == 0 && x2 == -1300){
			x1 = 1300;
			x2 = 0;
		}
	}

	public void paint(Graphics2D g){
		ImageIcon fondo = new ImageIcon(getClass().getResource("/multimedia/desierto.jpg"));
		g.drawImage(fondo.getImage(), x1, y1, anchoFondo, altoFondo, null);
		g.drawImage(fondo.getImage(), x2, y2, anchoFondo, altoFondo, null);
	}
}
