package assignment4;

import java.util.LinkedList;

public class WeightedGrades {

    // Declare 4 private attributes
    private LinkedList<Double> pointTotal = new LinkedList<>();
    private LinkedList<Double> earnedPoints = new LinkedList<>();
    private LinkedList<Double> assignmentPercentage = new LinkedList<>();
    private double grades = 0;

    // This is the constructor function:
    public WeightedGrades ()
    {
    }

    // The function aiming at get input of TOTAL POINTS of each assignment:
    public void setPointTotal(double pointTotal) {
        this.pointTotal.add(pointTotal);
    }

    // The function aiming at get input of EARNED POINTS of each assignment:
    public void setEarnedPoint(double earnedPoints) {
        this.earnedPoints.add(earnedPoints);
    }

    // The function aiming at get input of PERCENTAGE of each assignment:
    public void setPercentage(double percentage) {
        assignmentPercentage.add(percentage);
    }

    // Calculate the final grades:
    public double calcGrades()
    {
        for (int size = pointTotal.size(), i = 0; i < size; i++) {
            grades += earnedPoints.get(i) / pointTotal.get(i) * assignmentPercentage.get(i);
        }
        return grades;
    }

}
