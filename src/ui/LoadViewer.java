package ui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/*

	This class is without an access modifier to make it accessible only to this package.

*/
class LoadViewer {
	private JFileChooser fc;
	public File f;
	
	public LoadViewer () {
		if (fc == null)
			fc = new JFileChooser();
		
		fc.addChoosableFileFilter(new Filter());
		fc.setAcceptAllFileFilterUsed(false);
		
		int ret = fc.showOpenDialog(null);
		
		if (ret == JFileChooser.APPROVE_OPTION)
			f = fc.getSelectedFile();
		
		fc.setSelectedFile(null);
	}
	
	static class Filter extends FileFilter {
		@Override
		public boolean accept (File f) {
			if (f.isDirectory())
				return true;
			
			String ext = Util.getExtension(f);
			if (ext != null) {
				if (ext.equals(Util.ppm))
					return true;
				else
					return false;
			}
			
			return false;
		}

		@Override
		public String getDescription() {
			return "(*.ppm) - PPM Images";
		}
	}
	
	static class Util {
		public static final String ppm = "ppm";
		
		public static String getExtension (File f) {
			String ext = null;
			
			String name = f.getName();
			int i = name.indexOf('.');
			
			if (i > 0 && i < name.length() - 1)
				ext = name.substring(i + 1).toLowerCase();
			
			return ext;
		}
	}
}