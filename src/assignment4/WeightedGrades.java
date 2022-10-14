package assignment4;

import java.util.Scanner;

public class WeightedGrades {

    // Declare 4 private attributes
    private double[] pointTotal = {20, 30, 40, 50, 60, 100, 200, 300};
    private double[] earnedPoints = new double[8];
    private double[] assignmentPercentage = {10, 10, 10, 10, 10, 10, 15, 25};
    private double grades = 0;

    // This is the constructor function:
    public WeightedGrades ()
    {
    }

    // In order to get the total point in Main function:
    public double getPointTotal(int i) {
        return pointTotal[i];
    }

    // The function aiming at get input of earned points
    public void setEarnedPoint(double earnedPoints, int i) {
        this.earnedPoints[i] = earnedPoints;
    }

    // Calculate the final grades:
    public double calcGrades()
    {
        for (int i = 0; i < 8; i++) {
            grades += earnedPoints[i] / pointTotal[i] * assignmentPercentage[i];
        }
        return grades;
    }

}
