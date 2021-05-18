package Vista;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class Presentacion extends Imagen{
	
	public Presentacion() {
		this.setNombreArchivoImagen("ArchivosNecesarios/Imagenes/fiuba.jpeg");
		this.setPosicionable(new PosicionadorFijo(ConstantesVista.ANCHO_PRESENTACIO, ConstantesVista.ANCHO_PRESENTACION));
	}	

}
