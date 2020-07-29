package sub;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ArchivoSrt extends ArchivoSubtitulo {

	public ArchivoSrt(String rutaArchivo_) throws FileNotFoundException {
		super(rutaArchivo_);
	}

	@Override
	public String leerLinea() throws IOException {
		return reader.readLine();
	}

}
