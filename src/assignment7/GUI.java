package assignment7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    // Declare some GUI widgets used for showing words, action buttons, input fields.
    private JFrame frame;
    private JPanel panel;
    private JLabel readingFileNameLabel;
    private JTextField readingFileName;
    private JButton read;
    private JTextArea readingFileContent;

    private JLabel writingFileNameLabel;
    private JTextField writingFileName;
    private JButton write;
    private JTextArea writingFileContent;

    // Declare an object coming from FileWork class, which will be used when processing flat files.
    private FileWork filework;

    // Declare a string which stores the contents of the original file.
    private String readingContent;

    // Declare an integer that store the line number of the content which will be shown in the GUI, in case of changes in the future.
    private int displayLinesNumber;

    // Declare an integer that store the field number of the content which will remain in the output file, in case of changes in the future.
    private int fieldsNumber;


    // This is the constructor function in which I instantiate all the objects I have declared before.
    public GUI()
    {
        // Instantiate the GUI widgets with titles (or the words needed to show in that widget) and bounds (positions).
        frame = new JFrame("Read And Write");
        frame.setSize(800, 300);

        panel = new JPanel();
        // Set the layout to null then I can manually set the coordinate position and size of the component myself.
        panel.setLayout(null);

        readingFileNameLabel = new JLabel("Reading File Name");
        readingFileNameLabel.setBounds(20, 20, 360, 25);

        // The default showing of the reading file name:
        readingFileName = new JTextField("annual.csv", 100);
        readingFileName.setBounds(20,50,160,25);

        read = new JButton("read");
        read.setBounds(20, 80, 160, 25);

        readingFileContent = new JTextArea();
        readingFileContent.setBounds(20, 110, 360, 150);


        writingFileNameLabel = new JLabel("Writing File Name");
        writingFileNameLabel.setBounds(420, 20, 360, 25);

        writingFileName = new JTextField(100);
        writingFileName.setBounds(420,50,160,25);

        write = new JButton("write");
        write.setBounds(420, 80, 160, 25);

        writingFileContent = new JTextArea();
        writingFileContent.setBounds(420, 110, 360, 150);

        filework = new FileWork();
        readingContent = "";
        displayLinesNumber = 5;
        fieldsNumber = 3;
    }

    public void createAndShowGUI() {
        // Make the window look and feel better.
        JFrame.setDefaultLookAndFeelDecorated(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the panel (a graphic area that can hold some widgets within a frame) onto the frame.
        frame.add(panel);

        // Add other widgets into the panel.
        panel.add(readingFileNameLabel);
        panel.add(readingFileName);
        panel.add(read);
        panel.add(readingFileContent);
        panel.add(writingFileNameLabel);
        panel.add(writingFileName);
        panel.add(write);
        panel.add(writingFileContent);

        // Show the frame.
        frame.setVisible(true);

        // Add event listeners, then the function inside will eventually and automatically execute...
        // when the button (which the event listener is linked to) is clicked.
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Invoke a function in the FileWork class, which aims to READ a file.
                readingContent = filework.readFile(readingFileName.getText());

                // Invoke a function in the GUI class, which aims to DISPLAY first 5 rows of the original file.
                display(readingFileContent, readingContent);
            }
        });

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tell the user that the program is executing and writing file
                writingFileContent.append("Writing into file... The Content is...\n\n");

                // Invoke a function in the GUI class, keep the first 3 fields of each line
                String writeContent = cutoutFields(readingContent);

                // Invoke a function in the GUI class, which aims to DISPLAY first 5 rows of the writing content.
                display(writingFileContent, writeContent);

                // Invoke a function in the FileWork class, which aims to WRITE a file.
                filework.writeFile(writeContent, writingFileName.getText());

                // Tell the user that the program is done and a file has been written.
                writingFileContent.append("\nWriting Complete!");
            }
        });
    }

    // This function aims to display something in the text area.
    private void display(JTextArea textArea, String content) {
        String[] display = content.split("\n", displayLinesNumber+1);
        for(int i = 0; i < displayLinesNumber; i++) {
            textArea.append(display[i] + "\n");
        }
    }

    // This function aims to keep only a few fields from the original content.
    private String cutoutFields(String content) {
        String[] lines = content.split("\n");
        String writeContent = "";
        for(String line : lines) {
            String[] vars = line.split(",");
            for(int i = 0; i < fieldsNumber; i++) {
                writeContent += vars[i];
                writeContent += ",";
            }
            writeContent = writeContent.substring(0, writeContent.length()-1) + "\n";
        }
        return writeContent;
    }

}
