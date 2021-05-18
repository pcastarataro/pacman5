package Vista;

import java.awt.Color;


import ModeloDeDominio.Juego.JuegoConcreto;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Texto;

public class VistaPuntaje extends Texto{
	

	public VistaPuntaje(){
		super();
		setColor(Color.GREEN);
		setTamanio(20);
	}
	public void dibujar(SuperficieDeDibujo superfice) {
		super.setTexto("PUNTAJE:  "+ (int)JuegoConcreto.getInstancia().getPuntaje());
		super.dibujar(superfice);
	}
}
