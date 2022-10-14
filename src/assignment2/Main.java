package assignment2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initiate an instance of class WeightedGrades
        WeightedGrades weightedgrades;
        weightedgrades = new WeightedGrades();

        // Ask for inputs
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the total point:");
        weightedgrades.setPointTotal(input.nextDouble());
        System.out.println("Please input earned points:");
        weightedgrades.setEarnedPoint(input.nextDouble());
        System.out.println("Please input the assignment percentage:");
        weightedgrades.setAssignmentPercentage(input.nextDouble());

        // Count the final grades and print out
        weightedgrades.calcGrades();
        weightedgrades.outputWeightedGrades();

    }
}