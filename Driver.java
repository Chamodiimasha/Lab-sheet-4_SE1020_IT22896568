public class Driver {

    // Attributes
    private String driverID;
    private String driverName;
    private double baseSalary;
    private int performanceScore; // valid range: 0 - 100

    // Bonus percentages based on performance score
    // Score >= 90  -> 20% bonus
    // Score >= 75  -> 15% bonus
    // Score >= 50  -> 10% bonus
    // Score < 50   ->  0% bonus

    // Constructor 1: accepts only driverID and driverName
    public Driver(String driverID, String driverName) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.baseSalary = 0.0;
        this.performanceScore = 0;
    }

    // Constructor 2: accepts only baseSalary
    public Driver(double baseSalary) {
        this.driverID = "N/A";
        this.driverName = "Unknown";
        this.baseSalary = baseSalary;
        this.performanceScore = 0;
    }

    // Constructor 3: initializes all four attributes
    public Driver(String driverID, String driverName, double baseSalary, int performanceScore) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.baseSalary = baseSalary;
        setPerformanceScore(performanceScore); // use setter for validation
    }

    // Getter for driverID
    public String getDriverID() {
        return driverID;
    }

    // Setter for driverID
    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    // Getter for performanceScore
    public int getPerformanceScore() {
        return performanceScore;
    }

    // Setter for performanceScore with validation (must be 0 - 100)
    public void setPerformanceScore(int performanceScore) {
        if (performanceScore >= 0 && performanceScore <= 100) {
            this.performanceScore = performanceScore;
        } else {
            this.performanceScore = 0; // default to 0 if invalid
        }
    }

    // Helper: get bonus percentage based on a given score
    private double getBonusPercentage(int score) {
        if (score >= 90) {
            return 0.20;
        } else if (score >= 75) {
            return 0.15;
        } else if (score >= 50) {
            return 0.10;
        } else {
            return 0.00;
        }
    }

    // calculateBonus() - Version 1: uses actual stored performanceScore
    public double calculateBonus() {
        return baseSalary * getBonusPercentage(performanceScore);
    }

    // calculateBonus(int customScore) - Version 2: uses a custom score (does NOT modify stored value)
    public double calculateBonus(int customScore) {
        return baseSalary * getBonusPercentage(customScore);
    }

    // calculateTotalSalary() - baseSalary + bonus based on stored performanceScore
    public double calculateTotalSalary() {
        return baseSalary + calculateBonus();
    }

    // Display all driver details
    public void displayDriverDetails() {
        System.out.println("Driver ID          : " + driverID);
        System.out.println("Driver Name        : " + driverName);
        System.out.println("Base Salary        : $" + String.format("%.2f", baseSalary));
        System.out.println("Performance Score  : " + performanceScore);
        System.out.println("Bonus              : $" + String.format("%.2f", calculateBonus()));
        System.out.println("Total Salary       : $" + String.format("%.2f", calculateTotalSalary()));
        System.out.println("Bonus (custom score 95): $" + String.format("%.2f", calculateBonus(95)));
    }

    // Main method
    public static void main(String[] args) {

        // Constructor 1: only driverID and driverName
        Driver d1 = new Driver("D001", "Alice Johnson", 3000.00, 85);
        System.out.println("=== Driver 1 (Constructor 1) ===");
        d1.displayDriverDetails();

        System.out.println();

        // Constructor 2: only baseSalary
        Driver d2 = new Driver(2500.00);
        d2.setDriverID("D002");
        d2.setPerformanceScore(45);
        System.out.println("=== Driver 2 (Constructor 2) ===");
        d2.displayDriverDetails();

        System.out.println();

        // Constructor 3: all four attributes
        Driver d3 = new Driver("D003", "Bob Smith", 4000.00, 92);
        System.out.println("=== Driver 3 (Constructor 3) ===");
        d3.displayDriverDetails();

        System.out.println();

        // Test invalid performance score (should default to 0)
        Driver d4 = new Driver("D004", "Carol White", 3500.00, 150);
        System.out.println("=== Driver 4 (Invalid Score - defaults to 0) ===");
        d4.displayDriverDetails();
    }
}
