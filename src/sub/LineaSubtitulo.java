package sub;

public abstract class LineaSubtitulo implements Cloneable {
	protected String psTiempoIni;
	protected String psTiempoFin;
	protected String psDialogo = "";
	protected String psSubtitulo;
	
	public LineaSubtitulo() throws FormatoIncorrectoException {		
	}
	
	public LineaSubtitulo(String linea_) {
		psSubtitulo = linea_;
	}

	public String getTiempoIni() {
		return psTiempoIni;
	}
	public void setTiempoIni(String tiempoIni_) {
		this.psTiempoIni = tiempoIni_;
	}
	public String getTiempoFin() {
		return psTiempoFin;
	}
	public void setTiempoFin(String tiempoFin_) {
		this.psTiempoFin = tiempoFin_;
	}
	public String getDialogo() {
		return psDialogo;
	}
	public void setDialogo(String dialogo_) {
		this.psDialogo = dialogo_;
	}

	public Object clone(){
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	public abstract String toString();
	protected abstract void parse(String linea_)throws FormatoIncorrectoException;
}
