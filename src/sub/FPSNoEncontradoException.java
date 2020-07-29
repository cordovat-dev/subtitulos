package sub;

public class FPSNoEncontradoException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 105472353066149983L;

	public FPSNoEncontradoException ()
    {
        System.out.println("File has no FPS info in first line" );

    }

}
