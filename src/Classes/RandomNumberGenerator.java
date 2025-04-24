package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RandomNumberGenerator {

    private JFrame frame;
    private NumberGame game;

    public RandomNumberGenerator() {
        frame = new JFrame("Guess the Number!");
        frame.setSize(300, 220);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Enter a number from 1 to 10", SwingConstants.CENTER);
        JTextField textField = new JTextField();
        JButton guessButton = new JButton("Guess");
        JButton tryAgainButton = new JButton("Try Again");
        JButton endGameButton = new JButton("End Game");

        game = new NumberGame();

        guessButton.addActionListener(e -> {
            try {
                int guess = Integer.parseInt(textField.getText());
                if (guess == game.getNumber()) {
                    label.setText("Correct! 🎉");
                } else {
                    label.setText("Wrong! It was " + game.getNumber());
                }
                guessButton.setEnabled(false);
            } catch (NumberFormatException ex) {
                label.setText("Please enter a number!");
            }
        });

        tryAgainButton.addActionListener(e -> {
            game = new NumberGame();
            label.setText("Enter a number from 1 to 10");
            textField.setText("");
            guessButton.setEnabled(true);
        });

        endGameButton.addActionListener(e -> {
            frame.dispose(); // Close window, return to arcade
        });

        frame.setLayout(new GridLayout(5, 1));
        frame.add(label);
        frame.add(textField);
        frame.add(guessButton);
        frame.add(tryAgainButton);
        frame.add(endGameButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void waitUntilClosed() {
        final Object lock = new Object();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                synchronized(lock) {
                    lock.notify();
                }
            }
        });

        synchronized(lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        RandomNumberGenerator rngGame = new RandomNumberGenerator();
        rngGame.waitUntilClosed();  // arcade waits until game is closed
    }

    private class NumberGame {
        private int number;

        public NumberGame() {
            Random random = new Random();
            number = random.nextInt(10) + 1;
        }

        public int getNumber() {
            return number;
        }
    }
}