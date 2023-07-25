package src.view;

import src.controller.TriviaGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private final TriviaGame gameLogic;

    public GamePanel(TriviaGame gameLogic, JFrame mainFrame) {
        this.gameLogic = gameLogic;
        initializeGamePanel();
    }

    private void initializeGamePanel() {
        // Set the background color with a historical theme.
        Color backgroundColor = new Color(227, 204, 182); // Example color representing a historical theme.
        setBackground(backgroundColor);

        setLayout(new GridLayout(5, 5));
        JButton[][] buttons = new JButton[5][5];

        // Create and add buttons to the panel.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new JButton("Room " + (i * 5 + j + 1));
                add(buttons[i][j]);
                buttons[i][j].addActionListener(new QuestionButtonListener(i, j));
            }
        }
    }

    public void startGame() {
        // Start the game logic, initialize questions, etc.
        gameLogic.startGame();
    }

    private class QuestionButtonListener implements ActionListener {
        private int row;
        private int col;

        public QuestionButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String question = gameLogic.getQuestion(row, col);
            // Display the question or perform the necessary actions
        }
    }

    // Add any other methods needed for game functionalities here.
}
