package assignment7;

import java.io.*;
import java.net.URL;

public class FileWork {
    // This is the constructor function:
    public FileWork()
    {
    }

    // This function aims to READ a file.
    public String readFile(String fileName){
        // Declaring object of StringBuilder class
        StringBuilder builder = new StringBuilder();

        // try block to check for exceptions where
        // object of BufferedReader class I created to read file
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(getClass().getResource(fileName).getPath()))) {

            // Store the content from the file
            String str;

            // Condition check via buffer.readLine() method
            // holding true upto that the while loop runs
            while ((str = buffer.readLine()) != null) {
                builder.append(str).append("\n");
            }
        }
        // Catch block to handle the exceptions
        catch (IOException e) {
            System.out.println("An error occurred.");
            // using printStackTrace() method when errors occur.
            e.printStackTrace();
        }

        // Returning the content string
        return builder.toString();
    }

    // This function aims to WRITE a file.
    public void writeFile(String res, String fileName){
        try {
            // Create a new file in the same path.
            File outStream = new File ("src/assignment7/" + fileName);
            if (outStream.createNewFile()) {
                System.out.println("File created: " + outStream.getName());
            }
            else {
                System.out.println("File already exists.");
            }

            // No matter if the file exists, write into it anyway.
            FileWriter myWriter = new FileWriter(outStream);
            myWriter.write(res);
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
