package arc;

public class RutaVaciaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RutaVaciaException(String absolutePath) {
		super(absolutePath);
	}

}
