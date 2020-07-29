package sub2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineaSubtituloSub extends LineaSubtitulo {
	
	protected long fps;
	
	@SuppressWarnings("unused")
	private LineaSubtituloSub(String linea_) throws FormatoIncorrectoException{
		super(linea_);
	}
	
	@SuppressWarnings("unused")
	private LineaSubtituloSub(RangoTiempo rango_, String dialogo_){
		super(rango_, dialogo_);
	}	

	public LineaSubtituloSub(String linea__, long fps_) throws FormatoIncorrectoException{
		super(linea__);
		fps = fps_;
	}	
	public LineaSubtituloSub(RangoTiempo rango_, String dialogo_, long fps_){
		super(rango_, dialogo_);
		fps = fps_;
	}

	@Override
	protected void parse() throws FormatoIncorrectoException {
		try {
			Pattern p = Pattern.compile("\\{([0-9]*)\\}\\{([0-9]*)\\}(.*)");
			Matcher m = p.matcher(subtitulo);

			m.find();
			String sDesde = "{" + m.group(1) + "}";
			String sHasta = "{" + m.group(2) + "}";
			
			rango = new RangoTiempo(Long.parseLong(sDesde),Long.parseLong(sHasta));
			
			dialogo = m.group(3);
						
		} catch (IllegalStateException e) {
			throw new FormatoIncorrectoException("Formato de subtítulo incorrecto");
		}
	}

	@Override
	public String toString() {
		
		String s = this.subtitulo;
		
		if (s == null) {
			
		} 
		
		return s;
	}

}
