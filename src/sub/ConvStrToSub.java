package sub;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ConvStrToSub extends ConvertidorLineaSubtitulos {
	
	private double pdFramesPorSeg=0;
	private int piNumLinea=0;
	
	public ConvStrToSub(){
		super();
		setOmitirLinea(true);
	}
	protected static String convSegASrt(double segs_){

		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat decimalFormat = (DecimalFormat)numberFormat;
		
		double dmm = segs_ / 60;

		int 	ihh = (int)(dmm/60);
		int 	imm = (int)dmm - (ihh * 60);
		double 	dss = (dmm - imm) * 60;
		int iss = (int)dss;
		dss = (double)Math.round((dss - iss) * 1000);

		decimalFormat.applyPattern("00");

		String sSrt = decimalFormat.format(ihh) + ":" + decimalFormat.format(imm) + ":" + decimalFormat.format(iss) + ",";
		decimalFormat.applyPattern("##0");
		sSrt += decimalFormat.format(dss);

		return sSrt;

	}	
	
	@Override
	public LineaSubtitulo convertir(String linea_) throws FormatoIncorrectoException {		

		LineaSrt mDvd = (LineaSrt) getInstanciaLineaDestino(linea_);
		
		if (pdFramesPorSeg == 0) {pdFramesPorSeg = mDvd.getFramePorSeg();}
		
		LineaSub sRip = new LineaSub(); 
		
		//double fps = mDvd.getFramePorSeg();
		int frameIni = mDvd.getFrameIni();
		int frameFin = mDvd.getFrameFin();
		double segsIni = convFramesASeg(frameIni,pdFramesPorSeg);
		double segsFin = convFramesASeg(frameFin,pdFramesPorSeg);
		String dialogo = mDvd.getDialogo();
		
		dialogo = dialogo.replaceAll("\\|","\n");			//sustituyo los | por retorno de carro
		dialogo = dialogo.replaceAll("\\{[yY]\\:[^}]*\\}","");	//elimino los comandos de formato		
		
		sRip.setNumLinea(piNumLinea);
		sRip.setTiempoIni(convSegASrt(segsIni));
		sRip.setTiempoFin(convSegASrt(segsFin));	
				
		sRip.setDialogo(dialogo + "\n\n");

		if (piNumLinea++ > 0){setOmitirLinea(false);}
		
		return sRip;
	}
	@Override
	public LineaSubtitulo getInstanciaLineaDestino(String dato_) throws FormatoIncorrectoException {
		return new LineaSrt(dato_);
	}
	@Override
	public LineaSubtitulo getInstanciaLineaOrigen(String dato_) {
		return new LineaSub(dato_);
	}
	
}
