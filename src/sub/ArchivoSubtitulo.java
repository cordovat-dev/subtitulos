package sub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class ArchivoSubtitulo {
	File archivo;
	BufferedReader reader;
	
	public ArchivoSubtitulo(String rutaArchivo_) throws FileNotFoundException{
		archivo = new File(rutaArchivo_);
		reader = new BufferedReader(new FileReader(archivo));		
	}
	
    public static void escribirDisco(String dato, String nomArch)
    {
		PrintWriter outFile;
		File archivo = new File(nomArch);
		try
		{
			outFile = new PrintWriter(new FileWriter(archivo));
			outFile.println(dato);
			outFile.close();
		}
		catch (IOException e)
		{
			System.out.println(nomArch + " &$#!");
		}
	}	
    
	public abstract String leerLinea() throws IOException, FormatoIncorrectoException;
	
	public String getNombre(){
		return archivo.getName();
	}
	
	public void cerrar(){
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void finalize(){
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
