import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}

public class QuizApp {
    static Scanner scanner = new Scanner(System.in);
    static int score = 0;

    public static void main(String[] args) {
        System.out.println("===== Welcome to the Quiz Application =====");

        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
            "What is the capital of France?",
            new String[]{"1. Berlin", "2. London", "3. Paris", "4. Rome"},
            3
        ));
        questions.add(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"},
            2
        ));
        questions.add(new Question(
            "What is the largest ocean on Earth?",
            new String[]{"1. Atlantic", "2. Indian", "3. Pacific", "4. Arctic"},
            3
        ));

        int questionNumber = 1;
        for (Question q : questions) {
            System.out.println("\nQuestion " + questionNumber + ": " + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();
            System.out.print("Your answer (1-4), you have 10 seconds: ");
            boolean timedOut = false;

            int userAnswer = -1;
            while (System.currentTimeMillis() - startTime < 10000 && userAnswer == -1) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    break;
                }
            }

            if (userAnswer == -1 || userAnswer < 1 || userAnswer > 4) {
                System.out.println("⏱️ Time's up or invalid input! Moving to next question.");
            } else {
                if (q.isCorrect(userAnswer)) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Wrong!");
                }
            }
            questionNumber++;
        }

        System.out.println("\n===== Quiz Completed! =====");
        System.out.println("Your final score: " + score + "/" + questions.size());
    }
}
