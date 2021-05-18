package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class Texto implements Dibujable{

	private Posicionable posicionable;
	private String texto;
	private int tamanio;
	private String nombreLetra;
	private Color color;
	
	public Texto(){
		this.setColor(Color.BLACK);
		this.setTamanio(12);
		this.setNombreLetra("Comic Sans");
		this.setTexto("");
	}
	
	public void setNombreLetra(String nombre) {
		this.nombreLetra = nombre;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;	
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = (Graphics)superfice.getBuffer();
		grafico.setColor(color);
		grafico.setFont(new Font(nombreLetra, Font.BOLD, tamanio));
		grafico.drawString(texto, posicionable.getX(),posicionable.getY());
		
	}
	
	public void setTexto(String texto){
		this.texto = texto;
	}
	
	public String getTexto(){
		return texto;
	}

	@Override
	public Posicionable getPosicionable() {
		return posicionable;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
		
	}

	public void setTexto(int i) {
		setTexto(Integer.toString(i));		
	}

}
