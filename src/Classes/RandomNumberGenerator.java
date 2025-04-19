package Classes;

import javax.swing.*;
import java.awt.event.*;


public class RandomNumberGenerator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Guess the Number!");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter a number from 1 to 10", SwingConstants.CENTER);
        JTextField textField = new JTextField();
        JButton guessButton = new JButton("Guess");
        JButton tryAgainButton = new JButton("Try Again");

        // Start with a new game
        NumberGame[] game = { new NumberGame() };

        // GUESS BUTTON ACTION
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            }
        });

        // TRY AGAIN BUTTON ACTION
        tryAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game[0] = new NumberGame(); // reset the game with a new number
                label.setText("Enter a number from 1 to 10!");
                textField.setText("");
                guessButton.setEnabled(true);
            }
        });

        frame.setLayout(new java.awt.GridLayout(4, 1));
        frame.add(label);
        frame.add(textField);
        frame.add(guessButton);
        frame.add(tryAgainButton);

        frame.setVisible(true);
    }
}

