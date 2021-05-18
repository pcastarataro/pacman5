package Vista;

import java.util.ArrayList;

import ModeloDeDominio.Common.Direccion;
import ModeloDeDominio.Juego.JuegoConcreto;
import ModeloDeDominio.Juego.JuegoConcreto.EstadosDelJuego;
import ModeloDeDominio.Personajes.Pacman;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaPacman extends Imagen{

	boolean abierto ;
	int contador;
	private Skin skin;
	private ArrayList<String> listaAnimacionPacmanSeMurio;
	private int contadorAnimacionMuertePacman;

	public VistaPacman(Skin skin){
		super();
		contadorAnimacionMuertePacman=0;
		abierto = true;
		this.skin= skin;
		listaAnimacionPacmanSeMurio = new ArrayList<String>();
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/1.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/2.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/3.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/4.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/5.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/6.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/7.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/8.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/1.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/9.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/10.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/11.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/12.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/13.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/14.png");
		listaAnimacionPacmanSeMurio.add("ArchivosNecesarios/Imagenes/PacmanSeMuere/15.png");		
	}

	public void dibujar(SuperficieDeDibujo superficie){
		Pacman pacman= (Pacman)this.getPosicionable();
		Direccion direccionPacman= pacman.getVelocidad().getDireccion();
		String rutaArchivoADibujar=null;

		if (JuegoConcreto.getInstancia().getEstadoGeneral() == EstadosDelJuego.SE_COMIERON_A_PACMAN)
			rutaArchivoADibujar = animacionPacmanSeMurio();
		else{
			if (direccionPacman== Direccion.ARRIBA){
				if (abierto){
					rutaArchivoADibujar=skin.getPacmanHaciaArribaAbierto();
					contador++;
				}
				else{
					rutaArchivoADibujar=skin.getPacmanHaciaArribaCerrado();
					contador++;
				}
			} else if (direccionPacman== Direccion.ABAJO){
				if (abierto){
					rutaArchivoADibujar= skin.getPacmanHaciaAbajoAbierto();
					contador++;
				}
				else{
					rutaArchivoADibujar= skin.getPacmanHaciaAbajoCerrado();
					contador++;
				}
			} else if (direccionPacman== Direccion.DERECHA){
				if (abierto){
					rutaArchivoADibujar= skin.getPacmanHaciaDerechaAbierto();
					contador++;
				}
				else{
					rutaArchivoADibujar= skin.getPacmanHaciaDerechaCerrado();
					contador++;
				}
			} else if (direccionPacman== Direccion.IZQUIERDA){
				if (abierto){
					rutaArchivoADibujar= skin.getPacmanHaciaIzquierdaAbierto();
					contador++;
				}
				else{
					rutaArchivoADibujar= skin.getPacmanHaciaIzquierdaCerrado();
					contador++;
				}
			}
			else if (direccionPacman == Direccion.NULA){
				rutaArchivoADibujar = skin.getPacmanHaciaDerechaCerrado();
			}
			else rutaArchivoADibujar = skin.getPacmanHaciaDerechaCerrado();


			if (contador == ConstantesVista.CiclosConBocaDelPacmanAbiertaOCerrada){
				if (abierto)
					abierto = false;
				else
					abierto = true;
				contador = 0;
			}
		}

		super.setNombreArchivoImagen(rutaArchivoADibujar);
		super.dibujar(superficie);
	}

	private String animacionPacmanSeMurio() {
		String ruta = listaAnimacionPacmanSeMurio.get(contadorAnimacionMuertePacman);
		contadorAnimacionMuertePacman ++;
		if (contadorAnimacionMuertePacman == 15)
			contadorAnimacionMuertePacman = 0;
		return ruta;
	}
}
