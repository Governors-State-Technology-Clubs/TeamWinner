package random.number.generator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RandomNumberGenerator {

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        JFrame menuFrame = new JFrame("Main Menu");
        menuFrame.setSize(300, 150);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(new GridLayout(3, 1));

        JLabel welcomeLabel = new JLabel("Welcome to the Number Guessing Game!", SwingConstants.CENTER);
        JButton startButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose(); // close the menu
                startGame(); // launch game
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuFrame.add(welcomeLabel);
        menuFrame.add(startButton);
        menuFrame.add(exitButton);

        menuFrame.setVisible(true);
    }

    public static void startGame() {
        JFrame frame = new JFrame("Guess the Number!");
        frame.setSize(300, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter a number from 1 to 10", SwingConstants.CENTER);
        JTextField textField = new JTextField();
        JButton guessButton = new JButton("Guess");
        JButton tryAgainButton = new JButton("Try Again");
        JButton endGameButton = new JButton("End Game");

        NumberGame[] game = { new NumberGame() };

        guessButton.addActionListener(e -> {
            try {
                int guess = Integer.parseInt(textField.getText());
                if (guess == game[0].getNumber()) {
                    label.setText("Correct! 🎉");
                } else {
                    label.setText("Wrong! It was " + game[0].getNumber());
                }
                guessButton.setEnabled(false);
            } catch (NumberFormatException ex) {
                label.setText("Please enter a number!");
            }
        });

        tryAgainButton.addActionListener(e -> {
            game[0] = new NumberGame();
            label.setText("Enter a number from 1 to 10");
            textField.setText("");
            guessButton.setEnabled(true);
        });

        endGameButton.addActionListener(e -> {
            frame.dispose(); // close the game window
            showMainMenu(); // return to menu
        });

        frame.setLayout(new GridLayout(5, 1));
        frame.add(label);
        frame.add(textField);
        frame.add(guessButton);
        frame.add(tryAgainButton);
        frame.add(endGameButton);

        frame.setVisible(true);
    }
}
