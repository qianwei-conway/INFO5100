package lecture7;

import java.io.File;
import java.io.IOException;
public class FileOutput {
    public static void main(String[] args) {
        try {
            File outStream = new File ("myFile.txt");
            if (outStream.createNewFile()) {
                System.out.println("File created: " + outStream.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}