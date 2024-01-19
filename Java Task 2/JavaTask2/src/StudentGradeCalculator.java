import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take the number of subjects with error handling
        int numOfSubjects = getNumberOfSubjects(scanner);

        int totalMarks = 0;

        // Take marks for each subject with error handling
        for (int i = 1; i <= numOfSubjects; i++) {
            int subjectMarks = getSubjectMarks(scanner, i);

            // Validate if marks are between 0 and 100
            if (subjectMarks < 0 || subjectMarks > 100) {
                printWithBorder("Invalid marks! Marks should be between 0 and 100. Please try again.");
                i--; // Decrement i to re-enter marks for the same subject
            } else {
                // Calculate Total Marks
                totalMarks += subjectMarks;
            }
        }

        // Print Results with Border
        printWithBorder("Total Marks: " + totalMarks);
        printWithBorder("Average Percentage: " + (double) totalMarks / numOfSubjects + "%");
        printWithBorder("Grade: " + calculateGrade((double) totalMarks / numOfSubjects));

        scanner.close();
    }

    // Function to get the number of subjects with error handling
    private static int getNumberOfSubjects(Scanner scanner) {
        int numOfSubjects = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                printWithBorder("Enter the number of subjects: ");
                numOfSubjects = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                printWithBorder("Invalid input. Please enter a valid number.");
                scanner.next(); // consume the invalid input
            }
        }

        return numOfSubjects;
    }

    // Function to get marks for a subject with error handling
    private static int getSubjectMarks(Scanner scanner, int subjectNumber) {
        int subjectMarks = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                printWithBorder("Enter marks for Subject " + subjectNumber + ": ");
                subjectMarks = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                printWithBorder("Invalid input. Please enter a valid number.");
                scanner.next(); // consume the invalid input
            }
        }

        return subjectMarks;
    }

    // Function to calculate grade based on average percentage
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else if (averagePercentage >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }

    // Function to print a string with a border
    private static void printWithBorder(String message) {
        int length = message.length() + 4;
        System.out.println("-".repeat(length));
        System.out.println("| " + message + " |");
        System.out.println("-".repeat(length));
    }
}
