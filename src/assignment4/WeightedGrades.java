package assignment4;

import java.util.LinkedList;

public class WeightedGrades {

    // Declare 4 private attributes
    private LinkedList<Double> pointTotal;
    private LinkedList<Double> earnedPoints;
    private LinkedList<Double> assignmentPercentage;
    private double grades;

    // This is the constructor function in which I initialize attributes:
    public WeightedGrades ()
    {
        pointTotal = new LinkedList<>();
        earnedPoints = new LinkedList<>();
        assignmentPercentage = new LinkedList<>();
        grades = 0;
    }

    // The function aiming at setting TOTAL POINTS of each assignment:
    public void setPointTotal(double pointTotal) {
        this.pointTotal.add(pointTotal);
    }

    // The function aiming at setting EARNED POINTS of each assignment:
    public void setEarnedPoint(double earnedPoints) {
        this.earnedPoints.add(earnedPoints);
    }

    // The function aiming at setting PERCENTAGE of each assignment:
    public void setPercentage(double percentage) {
        assignmentPercentage.add(percentage);
    }

    // The function aiming at getting TOTAL POINTS of each assignment:
    public double getPointTotal(int i) { return pointTotal.get(i); }

    // The function aiming at getting EARNED POINTS of each assignment:
    public double getEarnedPoint(int i) {
        return earnedPoints.get(i);
    }

    // The function aiming at getting PERCENTAGE of each assignment:
    public double getPercentage(int i) {
        return assignmentPercentage.get(i);
    }

    // Calculate the final grades:
    public double calcGrades()
    {
        for (int size = pointTotal.size(), i = 0; i < size; i++) {
            grades += getEarnedPoint(i) / getPointTotal(i) * getPercentage(i);
        }
        return grades;
    }

}
