import java.util.*;
public class QuizGame {
    static class Question {
        String questionText;
        String options[];
        int correctAnswer;
        Question(String questionText, String options[], int correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String args) {
        System.out.println("   -----QUIZ GAME-----");
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 3));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"}, 2));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"1. Charles Dickens", "2. J.K. Rowling", "3. William Shakespeare", "4. Mark Twain"}, 3));
        questions.add(new Question("What is the largest ocean on Earth?", new String[]{"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"}, 4));
        questions.add(new Question("What is the chemical symbol for water?", new String[]{"1. H2O", "2. CO2", "3. O2", "4. NaCl"}, 1));
        questions.add(new Question("Who painted the Mona Lisa?", new String[]{"1. Vincent van Gogh", "2. Pablo Picasso", "3. Leonardo da Vinci", "4. Claude Monet"}, 3));
        Collections.shuffle(questions); 
        int score = 0;
        int questionNumber = 1;
        Map<Integer, Boolean> results = new HashMap<>();
        Map<Integer, Integer> correctAnswers = new HashMap<>();
        for (int i = 0; i < 4; i++) { // Generate 4 random questions
            Question question = questions.get(i);
            System.out.println("Question " + questionNumber + ": " + question.questionText);
            for (String option : question.options) {
                System.out.println(option);
            }
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nThe time given for you is completed!");
                    System.exit(0);
                }
            };
            timer.schedule(task, 15000);
            System.out.print("Select your answer for options 1 to 4: ");
            int userAnswer = scanner.nextInt();
            timer.cancel();
            if (userAnswer == question.correctAnswer) {
                score++;
                results.put(questionNumber, true);
            } else {
                results.put(questionNumber, false);
            }
            correctAnswers.put(questionNumber, question.correctAnswer);
            questionNumber++;
        }
        System.out.println("\nYour quiz is completed!");
        System.out.println("You got: " + score + "/4");
        System.out.println("Let's have a look into the summary...");
        for (Map.Entry<Integer, Boolean> entry : results.entrySet()) {
            int qNum = entry.getKey();
            boolean isCorrect = entry.getValue();
            int correctAnswer = correctAnswers.get(qNum);
            System.out.println("Question " + qNum + ": " + (isCorrect ? "Correct" : "Incorrect") + ". Correct answer: " + correctAnswer);
        }

        scanner.close();
    }
}
