package arc;

import java.io.FilenameFilter;
import java.util.List;

public abstract class PareadorArchivosAbstracto {
	
	List<ArchivoAbstracto> listaArchivosTipoA;
	List<ArchivoAbstracto> listaArchivosTipoB;
	List<ParArchivosAbstracto> listaPares;
	List<String> log;
	List<ArchivoAbstracto> listaArchivoTipoAsinB;
	List<ArchivoAbstracto> listaArchivoTipoBsinA;

	/**
	 * Genera una lista de archivos a partir de un filtro
	 * @param filtro filtro de nombres
	 * @return lista de archivos que cumplen con el filtro
	 * @throws DatosNoEncontradosException 
	 * @throws NombreDeArchivoMalFormadoException 
	 * @throws RutaNoExisteException 
	 * @throws RutaVaciaException 
	 */
	protected abstract List<ArchivoAbstracto> getListaArchivos(FilenameFilter filtro) throws NombreDeArchivoMalFormadoException, DatosNoEncontradosException, RutaNoExisteException, RutaVaciaException;
	/**
	 * Carga la lista de pares con sólo los archivos de tipo A
	 */
	protected abstract void cargarListaPares(); 
	/**
	 * Busca el par de tipo B para cada archivo de tipo A en la lista de pares
	 */
	protected abstract void buscarPares();
	/**
	 * Genera una lista de archivos con los items de una lista que no están en la otra
	 * @return
	 */
	protected abstract List<ArchivoAbstracto> getListaSinPar(List<ArchivoAbstracto> lista1, List<ArchivoAbstracto> lista2);
	/**
	 * Determina si dos archivos son considerados pares entre si
	 * @param archivo1
	 * @param archivo2
	 * @return
	 */
	protected abstract boolean sonPares(ArchivoAbstracto archivo1, ArchivoAbstracto archivo2);
	
	
	public List<ArchivoAbstracto> getListaArchivosTipoA() {
		return listaArchivosTipoA;
	}

	public List<ArchivoAbstracto> getListaArchivosTipoB() {
		return listaArchivosTipoB;
	}

	public List<ParArchivosAbstracto> getListaPares() {
		return listaPares;
	}
	
	public int buscarPar(ArchivoAbstracto a, List<ArchivoAbstracto> l){
		int result = -1;
		
		for(ArchivoAbstracto b: l){
			if (b.esPar(a)){
				result = l.indexOf(b);			
				break;
			}
		}
		
		return result;
	}
	
	public abstract String getReporte();
	
}
