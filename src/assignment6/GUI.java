package assignment6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    // Declare some private GUI widgets used for showing words, action buttons, input fields.
    private JFrame frame;
    private JPanel panel;
    private JLabel totalPointLabel;
    private JTextField totalPoint;
    private JLabel earnedPointLabel;
    private JTextField earnedPoint;
    private JLabel percentageLabel;
    private JTextField percentage;
    private JButton calc;
    private JLabel gradeLabel;

    // Declare a WeightedGrades object.
    private WeightedGrades weightedgrades;

    // This is the constructor function in which I instantiate all the objects I have declared before.
    public GUI()
    {
        // Instantiate the GUI widgets with titles (or the words needed to show in that widget) and bounds (positions).
        frame = new JFrame("Weighted Grades");
        frame.setSize(330, 260);

        panel = new JPanel();
        // Set the layout to null then I can manually set the coordinate position and size of the component myself.
        panel.setLayout(null);

        totalPointLabel = new JLabel("Total Point:");
        totalPointLabel.setBounds(30, 20, 120, 25);

        totalPoint = new JTextField(10);
        totalPoint.setBounds(140,20,90,25);

        earnedPointLabel = new JLabel("Earned Point:");
        earnedPointLabel.setBounds(30, 60, 120, 25);

        earnedPoint = new JTextField(10);
        earnedPoint.setBounds(140,60,90,25);

        percentageLabel = new JLabel("Percentage (%):");
        percentageLabel.setBounds(30, 100, 120, 25);

        percentage = new JTextField(10);
        percentage.setBounds(140,100,90,25);

        calc = new JButton("Calculate");
        calc.setBounds(70,140,100,25);

        gradeLabel = new JLabel();
        gradeLabel.setBounds(30, 180, 300, 25);

        // Instantiate the WeightedGrades class.
        weightedgrades = new WeightedGrades();
    }

    public void createAndShowGUI() {
        // Make the window look and feel better.
        JFrame.setDefaultLookAndFeelDecorated(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the panel (a graphic area that can hold some widgets within a frame) onto the frame.
        frame.add(panel);

        // Add other widgets into the panel.
        panel.add(totalPointLabel);
        panel.add(totalPoint);
        panel.add(earnedPointLabel);
        panel.add(earnedPoint);
        panel.add(percentageLabel);
        panel.add(percentage);
        panel.add(calc);
        panel.add(gradeLabel);

        // Show the frame.
        frame.setVisible(true);

        // Add an event listener, then the function inside will eventually and automatically execute
        // when the button (which the event listener is linked to) is clicked.
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the contents from the input fields, parse and transmit them to the variables in the weightedgrades.
                weightedgrades.setTotalPoint(Double.parseDouble(totalPoint.getText()));
                weightedgrades.setEarnedPoint(Double.parseDouble(earnedPoint.getText()));
                weightedgrades.setAssignmentPercentage(Double.parseDouble(percentage.getText()));

                // Count the final grades using the function in the WeightedGrades and show the final grades in the window.
                gradeLabel.setText("The grade of this assignment is: " + String.format("%.2f", weightedgrades.calcGrades()) + ".");
            }
        });
    }

}
