package ModeloDeDominio.Common;

/**
 * Constantes se maneja con velocidades por fantasmitas y factores por nivel.
 * Tambien se modifica las velocidades por fantasmitas dependiendo de la situacion.
 * @author lea
 */
public class Constantes {

	private static final double PUNTAJE_BANANA = 150;
	private static final double PUNTAJE_CEREZA = 100;
	private static final double PUNTAJE_MANZANA = 200;
	private static final double PUNTAJE_MELON = 1000;
	private static final double VELOCIDAD_CAZADOR = 0.17;
	private static final double VELOCIDAD_EMBOSCADOR = 0.15;
	private static final double VELOCIDAD_INDECISO = 0.19;
	private static final double VELOCIDAD_PACMAN = 0.20;
	private static final double PUNTAJE_PASTILLA = 10;
	private static final double PUNTAJE_PASTILLA_ESPECIAL= 100;
	private static final double PUNTAJE_FANTASMITA_COMIDO= 100;
	private static final double VELOCIDAD_DE_ESCAPE =0.1;
	private static final double VELOCIDAD_DE_VUELTA_A_CASA = 0.4;
	private static final double MARGEN_DE_PERSONAJES = 0.25;
	private static final int PUNTAJE_PARA_NUEVA_VIDA = 10000;
	private static final int TIEMPO_DE_EFECTO_PASTILLA_ESPECIAL = 200;
	private static final int TIEMPO_EN_EL_QUE_APARECE_UNA_FRUTA = 500;
	private static final int TIEMPO_DE_EFECTO_DE_UNA_FRUTA = 400;
	private static final double tiempoDeSalidaDeLosFantasmitas = 50;
	private static final double factorDeTiempo = 1;
	public static final int TICS_FREEZE_INICIANDO = 50;
	public static final int TICS_FREEZE_FANTASMITA_COMIDO = 20;
	public static final int AVISO_PASTILLA = 50;
	public static final int TICS_FREEZE_FRUTA_COMIDA = 20;
	public static final int TICS_FREEZE_SE_COMIERON_A_PACMAN = 80;
	public static final int TICS_FREEZE_NIVEL_GANADO = 300;

	private static double factorNivel(int nivel) {
		return (Math.log10(nivel+10)/Math.log(4));
	}

	public static double getPuntajePastillaEnNivel(int nivel) {
		return PUNTAJE_PASTILLA*factorNivel(nivel);
	}

	public static double getPuntajeDeFantasmitaComidoEnNivel(int nivel) {
		return PUNTAJE_FANTASMITA_COMIDO*factorNivel(nivel);
	}

	public static double getPuntajeDeBanana() {
		return PUNTAJE_BANANA;
	}

	public static double getPuntajeDeCereza() {
		return PUNTAJE_CEREZA;
	}

	public static double getPuntajeDeManzana() {
		return PUNTAJE_MANZANA;
	}

	public static double getPuntajeDeMelon() {
		return PUNTAJE_MELON;
	}

	private static double getVelocidadPacman(){
		return VELOCIDAD_PACMAN;
	}

	private static double getVelocidadEmbozcador(){
		return VELOCIDAD_EMBOSCADOR;
	}

	private static double getVelocidadIndeciso(){
		return VELOCIDAD_INDECISO;
	}

	private static double getVelocidadDeEscape(){
		return VELOCIDAD_DE_ESCAPE;
	}

	private static double getVelocidadCazador(){
		return VELOCIDAD_CAZADOR;
	}

	public static double getPuntajePastillaEspecial(){
		return PUNTAJE_PASTILLA_ESPECIAL;
	}

	public static double getVelocidadPacmanParaNivel(int nivel) {
		return (getVelocidadPacman()*factorNivel(nivel)*factorDeTiempo);
	}

	public static double getVelocidadCazadorParaNivel(int nivel) {
		return getVelocidadCazador()*factorNivel(nivel)*factorDeTiempo;
	}

	public static double getVelocidadEmbozcadorParaNivel(int nivel) {
		return getVelocidadEmbozcador()*factorNivel(nivel)*factorDeTiempo;
	}

	public static double getVelocidadIndecisoParaNivel(int nivel) {
		return getVelocidadIndeciso()*factorNivel(nivel)*factorDeTiempo;
	}

	public static double getVelocidadDeEscapePAraNivel(int nivel){
		return getVelocidadDeEscape()*factorNivel(nivel)*factorDeTiempo;
	}

	public static double getVelocidadVueltaACasaParaNivel(int nivel){
		return getVelocidadVueltaACasa()*factorNivel(nivel)*factorDeTiempo;
	}
	private static double getVelocidadVueltaACasa() {
		return VELOCIDAD_DE_VUELTA_A_CASA*factorDeTiempo;
	}

	public static double getMargenDePersonajes() {
		return MARGEN_DE_PERSONAJES;
	}

	public static int getPuntajeParaNuevaVida() {
		return PUNTAJE_PARA_NUEVA_VIDA;
	}

	public static int tiempoDeSalidaDeFantasmitasParaNivel(int nivel) {
		return (int) (tiempoDeSalidaDeLosFantasmitas/factorNivel(nivel)/factorDeTiempo);
	}

	public static int getTiempoDeEfectoDeUnaFruta() {
		return (int)(TIEMPO_DE_EFECTO_DE_UNA_FRUTA/factorDeTiempo);
	}

	public static int getTiempoEnElQueApareceUnaFruta() {
		return (int)(TIEMPO_EN_EL_QUE_APARECE_UNA_FRUTA/factorDeTiempo);
	}

	public static int getTiempoDeEfectoPastillaEspecial() {
		return (int)(TIEMPO_DE_EFECTO_PASTILLA_ESPECIAL/factorDeTiempo);
	}
}

