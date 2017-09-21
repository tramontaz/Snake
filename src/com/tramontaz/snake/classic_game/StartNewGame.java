package com.tramontaz.snake.classic_game;

import com.tramontaz.snake.main_menu.MenuWindow;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class StartNewGame implements Runnable {
    static Food food;
    static Snake snake;
    private static Map map;
    static boolean gameOver = false;
    private static JFrame frame;
    static final int FIELD_WIDTH = 30; // in point
    static final int FIELD_HEIGHT = 20;
    static final int FIELD_DX = 6;
    static final int FIELD_DY = 28;

    private final int START_SNAKE_X = 10;
    private final int START_SNAKE_Y = 10;
    private final int START_SNAKE_SIZE = 6;


//    StartNewGame() {
//        Thread thread = new Thread(this);
//        thread.start();
//    }
//
    @Override
    public void run() {
//        MenuWindow.newGameWindow.setVisible(false);
//        frame = new JFrame(MenuWindow.WINDOW_TITLE);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setSize(FIELD_WIDTH * Point.POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * Point.POINT_RADIUS + FIELD_DY);
//        frame.setLocation(MenuWindow.START_LOCATION, MenuWindow.START_LOCATION);
//        frame.setResizable(false);
//
//        map = new Map(new ImageIcon("images/Grass.jpg").getImage());
//        frame.getContentPane().add(map);
//        frame.addKeyListener(keyAdapter);
//
//        frame.setVisible(true);
//
//        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, Snake.RIGHT);
//        food = new Food();
//
//
//        while (!gameOver) {
//            snake.move();
//            if (food.isEaten()) {
//                food.next();
//            }
//            map.repaint();
//
//            try {
//                Thread.sleep(MenuWindow.SHOW_DELAY);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        gameOver = false;
//        MenuWindow.newGameWindow.setVisible(true);
//        Thread.currentThread().interrupt();
//    }
//
//    private KeyAdapter keyAdapter = new KeyAdapter() {
//        @Override
//        public void keyPressed(KeyEvent e) {
//            StartNewGame.snake.setDirection(e.getKeyCode());
//        }
    }
}
