package arc;

import java.io.File;

public abstract class ArchivoAbstracto extends File{
	String nombreSolo;
	String extension;
	public ArchivoAbstracto(String pathname) {
		super(pathname);
	}

	private static final long serialVersionUID = 1L;

	public abstract boolean esPar(ArchivoAbstracto arc);
	
	public String toString(){
		return this.getName();
	}

	public String getNombreSolo() {
		return nombreSolo;
	}

	public String getExtension() {
		return extension;
	}
	

}
