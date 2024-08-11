import java.util.*;

//STUDENT GRADE CALCULATOR
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of subjects
        System.out.print("Enter the total number of subjects : ");
        int numSubjects = sc.nextInt();

        int marks[] = new int[numSubjects];
        int totalMarks = 0;

        for(int i=0; i<numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i+1) + ": ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Calculate grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        //display
        System.out.println("Total marks : " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade : " + grade);

        sc.close();
    }
}
