package sub;

import java.io.*;

import arc.DatosNoEncontradosException;
import arc.Fabrica;
import arc.FiltroArchivos;
import arc.NombreDeArchivoMalFormadoException;
import arc.PareadorArchivosAbstracto;
import arc.RutaNoExisteException;
import arc.RutaVaciaException;

final class Main {
	
	public static void parearSUbtitulos(String args[]) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException, RutaNoExisteException, RutaVaciaException {

		Fabrica fabrica = Fabrica.getInstance();
		
		try{
			
			String ruta = "/home/filder_with_videos_and_subtitules";
			String ext1 = ".mp4";
			String ext2 = ".srt";	
			
			FiltroArchivos f1 = new FiltroArchivos(ext1);
			FiltroArchivos f2 = new FiltroArchivos(ext2);
			File f = new File(ruta);
			
			PareadorArchivosAbstracto p = fabrica.createPareadorArchivoAbstracto(f, f1, f2);
			System.out.println(p.getReporte());
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\nusage: java -jar CarpetaSubtitulos path/ .ext1 .ext2" );
		} catch (RutaNoExisteException e){
			System.out.println("\npath not found: ? " + e.getMessage());
		} catch (RutaVaciaException e){
			System.out.println("\nempty folder: ...? " + e.getMessage());
		} catch (DatosNoEncontradosException e){
			System.out.println("\n>>>: $%#? " + e.getMessage());
		} catch (NombreDeArchivoMalFormadoException e){
			System.out.println("\nno season/chapter found in filename: " + e.getMessage());
		}
		
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
    
    private Main(){
    }
	
	public static void convSubAStr(ArchivoSubtitulo archEntrada_, ConvertidorLineaSubtitulos conv) throws FileNotFoundException, IOException, FPSNoEncontradoException, FormatoIncorrectoException{
		String line;
		String data = "";

		LineaSubtitulo linSubDest;
		
		while((line = archEntrada_.leerLinea()) != null) {
			
			linSubDest =  conv.convertir(line);

			if (!conv.getOmitirLinea()) {
				data += linSubDest;
			}
			
		}
		
		archEntrada_.cerrar();

		ArchivoSubtitulo.escribirDisco(data,archEntrada_.getNombre().replaceAll("\\.sub$",".srt"));
	}
	


	public static void main (String args[]) throws FileNotFoundException, IOException {

		try {
			Main.convSubAStr(new ArchivoSrt("Test.sub"), new ConvStrToSub());//args[0]);
		} catch (FileNotFoundException e){
			System.out.println("\n" + args[0] + " ?" );
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\n>>>: java ArchivoSubtitulos filename.sub" );
		} catch (FPSNoEncontradoException e){
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("bad FPS in first line");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}