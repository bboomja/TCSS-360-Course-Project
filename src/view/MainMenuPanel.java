package src.view;

import src.controller.TriviaGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    private TriviaGame triviaGame;
    private JFrame frame;
    private JPanel questionPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenuPanel gui = new MainMenuPanel();
            gui.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        triviaGame = new TriviaGame();
        triviaGame.startGame();

        frame = new JFrame("Trivia Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        setHistoricalTheme(frame);

        frame.setLayout(new BorderLayout());

        // Create a grid of buttons to represent the rooms in the maze
        JPanel mazePanel = new JPanel();
        mazePanel.setLayout(new GridLayout(5, 5));
        JButton[][] roomButtons = new JButton[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                roomButtons[i][j] = new JButton("Room " + (i * 5 + j + 1));
                roomButtons[i][j].addActionListener(new RoomButtonListener(i, j));
                mazePanel.add(roomButtons[i][j]);
            }
        }

        frame.add(mazePanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class RoomButtonListener implements ActionListener {
        private int row;
        private int col;

        public RoomButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Display the question for the selected room
            displayQuestion(row, col);
        }
    }

    private void displayQuestion(int row, int col) {
        // Get the question for the selected room and display it
        String question = triviaGame.getQuestion(row, col);
        // Display the question and wait for the player's answer
        // If the player's answer is correct, open the door in that direction
    }

    private void setHistoricalTheme(JFrame frame) {
        // Set the background color with a fancy historical theme.
        Color backgroundColor = new Color(214, 198, 180); // Example color representing a fancy historical theme.

        // Set the background color of the content pane (where components are placed).
        frame.getContentPane().setBackground(backgroundColor);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            // Custom settings for historical theme.
            UIManager.put("Panel.background", backgroundColor);
            UIManager.put("Button.background", new Color(185, 146, 130));
            UIManager.put("Label.background", backgroundColor);
            // More settings can be added as needed.
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Once you set the background color and any custom look and feel, make sure to refresh the frame.
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
    private void displayNextQuestion() {
        if (triviaGame.hasQuestions()) {
            questionPanel.removeAll();

            JLabel questionLabel = new JLabel("Question: " + triviaGame.getCurrentQuestion().getQuestionText());
            questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            questionPanel.add(questionLabel, BorderLayout.NORTH);

            java.util.List<String> choices = triviaGame.getCurrentQuestion().getChoices();
            String[] choicesArray = choices.toArray(new String[0]);
            JList<String> answerList = new JList<>(choicesArray);
            answerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scrollPane = new JScrollPane(answerList);

            questionPanel.add(scrollPane, BorderLayout.CENTER);

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = answerList.getSelectedIndex();
                    if (selectedIndex != -1) {
                        int userChoice = selectedIndex + 1;
                        handleAnswer(userChoice);
                    } else {
                        // Show a message dialog if no answer is selected
                        JOptionPane.showMessageDialog(frame, "Please select an answer before submitting.");
                    }
                }
            });

            questionPanel.add(submitButton, BorderLayout.SOUTH);

            frame.validate();
            frame.repaint();
        } else {
            // Display final score when the game is finished
            JOptionPane.showMessageDialog(frame, "Game over! Your final score is: " + triviaGame.getScore());
            System.exit(0);
        }
    }

    private void handleAnswer(int userChoice) {
        triviaGame.updateScore(userChoice);
        triviaGame.nextQuestion();
        displayNextQuestion();

    }
}
