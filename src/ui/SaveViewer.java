package ui;

import java.io.File;

import javax.swing.JFileChooser;

/*

	This class is without an access modifier to make it accessible only to this package.

*/
class SaveViewer {
	private JFileChooser fc;
	public File f;
	
	public SaveViewer () {
		if (fc == null)
			fc = new JFileChooser();
		
		int ret = fc.showSaveDialog(null);
		
		if (ret == JFileChooser.APPROVE_OPTION)
			f = fc.getSelectedFile();
	}
}