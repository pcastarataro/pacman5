package Vista;

public interface Skin {

	public abstract String getPacmanHaciaDerechaAbierto();

	public abstract String getPacmanHaciaDerechaCerrado();

	public abstract String getPacmanHaciaIzquierdaAbierto();

	public abstract String getPacmanHaciaIzquierdaCerrado();

	public abstract String getPacmanHaciaArribaAbierto();

	public abstract String getPacmanHaciaArribaCerrado();

	public abstract String getPacmanHaciaAbajoAbierto();

	public abstract String getPacmanHaciaAbajoCerrado();

	public abstract String getFantasmasPerseguidos();

	public abstract String getFantasmasComidos();

	public abstract String getFantasmaCazador();

	public abstract String getFantasmaEmbozcador();

	public abstract String getFantasmaIndeciso();

	public abstract String getPared();

	public abstract String getPasilloVacio();

	public abstract String getPasilloConPastilla();

	public abstract String getPasilloConPastillaEspecial();

	public abstract String getPasilloConManzana();

	public abstract String getPasilloConMelon();

	public abstract String getPasilloConCereza();

	public abstract String getPasilloConBanana();
	
	public abstract String getPuerta();
	
	public abstract String getPasaje();

	public abstract void setPacmanHaciaDerechaAbierto(
			String pacmanHaciaDerechaAbierto);

	public abstract void setPacmanHaciaDerechaCerrado(
			String pacmanHaciaDerechaCerrado);

	public abstract void setPacmanHaciaIzquierdaAbierto(
			String pacmanHaciaIzquierdaAbierto);

	public abstract void setPacmanHaciaIzquierdaCerrado(
			String pacmanHaciaIzquierdaCerrado);

	public abstract void setPacmanHaciaArribaAbierto(
			String pacmanHaciaArribaAbierto);

	public abstract void setPacmanHaciaArribaCerrado(
			String pacmanHaciaArribaCerrado);

	public abstract void setPacmanHaciaAbajoAbierto(
			String pacmanHaciaAbajoAbierto);

	public abstract void setPacmanHaciaAbajoCerrado(
			String pacmanHaciaAbajoCerrado);

	public abstract void setFantasmasPerseguido(String fantasmasPerseguido);

	public abstract void setFantasmasComidos(String fantasmasComidos);

	public abstract void setFantasmaCazador(String fantasmaCazador);

	public abstract void setFantasmaEmbozcador(String fantasmaEmbozcador);

	public abstract void setFantasmaIndeciso(String fantasmaIndeciso);

	public abstract void setPared(String pared);

	public abstract void setPasilloVacio(String pasilloVacio);

	public abstract void setPasilloConPastilla(String pasilloConPastilla);

	public abstract void setPasilloConPastillaEspecial(
			String pasilloConPastillaEspecial);

	public abstract void setPasilloConManzana(String pasilloConManzana);

	public abstract void setPasilloConMelon(String pasilloConMelon);

	public abstract void setPasilloConCereza(String pasilloConCereza);

	public abstract void setPasilloConBanana(String pasilloConBanana);

	public abstract void setPuerta(String puerta);

	public abstract String getFantasmasPerseguidosTitila();
	
	public abstract void setFantasmasPErseguidosTitila(String s);

	public abstract String getJuegoPerdido();
}