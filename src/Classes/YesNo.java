package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class YesNo {
    private int score = 0;
    private int attempts = 0;
    private JLabel resultLabel;
    private JLabel scoreLabel;
    private JButton yesButton;
    private JButton noButton;
    private Random random;

    public YesNo() {
        random = new Random();
        JFrame frame = new JFrame("Yes/No Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Yes/No Guessing Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titleLabel);

        JLabel instructionLabel = new JLabel("Guess whether the correct answer is 'Yes' or 'No'!");
        frame.add(instructionLabel);

        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        frame.add(yesButton);
        frame.add(noButton);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(resultLabel);

        scoreLabel = new JLabel("Score: 0 | Attempts: 0");
        frame.add(scoreLabel);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess("yes");
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess("no");
            }
        });

        frame.setVisible(true);
    }

    private String getCorrectAnswer() {
        return random.nextBoolean() ? "yes" : "no";
    }

    private void handleGuess(String playerGuess) {
        attempts++;
        String correctAnswer = getCorrectAnswer();

        if (playerGuess.equals(correctAnswer)) {
            resultLabel.setText("Correct!");
            resultLabel.setForeground(Color.GREEN);
            score++;
        } else {
            resultLabel.setText("Wrong! The correct answer was " + correctAnswer + ".");
            resultLabel.setForeground(Color.RED);
        }

        scoreLabel.setText("Score: " + score + " | Attempts: " + attempts);

        yesButton.setEnabled(false);
        noButton.setEnabled(false);

        Timer timer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("");
                yesButton.setEnabled(true);
                noButton.setEnabled(true);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        new YesNo();
    }
}
