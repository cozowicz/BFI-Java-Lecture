import java.io.File;

public class Verzeichnisstruktur {
	
	private static void recursiveDir(File root, String einrueckung) {
		System.out.println(einrueckung+root.getName());
		File[] files = root.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				recursiveDir(files[i], einrueckung+"  ");			
			}
		}
	}
	
	public static void main(String[] args) {
		recursiveDir(new File("c:\\temp"), "");
	}
		
}
