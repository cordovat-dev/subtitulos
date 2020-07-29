package sub2;

public abstract class LineaSubtitulo implements Cloneable {
	protected RangoTiempo rango=null;
	protected String dialogo = "";
	protected String subtitulo=null;

	protected LineaSubtitulo(){
		
	}
	
	public LineaSubtitulo(String linea_) throws FormatoIncorrectoException {
		subtitulo = linea_;
		parse();
	}
	
	public LineaSubtitulo(RangoTiempo rango_, String dialogo_) {
		rango = rango_;
		dialogo = dialogo_;
	}	

	public long getDesde() {
		return rango.getDesde();
	}
	
	public long getHasta() {
		return rango.getHasta();
	}
	
	public RangoTiempo getRango(){
		return rango;
	}
	
	public String getDialogo() {
		return dialogo;
	}	
	
	public abstract String toString();
	protected abstract void parse()throws FormatoIncorrectoException;
}
