package src.view;

import src.model.*;
import java.awt.*;
import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TriviaGame triviaGame = new TriviaGame();
            triviaGame.startGame();

            JFrame frame = new JFrame("Trivia Maze");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 1000);

            // Call the method to set the historical theme.
            setHistoricalTheme(frame);

            frame.setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 5));
            JButton[][] buttons = new JButton[5][5];

            // Create and add buttons to the panel.
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    buttons[i][j] = new JButton("Team1");
                    panel.add(buttons[i][j]);
                }
            }

            frame.add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    private static void setHistoricalTheme(JFrame frame) {
        // Set the background color with a historical theme.
        Color backgroundColor = new Color(227, 204, 182); // Example color representing a historical theme.

        // Set the background color of the content pane (where components are placed).
        frame.getContentPane().setBackground(backgroundColor);


        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            // Custom settings for historical theme.
            UIManager.put("Panel.background", backgroundColor);
            UIManager.put("Button.background", new Color(196, 175, 149));
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
}
