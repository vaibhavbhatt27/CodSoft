import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            totalMarks += scanner.nextInt();
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        char grade = 'F';
        if (averagePercentage >= 90) grade = 'A';
        else if (averagePercentage >= 80) grade = 'B';
        else if (averagePercentage >= 70) grade = 'C';
        else if (averagePercentage >= 60) grade = 'D';

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

