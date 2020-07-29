package arc;

import java.io.File;
import java.io.FilenameFilter;

public class FiltroArchivos implements FilenameFilter {

	private String extension;
	
	public FiltroArchivos(String ext_){
		this.extension = ext_;
	}
	
	@Override
	public boolean accept(File arg0, String arg1) {
		return arg1.endsWith(extension);
	}

}
