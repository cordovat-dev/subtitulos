package sub;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Linea de subtítulos de extensión .sub del formato:
 * 
		{944}{993}Can you figure it, Neulin?
		
 * @author CORDOVATJ
 *
 */
public class LineaSrt extends LineaSubtitulo{

	protected int piFrameIni;
	protected int piFrameFin;
	protected double pdFramePorSeg=0;
	
	public int getFrameIni() {
		return piFrameIni;
	}

	public void setFrameIni(int piFrameIni_) {
		piFrameIni = piFrameIni_;
	}

	public int getFrameFin() {
		return piFrameFin;
	}

	public void setFrameFin(int piFrameFin_) {
		piFrameFin = piFrameFin_;
	}
	
	public LineaSrt(String linea_) throws FormatoIncorrectoException{
		super(linea_);
		parse(linea_);

	}
	
	protected void parse(String linea_) throws FormatoIncorrectoException{
		try {
			Pattern p = Pattern.compile("\\{([0-9]*)\\}\\{([0-9]*)\\}(.*)");
			Matcher m = p.matcher(linea_);

			m.find();
			psTiempoIni = "{" + m.group(1) + "}";
			psTiempoFin = "{" + m.group(2) + "}";
			piFrameIni = Integer.parseInt(m.group(1));
			piFrameFin = Integer.parseInt(m.group(2));								
			
			if (piFrameIni==1 && piFrameFin==1){
				pdFramePorSeg = Double.parseDouble(m.group(3));
			} else {
				psDialogo = m.group(3);	
			}			
		} catch (IllegalStateException e) {
			throw new FormatoIncorrectoException("Formato de subt�tulo incorrecto");
		}		
	}
	
	public String toString(){
		return psTiempoIni + psTiempoFin + psDialogo +"\n";
	}

	public double getFramePorSeg() {
		return pdFramePorSeg;
	}

	public void setFramePorSeg(double pdFramePorSeg_) {
		pdFramePorSeg = pdFramePorSeg_;
	}
	
}
