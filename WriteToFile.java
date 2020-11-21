import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile extends Driver {
	
	public static void writeToFile() {
		try {
			
			File file = new File("file.txt");
			FileWriter fw = new FileWriter(file, true);
			if (type.equals("Movie")) {
				fw.write(movieName + "\n");
			} else if (type.equals("Show") || type.equals("Anime")) {
				fw.write(movieName + " Episode: " + showNum + "\n");
			} else if (type.equals("Manga")) {
				fw.write(movieName + " Chapter: " + showNum + "\n");
			}
			
			fw.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
