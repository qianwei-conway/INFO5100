package assignment4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initiate an instance of class WeightedGrades
        WeightedGrades weightedgrades;
        weightedgrades = new WeightedGrades();

        // Ask for inputs, the user should KEEP INPUTTING total points, earned points, percentage until -1 has been input.
        // And the total points, the remainder of percentage for each assignment are showed on the screen.
        Scanner input = new Scanner(System.in);

        // remainingPercentage is created in order to tell user how much percentage is left
        int remainingPercentage = 100;

        System.out.println("Please separate the variables WITH SPACES, and enter -1 at the end...");
        while(true) {
            StringBuilder sb = new StringBuilder("Please input the [Total Points, Earned Points, Percentage] without brackets");
            sb.append(" ( remaining percentage: ");
            sb.append(remainingPercentage);
            sb.append("% ):");
            System.out.println(sb);

            String line = input.nextLine();

            // Check if user enters a -1, if true then break the loop, else continue
            // IMPORTANT: DO NOT USE == TO CHECK BECAUSE == ONLY CHECKS ADDRESS, EQUALS() IS THE RIGHT WAY TO CHECK THE CONTENT OF STRINGS!!!
            if(line.equals("-1")) {
                break;
            }

            // Split the string with one or more spaces:
            String[] vars = line.split("\\s+");

            // Add the inputs into three LinkedLists separately.
            weightedgrades.setPointTotal(Double.parseDouble(vars[0]));
            weightedgrades.setEarnedPoint(Double.parseDouble(vars[1]));
            weightedgrades.setPercentage(Double.parseDouble(vars[2]));

            // Update remainder of percentage
            remainingPercentage -= Double.parseDouble(vars[2]);
        }

        // Count the final grades
        double grades = weightedgrades.calcGrades();
        String levelgrade;

        // Judge the level grade and print out
        if (grades >= 90) {
            levelgrade = "A";
        } else if (grades >= 80) {
            levelgrade = "B";
        } else if (grades >= 70) {
            levelgrade = "C";
        } else if (grades >= 60) {
            levelgrade = "D";
        } else {
            levelgrade = "F";
        }

        System.out.println("Your final grades is: " + String.format("%.3f", grades));
        System.out.println("Your final level grade is: " + levelgrade);
    }
}