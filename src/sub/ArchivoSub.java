package sub;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ArchivoSub extends ArchivoSubtitulo {
	
	String patronNumero = "^([0-9]+)$";
	String patronTiempos = "^([0-9]{2}:[0-9]{2}:[0-9]{2},[0-9]{1,4}) --> ([0-9]{2}:[0-9]{2}:[0-9]{2},[0-9]{1,4})$";
	String patronTextos = "^.+$";
	String patronLineaEnBlanco = "^$";

	public ArchivoSub(String rutaArchivo_) throws FileNotFoundException {
		super(rutaArchivo_);
	}

	@Override
	public String leerLinea() throws IOException, FormatoIncorrectoException {
		
		String linea = "";
		String temp = "";
		
		while((temp = reader.readLine()) != null){
			
		}
		
		temp = reader.readLine();
		if (temp.matches(patronLineaEnBlanco)) {
			temp = reader.readLine();
		}
		if (temp != null ){
			if (temp.matches(patronNumero)) {
				linea += temp;
				System.out.println("." + temp);
				temp = reader.readLine();
				if (temp.matches(patronTiempos)){
					linea += temp;
					System.out.println(".." + temp);
					temp = reader.readLine();
					while(!temp.matches(patronLineaEnBlanco)){
						linea += temp;
						System.out.println("..." + temp);
						temp = reader.readLine();
					}
				} else {
					throw new FormatoIncorrectoException("Se esperaban tiempos");
				}
			} else {
				throw new FormatoIncorrectoException("Se esperaba numero de linea");
			}			
		}

				
		return linea;
	}
	
	public static void main (String args[]) throws IOException, FormatoIncorrectoException{
		ArchivoSub a = new ArchivoSub("Test.srt");
		String s = a.leerLinea();
		while(s != null){
			s = a.leerLinea();
		}
		
		a.cerrar();
	}
	

}
