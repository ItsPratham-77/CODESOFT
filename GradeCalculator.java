package Calculation;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Student Grade Calculator ---");

        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();
        sc.nextLine();

        String[] subjects = new String[numSubjects];
        int[] marks = new int[numSubjects];
        int totalMarks = 0;


        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter name of subject " + (i + 1) +" -> " );
            subjects[i] = sc.nextLine();

            System.out.print("Enter marks for " + subjects[i] + " -> " );
            marks[i] = sc.nextInt();
            sc.nextLine();

            totalMarks += marks[i];
        }

        double average = (double) totalMarks / numSubjects;


        String gradeobtained;
        if (average >= 90) {
            gradeobtained = "A+";
        }

        else if (average >= 80) {
            gradeobtained = "A";
        }
        else if (average >= 70) {
            gradeobtained = "B+";
        }
        else if (average >= 60) {
            gradeobtained = "B";
        }

        else if (average >= 50) {
            gradeobtained = "C+";
        }
        else if (average >= 40) {
            gradeobtained = "C";
        }
        else if (average >= 35) {
            gradeobtained = "D";
        }
        else {
            gradeobtained = "F (Fail)";
        }
        //I added this Maximum and minimum mark feature
        int maxMark = 0, minMark = 0;
        for (int i = 1; i < numSubjects; i++) {
            if (marks[i] > marks[maxMark]) maxMark = i;
            if (marks[i] < marks[minMark]) minMark = i;
        }



        System.out.println("--- Result ---");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println(subjects[i] + " : " + marks[i] + " / 100");
        }
        System.out.println("Total Marks     : " + totalMarks);
        System.out.printf("Average Percent : %.2f%%\n", average);
        System.out.println("Grade           : " + gradeobtained);
        System.out.println("Highest Scoring Subject: " + subjects[maxMark] + " (" + marks[maxMark] + ")");
        System.out.println("Lowest Scoring Subject : " + subjects[minMark] + " (" + marks[minMark] + ")");

        System.out.println("--GRADING SYSYEM AS FOLLOWS--");
        System.out.println("A+ : 90-100");
        System.out.println("A  : 80-89");
        System.out.println("B+ : 70-79");
        System.out.println("B  : 60-69");
        System.out.println("C+ : 50-59");
        System.out.println("C  : 40-49");
        System.out.println("D  : 35-39");
        System.out.println("F  : Below 35 (Fail)");


    }
}


