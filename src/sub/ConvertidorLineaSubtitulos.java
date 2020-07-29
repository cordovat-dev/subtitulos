package sub;

public abstract class ConvertidorLineaSubtitulos {
	
	protected boolean pbOmitirLinea;
	
	public ConvertidorLineaSubtitulos(){
	}

	public boolean getOmitirLinea(){ return pbOmitirLinea; }
	
	public void setOmitirLinea(boolean opcion_){ pbOmitirLinea = opcion_;}
	
	public abstract LineaSubtitulo convertir(String linea_) throws FormatoIncorrectoException;

	public abstract LineaSubtitulo getInstanciaLineaOrigen(String dato_)throws FormatoIncorrectoException;	
	public abstract LineaSubtitulo getInstanciaLineaDestino(String dato_)throws FormatoIncorrectoException;
	
	public static double convFramesASeg(int frames_, double fps_){
		return frames_ / fps_;
	}	

}
