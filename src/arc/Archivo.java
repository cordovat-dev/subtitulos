package arc;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Archivo extends ArchivoAbstracto {

	private static final long serialVersionUID = 1L;
	int temporada;
	private int capitulo;
	private String patrones[] = new String[]{".*[sS]([0-9]{2})[eE]([0-9]{2}).*",".*[^0-9]([0-9]){1,2}[xX]([0-9]{2})[^0-9].*"};
	 
	
	public Archivo(File file) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException {
		this(file.getAbsolutePath());		
	}
	
	public Archivo(String path_) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException{
		super(path_);
		this.extraerDatosCapitulo();
		this.parsearNombre();
	}
	
	private void extraerDatosCapitulo() throws NombreDeArchivoMalFormadoException{
		int i = 0;
		while(this.capitulo == 0 || this.temporada == 0){		
			try {
				this.extraerDatosCapitulo(patrones[i++]);
			} catch (IndexOutOfBoundsException e) {
				throw new NombreDeArchivoMalFormadoException(this.getName());
			} catch (DatosNoEncontradosException e) {
			}
		}
	}
	
	private void extraerDatosCapitulo(String patron) throws DatosNoEncontradosException{
		try {
			Pattern p = Pattern.compile(patron);
			Matcher m = p.matcher(this.getName());	
			m.find();
			this.temporada = Integer.parseInt(m.group(1));
			this.capitulo = Integer.parseInt(m.group(2));			
		} catch (IllegalStateException e) {
			throw new DatosNoEncontradosException(patron);
		}
	}
	
	private void parsearNombre() throws NombreDeArchivoMalFormadoException{
		try {
			Pattern p = Pattern.compile("(.*)(\\..{3})");
			Matcher m = p.matcher(this.getName());
			m.find();
			this.nombreSolo = m.group(1);
			this.extension = m.group(2);
		} catch (IllegalStateException e) {
			throw new NombreDeArchivoMalFormadoException(this.getName());
		}			
	}
	
	public int getTemporada() {
		return temporada;
	}

	public int getCapitulo() {
		return capitulo;
	}

	@Override
	public boolean esPar(ArchivoAbstracto arc) {
		Archivo a = (Archivo)arc;
		return this.temporada == a.getTemporada() && this.getCapitulo() == a.getCapitulo(); 
	}
	
	public static void main (String ss[]) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException{

		Pattern p = Pattern.compile(".*[^0-9]([0-9]){1,2}[xX]([0-9]{2})[^0-9].*");
		Matcher m = p.matcher("MASH - 06x19 - 139 - What's Up, Doc [512x384].avi");	
		m.find();
		System.out.println(m.group(1));
		System.out.println(m.group(2));

		
		
		
	}
	
	

}
