package es.uji.belfern.generador;

import java.util.Random;

import es.uji.belfern.nombres.LeeFichero;
import es.uji.belfern.nombres.NIF;
import es.uji.belfern.nombres.ProvinciaPoblacion;
import es.uji.belfern.data.BalancedTree;

public class GeneradorDatosINE {
	private static final String RUTA = "es/uji/belfern/";
	private BalancedTree hombres;
	private BalancedTree mujeres;
	private BalancedTree apellidos;
	private BalancedTree edades;
	private ProvinciaPoblacion provinciaPoblacion;
	private final Random random;
	private final NIF nif;

	public GeneradorDatosINE() {
		random = new Random();
		nif = new NIF();
		leeHombres();
		leeMujeres();
		leeApellidos();
		leeProvinciaPoblacion();
		leeEdades();
	}
	
	private final void leeHombres() {
		LeeFichero lector = new LeeFichero(RUTA + "data/nombresHombre.txt");
		hombres = new BalancedTree(lector.getIntervalos());
	}
	
	private final void leeMujeres() {
		LeeFichero lector = new LeeFichero(RUTA + "data/nombresMujer.txt");
		mujeres = new BalancedTree(lector.getIntervalos());
	}
	
	private final void leeApellidos() {
		LeeFichero lector = new LeeFichero(RUTA + "data/apellidos.txt");
		apellidos = new BalancedTree(lector.getIntervalos());
	}
	
	private final void leeEdades() {
		LeeFichero lector = new LeeFichero(RUTA + "data/edades.txt");
		edades = new BalancedTree(lector.getIntervalos());
	}
	
	private final void leeProvinciaPoblacion() {
		provinciaPoblacion = new ProvinciaPoblacion(RUTA + "data/provincias.txt", RUTA + "data/poblaciones.txt");
	}
	
	public String getNombreHombre() {		
		return hombres.contains(random.nextFloat()*100);
	}
	
	public String getNombreMujer() {
		return mujeres.contains(random.nextFloat()*100);
	}
	
	public String getNombre() {
		if(random.nextBoolean()) return getNombreHombre();
		else return getNombreMujer();
	}
	
	public String getApellido() {
		return apellidos.contains(random.nextFloat()*100);
	}
	
	public int getEdad() {
//		return new Integer(edades.contains(random.nextFloat()*100)).intValue();
		return Integer.valueOf(edades.contains(random.nextFloat()*100));
	}
	
	public String getProvincia() {
		return provinciaPoblacion.getProvincia();
	}
	
	public String getPoblacion(String provincia) {
		return provinciaPoblacion.getPoblacion(provincia);
	}
	
	public String getNIF() {
		return nif.getNIF();
	}
}
