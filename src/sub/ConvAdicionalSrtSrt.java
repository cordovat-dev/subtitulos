package sub;

public class ConvAdicionalSrtSrt extends ConvertidorLineaSubtitulos {

	@Override
	public LineaSubtitulo convertir(String linea_) {
		
		LineaSub sRipOrig = (LineaSub)getInstanciaLineaOrigen(linea_);
		LineaSub sRipDest = (LineaSub) sRipOrig.clone();
		
		sRipDest.setDialogo(sRipDest.getDialogo().toUpperCase());

		return sRipDest;
	}

	@Override
	public LineaSubtitulo getInstanciaLineaDestino(String dato_) {
		return new LineaSub(dato_);
	}

	@Override
	public LineaSubtitulo getInstanciaLineaOrigen(String dato_) {
		return new LineaSub(dato_);
	}

}
