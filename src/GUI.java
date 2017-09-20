import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.*;

class GUI extends JFrame /* implements ActionListener*/ {

    private final int START_SNAKE_X = 10;
    private final int START_SNAKE_Y = 10;
    private final int START_SNAKE_SIZE = 6;
    private final int START_LOCATION = 200;
    private final String WINDOW_TITLE = "Snake";
    private final int START_DIRECTION = RIGHT;
    //    private JButton btnNewGame = new JButton("New Game");
//    private JButton btnExit = new JButton("Exit");
//    private JPanel jPanelForButton = new JPanel();
    private JFrame frame;
    private final int SHOW_DELAY = 100;

    static final int LEFT = 37;
    static final int UP = 38;
    static final int RIGHT = 39;
    static final int DOWN = 40;
    static final int POINT_RADIUS = 20; // in pix
    static final int FIELD_WIDTH = 30; // in point
    static final int FIELD_HEIGHT = 20;
    static final int FIELD_DX = 6;
    static final int FIELD_DY = 28;
    static Food food;
    private Map map;
    static Snake snake;
    static boolean gameOver = false;

    GUI() {
        frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
        frame.setLocation(START_LOCATION, START_LOCATION);
        frame.setResizable(false);


        map = new Map();
        map.setBackground(WHITE);
        frame.getContentPane().add(BorderLayout.CENTER, map);
        frame.addKeyListener(keyAdapter);

        frame.setVisible(true);

        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
        food = new Food();

        while (!gameOver) {
            snake.move();
            if (food.isEaten()) {
                food.next();
            }
            map.repaint();

            try {
                Thread.sleep(SHOW_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //frame.add(jPanelForButton, BorderLayout.SOUTH);


    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object src = e.getSource();
////        if (src == btnNewGame) System.out.println("Pressed 'New game' button");
////        else if (src == btnExit) System.exit(EXIT_ON_CLOSE);
//        else throw new RuntimeException("Неизвестный src = " + src);
//    }

    private KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            snake.setDirection(e.getKeyCode());
        }
    };
}