package assignment2;

import java.util.Scanner;

public class WeightedGrades {

    // Declare 4 private attributes
    private double pointTotal;
    private double earnedPoints;
    private double assignmentPercentage;
    private double grades;

    // This is the constructor function:
    public WeightedGrades ()
    {
    }

    // Three public methods to get the inputs from users and assign the attributes:
    public void setPointTotal(double pointTotal)
    {
        this.pointTotal = pointTotal;
    }

    public void setEarnedPoint(double earnedPoints) { this.earnedPoints = earnedPoints; }

    public void setAssignmentPercentage(double assignmentPercentage) { this.assignmentPercentage = assignmentPercentage; }

    // Calculate the final grades:
    public void calcGrades()
    {
        grades = earnedPoints / pointTotal * assignmentPercentage * 100;
    }

    // Print out the final grades:
    public void outputWeightedGrades()
    {
        System.out.println("Your weighted grades is:");
        System.out.println(String.format("%.3f", grades));
    }

}
