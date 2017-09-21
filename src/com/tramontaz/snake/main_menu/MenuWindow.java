package com.tramontaz.snake.main_menu;

import com.tramontaz.snake.classic_game.ClassicGameWindow;
import com.tramontaz.snake.common.ImagePanel;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.*;

public class MenuWindow extends JFrame implements ActionListener {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final String WINDOW_TITLE = "Snake";

    private final JButton btnGameClassic = new JButton("Game classic");
    private final JButton btnGameArcade = new JButton("Game arcade");
    private final JButton btnGameSurvival = new JButton("Game survival");
    private final JButton btnExit = new JButton("Exit");
    private final JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
    private final ImagePanel grassPanel;
//    private static final int SHOW_DELAY = 100;

    public MenuWindow() {
        setTitle(WINDOW_TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        Image img = new ImageIcon("images/Snake4.jpg").getImage();
        grassPanel = new ImagePanel(img);
        add(grassPanel, BorderLayout.CENTER);

        buttonPanel.add(btnGameClassic);
        buttonPanel.add(btnGameArcade);
        buttonPanel.add(btnGameSurvival);
        buttonPanel.add(btnExit);

        btnGameClassic.addActionListener(this);
        btnExit.addActionListener(this);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

//    private void startNewGame() {
//        newGameWindow.setVisible(false);
//        frame = new JFrame(WINDOW_TITLE);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
//        frame.setLocation(START_LOCATION, START_LOCATION);
//        frame.setResizable(false);
//
//        map = new Map();
//        map.setBackground(Color.WHITE);
//        frame.getContentPane().add(BorderLayout.CENTER, map);
//        frame.addKeyListener(keyAdapter);
//
//        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
//        food = new Food();
//
//        frame.setVisible(true);
//
//        while (!gameOver) {
//            snake.move();
//            if (food.isEaten()) {
//                food.next();
//            }
//            map.repaint();
//
//            try {
//                Thread.sleep(SHOW_DELAY);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnGameClassic) {
            new ClassicGameWindow(this);
            setVisible(false);
        }
        else if (src == btnExit) System.exit(EXIT_ON_CLOSE);
        else throw new RuntimeException("Неизвестный src = " + src);
    }
}