import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile extends Driver {
	
	public static void writeToFile(String text) {
		try {
			File file = new File("file.txt");
			FileWriter fw = new FileWriter(file, true);
			fw.write(text);
			fw.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
