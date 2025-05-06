package tebogo.guessing.game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame {
    private int numberToGuess;
    private int attempts;
    private JFrame frame;
    private JTextField guessField;
    private JLabel resultLabel;

    public NumberGuessingGame() {
        numberToGuess = new Random().nextInt(100) + 1;
        attempts = 0;

        frame = new JFrame("Number Guessing Game");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Guess the Number!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        frame.add(titleLabel);

        JLabel promptLabel = new JLabel("Enter a number (1-100):");
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        promptLabel.setForeground(Color.WHITE);
        frame.add(promptLabel);

        guessField = new JTextField(10);
        frame.add(guessField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.WHITE);
        submitButton.setForeground(Color.BLUE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        frame.add(submitButton);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultLabel.setForeground(Color.WHITE);
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());
            attempts++;
            if (guess < numberToGuess) {
                resultLabel.setText("Too low! Try again.");
            } else if (guess > numberToGuess) {
                resultLabel.setText("Too high! Try again.");
            } else {
                resultLabel.setText("Congrats! You guessed it in " + attempts + " attempts.");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}