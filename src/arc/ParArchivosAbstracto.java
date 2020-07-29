package arc;

public abstract class ParArchivosAbstracto {
	
	private ArchivoAbstracto archivoTipoA;
	private ArchivoAbstracto archivoTipoB;
	
	public ArchivoAbstracto getArchivoTipoA() {
		return archivoTipoA;
	}
	public void setArchivoTipoA(ArchivoAbstracto archivoTipoA_) {
		this.archivoTipoA = archivoTipoA_;
	}
	public ArchivoAbstracto getArchivoTipoB() {
		return archivoTipoB;
	}
	public void setArchivoTipoB(ArchivoAbstracto archivoTipoB_) {
		this.archivoTipoB = archivoTipoB_;
	}
		
	public String toString(){
		
		String result;
		if (this.getArchivoTipoB() == null) {
			result = this.getArchivoTipoA().toString() + " : " + "null";
		} else {
			result = this.getArchivoTipoA().toString() + " : " + this.getArchivoTipoB().toString();
		}
		return result;
	}

}
