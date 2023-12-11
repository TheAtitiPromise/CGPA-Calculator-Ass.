// package com.company.phase3;


public class GpaChallenge {

    private int calculateGradeUnit(int score) {
        if (score >= 70 && score <= 100) {
            return 5;
        } else if (score >= 60 && score <= 69) {
            return 4;
        } else if (score >= 50 && score <= 59) {
            return 3;
        } else if (score >= 45 && score <= 49) {
            return 2;
        } else if (score >= 40 && score <= 44) {
            return 1;
        } else {
            return 0;
        }
    }

    private String getGrade(int score) {
        if (score >= 70 && score <= 100) {
            return "A";
        } else if (score >= 60 && score <= 69) {
            return "B";
        } else if (score >= 50 && score <= 59) {
            return "C";
        } else if (score >= 45 && score <= 49) {
            return "D";
        } else if (score >= 40 && score <= 44) {
            return "E";
        } else {
            return "F";
        }
    }

    private void calculateGpa(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Welcome to GPA Calculator");
        System.out.println("Enter the number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        String[] courseNames = new String[numCourses];
        String[] courseCodes = new String[numCourses];

        int[] courseUnits = new int[numCourses];
        int[] courseScores = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter details for Course " + (i + 1) + ":");
            System.out.print("Course Name: ");
            courseNames[i] = scanner.nextLine();
            System.out.print("Course Code: ");
            courseCodes[i] = scanner.nextLine();
            System.out.print("Course Unit: ");
            courseUnits[i] = scanner.nextInt();
            System.out.print("Course Score: ");
            courseScores[i] = scanner.nextInt();
            scanner.nextLine();
        }

        // Display the table header
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");

        // Calculate and display results
        double totalQualityPoints = 0;
        int totalCourseUnits = 0;

        for (int i = 0; i < numCourses; i++) {
            int gradeUnit = new GpaChallenge().calculateGradeUnit(courseScores[i]);
            int qualityPoint = courseUnits[i] * gradeUnit;

            totalQualityPoints += qualityPoint;
            totalCourseUnits += courseUnits[i];

            // Display course details in tabular form
            System.out.printf("| %-26s | %-21d | %-10s | %-19d |\n", courseNames[i] + " (" + courseCodes[i] + ")",
                    courseUnits[i], new GpaChallenge().getGrade(courseScores[i]), gradeUnit);
        }

        // Display the table footer
        System.out.println("|---------------------------------------------------------------------------------------|");

        // Calculate and display GPA
        double gpa = totalQualityPoints / totalCourseUnits;
        System.out.printf("Your GPA is = %.2f to 2 decimal places.\n", gpa);
    }

    public static void main(String... args) {
        GpaChallenge gpaChallenge = new GpaChallenge();
        gpaChallenge.calculateGpa();
    }
}
