import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🎓 Welcome to the Student Grade Calculator - CodSoft Internship Task 2");

        // Ask for student name
        System.out.print("🧑 Please enter the student's name: ");
        String studentName = scanner.nextLine();

        // Ask for number of subjects
        System.out.print("📘 Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // Input marks
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            int mark = scanner.nextInt();

            // Validate mark
            while (mark < 0 || mark > 100) {
                System.out.print("❌ Invalid mark! Please enter a value between 0 and 100: ");
                mark = scanner.nextInt();
            }

            marks[i] = mark;
            totalMarks += mark;
        }

        // Calculate average
        double average = (double) totalMarks / numberOfSubjects;

        // Grade calculation
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\n📊 --- RESULT ---");
        System.out.println("👨‍🎓 Student Name      : " + studentName);
        System.out.println("📚 Total Marks        : " + totalMarks + " / " + (numberOfSubjects * 100));
        System.out.printf("📈 Average Percentage : %.2f%%\n", average);
        System.out.println("🏅 Grade              : " + grade);

        scanner.close();
    }
}
