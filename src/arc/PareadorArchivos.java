package arc;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class PareadorArchivos extends PareadorArchivosAbstracto {
	
	private Fabrica fabrica = Fabrica.getInstance();
	
	private File path;
	
	public PareadorArchivos(File path_, FiltroArchivos filtroA, FiltroArchivos filtroB) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException, RutaNoExisteException, RutaVaciaException{
		path = path_;
		this.listaArchivosTipoA = this.getListaArchivos(filtroA);
		this.listaArchivosTipoB = this.getListaArchivos(filtroB);		
		this.cargarListaPares();		
		this.listaArchivoTipoAsinB = this.getListaSinPar(this.listaArchivosTipoA, this.listaArchivosTipoB);
		this.listaArchivoTipoBsinA = this.getListaSinPar(this.listaArchivosTipoB, this.listaArchivosTipoA);
		this.buscarPares();
		
	}

	@Override
	protected List<ArchivoAbstracto> getListaArchivos(FilenameFilter filtro) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException, RutaNoExisteException, RutaVaciaException {		
		
		List<ArchivoAbstracto> lista = new ArrayList<ArchivoAbstracto>();
		boolean vacia = true;
		
		if (this.path.exists()) {
			for (File f: path.listFiles(filtro)){
				lista.add(fabrica.createArchivo(f));
				vacia = false;
			}			
		} else {
			throw new RutaNoExisteException(path.getAbsolutePath());
		}
		
		if (vacia){
			throw new RutaVaciaException(path.getAbsolutePath());
		}
		
		return lista;
	}

	@Override
	protected void cargarListaPares() {
		this.listaPares = new ArrayList<ParArchivosAbstracto>();
		
		for (ArchivoAbstracto a : this.listaArchivosTipoA){
			this.listaPares.add(fabrica.createParAcrhivos(a));
		}

	}

	@Override
	protected void buscarPares() {
		int pos;
		for (ParArchivosAbstracto p: listaPares){
			pos = this.buscarPar(p.getArchivoTipoA(), this.listaArchivosTipoB);
			if (pos > -1) {
				p.setArchivoTipoB(this.getListaArchivosTipoB().get(pos));				
			}
		}

	}
	
	

	@Override
	protected List<ArchivoAbstracto> getListaSinPar(List<ArchivoAbstracto> lista1, List<ArchivoAbstracto> lista2) {
		List<ArchivoAbstracto> l = new ArrayList<ArchivoAbstracto>();
		for (ArchivoAbstracto a: lista1){
			if (this.buscarPar(a, lista2) == -1){
				l.add(a);
			}
		}
		return l;
	}

	@Override
	protected boolean sonPares(ArchivoAbstracto archivo1, ArchivoAbstracto archivo2) {
		return archivo1.esPar(archivo2);
	}
	
	@Override
	public String getReporte(){
		String s = "";

		if (this.listaArchivoTipoAsinB.size() > 0 || this.listaArchivoTipoBsinA.size() > 0){
			
			s += "# unmatched files: \n#\n";
			for (ArchivoAbstracto a: this.listaArchivoTipoAsinB){
				s += "# " + a.getName() + "\n";
			}
			
			for (ArchivoAbstracto a: this.listaArchivoTipoBsinA){
				s += "# " + a.getName() + "\n";
			}	
			s += "#\n#\n";
		}	
		
		for (ParArchivosAbstracto par: this.getListaPares()){	
			if (par.getArchivoTipoB() != null) {
				s += "mv \"" +   par.getArchivoTipoB().getName() 
					+ "\" \"" + par.getArchivoTipoA().getNombreSolo()+ par.getArchivoTipoB().getExtension() 
					+ "\"\n";					
			} else {
				s += "# ???????? \""+ par.getArchivoTipoA().getName() + "\"\n";
			}
		}
		
		return s;
	}
	

}
