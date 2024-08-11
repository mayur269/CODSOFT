import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private QuizQuestion[] questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private Timer timer;
    private int timeLeft = 10; // 10 seconds for each question

    // Swing components
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup buttonGroup;
    private JButton submitButton;
    private JLabel timerLabel;

    public Quiz(QuizQuestion[] questions) {
        this.questions = questions;
        initUI();
        loadQuestion();
        startTimer();
    }

    private void initUI() {
        frame = new JFrame("Java Quiz Application");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setBounds(50, 50, 500, 50);
        frame.add(questionLabel);

        optionButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            optionButtons[i].setBounds(50, 120 + (i * 40), 500, 30);
            buttonGroup.add(optionButtons[i]);
            frame.add(optionButtons[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBounds(250, 300, 100, 40);
        frame.add(submitButton);

        timerLabel = new JLabel("Time left: " + timeLeft + " seconds");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        timerLabel.setBounds(400, 20, 200, 30);
        frame.add(timerLabel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAnswer();
            }
        });

        frame.setVisible(true);
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            QuizQuestion currentQuestion = questions[currentQuestionIndex];
            questionLabel.setText((currentQuestionIndex + 1) + ". " + currentQuestion.getQuestion());
            String[] options = currentQuestion.getOptions();

            for (int i = 0; i < options.length; i++) {
                optionButtons[i].setText(options[i]);
                optionButtons[i].setSelected(false);
            }

            timeLeft = 10; // Reset timer for each question
        } else {
            showResults();
        }
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (timeLeft > 0) {
                    timeLeft--;
                    timerLabel.setText("Time left: " + timeLeft + " seconds");
                } else {
                    submitAnswer(); // Auto-submit when time runs out
                }
            }
        }, 1000, 1000);
    }

    private void submitAnswer() {
        timer.cancel(); // Stop the timer
        int selectedOption = -1;

        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                selectedOption = i;
                break;
            }
        }

        if (selectedOption == questions[currentQuestionIndex].getCorrectAnswerIndex()) {
            score++;
        }

        currentQuestionIndex++;
        loadQuestion();
        startTimer();
    }

    private void showResults() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(3, 1));

        JLabel resultLabel = new JLabel("Quiz Finished!", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(resultLabel);

        JLabel scoreLabel = new JLabel("Your Score: " + score + " / " + questions.length, SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.add(scoreLabel);

        JTextArea summaryArea = new JTextArea();
        summaryArea.setEditable(false);
        summaryArea.setFont(new Font("Arial", Font.PLAIN, 16));
        summaryArea.setText(getSummary());
        JScrollPane scrollPane = new JScrollPane(summaryArea);
        frame.add(scrollPane);

        frame.revalidate();
        frame.repaint();
    }

    private String getSummary() {
        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < questions.length; i++) {
            summary.append((i + 1) + ". " + questions[i].getQuestion() + "\n");
            summary.append("Correct Answer: " + questions[i].getOptions()[questions[i].getCorrectAnswerIndex()] + "\n\n");
        }
        return summary.toString();
    }
}
