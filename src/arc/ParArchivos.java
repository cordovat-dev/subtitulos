package arc;

public class ParArchivos extends ParArchivosAbstracto {
	
	/*
	 * Este constructor deja el archivo tipo B por definir
	 */
	public ParArchivos(ArchivoAbstracto archivoTipoA_){
		this.setArchivoTipoA(archivoTipoA_);
	}
	
	
	
	public ParArchivos(ArchivoAbstracto archivoTipoA_, ArchivoAbstracto archivoTipoB_) {
		this.setArchivoTipoA(archivoTipoA_);
		this.setArchivoTipoB(archivoTipoB_);
	}

}
