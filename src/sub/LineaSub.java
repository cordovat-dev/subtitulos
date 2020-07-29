package sub;

/**
 * Linea de subtítulos de extensión .srt del formato:
 * 
		1
		00:00:39,373 --> 00:00:41,416
		Can you figure it, Neulin?
		
 * @author CORDOVATJ
 *
 */
public class LineaSub extends LineaSubtitulo {

	protected int piNumLinea;
	
	public int getNumLinea() {
		return piNumLinea;
	}

	public void setNumLinea(int piNumLinea) {
		this.piNumLinea = piNumLinea;
	}

	public LineaSub() throws FormatoIncorrectoException{
		super();
	}
	
	public LineaSub(String linea_){
		super(linea_);
	}	
	
	public String toString(){
		return 		
		piNumLinea + "\n" +
		psTiempoIni + " --> " + psTiempoFin + "\n" +
		psDialogo;		
	}

	@Override
	protected void parse(String linea_) throws FormatoIncorrectoException {
		/*Pattern p = Pattern.compile("\\{([0-9]*)\\}\\{([0-9]*)\\}(.*)");
		Matcher m = p.matcher(linea_);		*/
	}	
}
