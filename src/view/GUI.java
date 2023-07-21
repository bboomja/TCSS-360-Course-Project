package src.view;
import src.model.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GUI {
    public static void main(String[] args) {
        TriviaGame triviaGame = new TriviaGame();
        triviaGame.startGame();
        JFrame frame = new JFrame("Trivia Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,  800);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));
        JButton[][] buttons = new JButton[5][5];


    }
}
