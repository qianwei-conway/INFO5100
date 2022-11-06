package lecture7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class WriteFile {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter(WriteFile.class.getResource("").getPath() + File.separator + "mywriting.txt");
            myWriter.write("This is a sample");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}