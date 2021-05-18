package Vista;

import ModeloDeDominio.ElementosEstaticos.Banana;
import ModeloDeDominio.ElementosEstaticos.Cereza;
import ModeloDeDominio.ElementosEstaticos.ElementoEstatico;
import ModeloDeDominio.ElementosEstaticos.Fruta;
import ModeloDeDominio.ElementosEstaticos.Manzana;
import ModeloDeDominio.ElementosEstaticos.Melon;
import ModeloDeDominio.ElementosEstaticos.Pastilla;
import ModeloDeDominio.ElementosEstaticos.PastillaEspecial;
import ModeloDeDominio.Laberinto.Celdas.CeldaConcreta;
import ModeloDeDominio.Laberinto.Celdas.Pasaje;
import ModeloDeDominio.Laberinto.Celdas.Puerta;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaCelda extends Imagen {
	private Skin skin;
	
	public VistaCelda(Skin skin){
		super();
		this.skin=skin;
	}
	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		CeldaConcreta celda =(CeldaConcreta)this.getPosicionable();
		String ruta = null;
		if (celda.sufrioUnCambio()){
			if (! celda.esTransitable()){
				if (celda instanceof Puerta)
					ruta = skin.getPuerta();
				else 
					ruta = skin.getPared();				
			}
			else
				if (celda.estaCargada()){
					ElementoEstatico almacenado = celda.getElementoAlmacenado();
					if (almacenado instanceof PastillaEspecial)
						ruta = skin.getPasilloConPastillaEspecial();
					else
						if (almacenado instanceof Pastilla)
							ruta = skin.getPasilloConPastilla();
						else 
							if (almacenado instanceof Fruta)
								ruta = tipoDeFruta(almacenado);
				}
				else{
					if (celda instanceof Pasaje)
							ruta= skin.getPasaje();
					else 
						ruta = skin.getPasilloVacio();
				}
			this.setNombreArchivoImagen(ruta);			
			celda.cambioYaTenidoEnCuenta();
		}
		super.dibujar(superficeDeDibujo);
	}
	


	private String tipoDeFruta(ElementoEstatico almacenado) {
		if (almacenado instanceof Banana)
			return skin.getPasilloConBanana();
		else if (almacenado instanceof Cereza)
			return skin.getPasilloConCereza();
		else if (almacenado instanceof Manzana)
			return skin.getPasilloConManzana();
		else if (almacenado instanceof Melon)
			return skin.getPasilloConMelon();
		else return "";
	}
	

}
