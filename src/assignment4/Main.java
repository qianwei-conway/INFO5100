package assignment4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initiate an instance of class WeightedGrades
        WeightedGrades weightedgrades;
        weightedgrades = new WeightedGrades();

        // Ask for inputs, the user should input 8 times.
        // And the total points for each assignment are showed on the screen.
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder("Please input the scores of assignment ");
            sb.append(i+1);
            sb.append(" (total: ");
            sb.append(String.format("%.0f", weightedgrades.getPointTotal(i)));
            sb.append(")");
            System.out.println(sb);
            weightedgrades.setEarnedPoint(input.nextDouble(), i);
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