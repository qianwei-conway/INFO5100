package assignment6;

public class WeightedGrades {

    // Declare 4 private attributes
    private double totalPoint;
    private double earnedPoints;
    private double assignmentPercentage;
    private double grade;

    // This is the constructor function:
    public WeightedGrades ()
    {
    }

    // Three public methods to get the inputs from users and assign the attributes:
    public void setTotalPoint(double totalPoint)
    {
        this.totalPoint = totalPoint;
    }

    public void setEarnedPoint(double earnedPoints) { this.earnedPoints = earnedPoints; }

    public void setAssignmentPercentage(double assignmentPercentage) { this.assignmentPercentage = assignmentPercentage; }

    // Calculate the final grades:
    public double calcGrades() {
        grade = earnedPoints / totalPoint * assignmentPercentage;
        return grade;
    }
}
