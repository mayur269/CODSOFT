public class Main {
    public static void main(String[] args) {
        QuizQuestion[] questions = new QuizQuestion[]{
                new QuizQuestion("What is the size of int in Java?", new String[]{"8 bits", "16 bits", "32 bits", "64 bits"}, 2),
                new QuizQuestion("Which of the following is not a primitive type in Java?", new String[]{"int", "float", "String", "double"}, 2),
                new QuizQuestion("Which keyword is used to create a class in Java?", new String[]{"class", "create", "new", "define"}, 0),
                new QuizQuestion("What is the default value of a boolean variable in Java?", new String[]{"true", "false", "0", "1"}, 1),
                new QuizQuestion("Which method is used to start a thread in Java?", new String[]{"init()", "start()", "run()", "resume()"}, 1)
        };

        new Quiz(questions);
    }
}

