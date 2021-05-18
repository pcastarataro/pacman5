package Vista;

import java.awt.Color;

import ar.uba.fi.algo3.titiritero.vista.Texto;

public class VistaPausa extends Texto{
	VistaPausa(){
		super();
		super.setTexto("Pausado");
		super.setTamanio(30);
		super.setColor(Color.GREEN);
		super.setPosicionable(new PosicionadorFijo(200,220));	
	}
}
