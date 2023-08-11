/*
package src.view;

import src.controller.TriviaGame;
import src.model.Direction;
import src.model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriviaMazeGUI extends JFrame {
    private final TriviaGame triviaGame;
    private final JTextArea mazeTextArea;
    private final JTextField directionTextField;
    private final JButton moveButton;

    public TriviaMazeGUI() {
        triviaGame = new TriviaGame();

        setTitle("Trivia Maze Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mazeTextArea = new JTextArea();
        mazeTextArea.setEditable(false);
        mazeTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        add(new JScrollPane(mazeTextArea), BorderLayout.CENTER);

        directionTextField = new JTextField();
        directionTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movePlayerAndShowResult();
            }
        });
        add(directionTextField, BorderLayout.PAGE_END);

        moveButton = new JButton("Move");
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movePlayerAndShowResult();
            }
        });
        add(moveButton, BorderLayout.LINE_END);

        updateMazeTextArea();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void movePlayerAndShowResult() {
        String input = directionTextField.getText().trim().toUpperCase();
        if (!input.isEmpty()) {
            Direction direction = Direction.valueOf(input);
            String result = triviaGame.(direction);
            mazeTextArea.setText(getMazeLayout() + "\n" + result);
            directionTextField.setText("");

            if (triviaGame.isAtEdge()) {
                mazeTextArea.append("\nYou cannot move further in that direction. You are at the edge of the maze.");
            }

            if (triviaGame.isTriviaQuestion()) {
                String question = triviaGame.getCurrentQuestion();
                int choice = JOptionPane.showConfirmDialog(TriviaMazeGUI.this,
                        question, "Trivia Question", JOptionPane.YES_NO_OPTION);
                String answer = (choice == JOptionPane.YES_OPTION) ? "True" : "False";
                boolean isCorrect = triviaGame.answerTriviaQuestion(answer);
                mazeTextArea.append("\nYour answer is " + (isCorrect ? "correct!" : "incorrect!"));
            }

            if (triviaGame.isGameOver()) {
                mazeTextArea.append("\nCongratulations! You have reached the exit!");
                directionTextField.setEnabled(false);
                moveButton.setEnabled(false);
            }
        }
    }

    private void updateMazeTextArea() {
        mazeTextArea.setText(getMazeLayout());
    }

    private String getMazeLayout() {
        Room[][] rooms = triviaGame.getMaze().getRooms();
        int playerX = triviaGame.getMaze().getPlayerX();
        int playerY = triviaGame.getMaze().getPlayerY();
        int mazeSize = triviaGame.getMaze().getMazeSize();

        StringBuilder mazeString = new StringBuilder();
        for (int y = 0; y < mazeSize; y++) {
            for (int x = 0; x < mazeSize; x++) {
                if (x == playerX && y == playerY) {
                    mazeString.append("[PLYR]");
                } else if (x == mazeSize - 1 && y == mazeSize - 1) {
                    mazeString.append("[FNSH]");
                } else if (rooms[x][y].isWall()) {
                    mazeString.append("[WALL]");
                } else {
                    mazeString.append("[ROOM]");
                }
            }
            mazeString.append("\n");
        }
        return mazeString.toString();
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TriviaMazeGUI();
            }
        });
    }
}
*/
