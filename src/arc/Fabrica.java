package arc;

import java.io.File;

public class Fabrica {
	
	private static Fabrica instancia = new Fabrica();
	
	private Fabrica(){
		
	}
	
	public static Fabrica getInstance(){
		return instancia;
	}
	
	public ArchivoAbstracto createArchivo(File file) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException{
		return new Archivo(file);
	}
	
	public ArchivoAbstracto createArchivo(String path) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException{
		return new Archivo(path);
	}
	
	public ParArchivosAbstracto createParAcrhivos(ArchivoAbstracto a){
		return new ParArchivos(a);
	}
	
	public ParArchivosAbstracto createParAcrhivos(ArchivoAbstracto a, ArchivoAbstracto b){
		return new ParArchivos(a,b);
	}	
	
	public PareadorArchivosAbstracto createPareadorArchivoAbstracto(File f, FiltroArchivos f1, FiltroArchivos f2) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException, RutaNoExisteException, RutaVaciaException{
		return new PareadorArchivos(f, f1, f2);		
	}
	
}
