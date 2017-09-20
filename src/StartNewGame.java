import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class StartNewGame implements Runnable {
    static Food food;
    static Snake snake;
    private static Map map;
    static boolean gameOver = false;
    private static JFrame frame;


    private final int START_SNAKE_X = 10;
    private final int START_SNAKE_Y = 10;
    private final int START_SNAKE_SIZE = 6;


    StartNewGame() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        GUI.newGameWindow.setVisible(false);
        frame = new JFrame(GUI.WINDOW_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(GUI.FIELD_WIDTH * GUI.POINT_RADIUS + GUI.FIELD_DX, GUI.FIELD_HEIGHT * GUI.POINT_RADIUS + GUI.FIELD_DY);
        frame.setLocation(GUI.START_LOCATION, GUI.START_LOCATION);
        frame.setResizable(false);

        map = new Map();
        map.setBackground(Color.WHITE);
        frame.getContentPane().add(BorderLayout.CENTER, map);
        frame.addKeyListener(keyAdapter);

        frame.setVisible(true);

        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, GUI.RIGHT);
        food = new Food();




        while (!gameOver) {
            snake.move();
            if (food.isEaten()) {
                food.next();
            }
            map.repaint();

            try {
                Thread.sleep(GUI.SHOW_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GUI.newGameWindow.setVisible(true);
    }

    private KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            StartNewGame.snake.setDirection(e.getKeyCode());
        }
    };
}
