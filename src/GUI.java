import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import static java.awt.Color.*;

public class GUI extends JFrame /* implements ActionListener*/ {

    private final int START_SNAKE_X = 10;
    private final int START_SNAKE_Y = 10;
    private final int START_SNAKE_SIZE = 6;
    private final int POINT_RADIUS = 20; // in pix
    private final int FIELD_WIDTH = 30; // in point
    private final int FIELD_HEIGHT = 20;
    private final int FIELD_DX = 6;
    private final int FIELD_DY = 28;
    private final int START_LOCATION = 200;
    private final int LEFT = 37;
    private final int UP = 38;
    private final int RIGHT = 39;
    private final int DOWN = 40;
    private final String WINDOW_TITLE = "Snake";
    private final int START_DIRECTION = RIGHT;
    private final Color FOOD_COLOR = GREEN;
    //    private JButton btnNewGame = new JButton("New Game");
//    private JButton btnExit = new JButton("Exit");
//    private JPanel jPanelForButton = new JPanel();
    private JFrame frame;
    private Snake snake;
    private boolean gameOver = false;
    private final int SHOW_DELAY = 100;
    private Random random = new Random();
    private Food food;

    private Map map;

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

    class Map extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            snake.paint(g);
            food.paint(g);
            if (gameOver) {
                g.setColor(Color.RED);
                g.setFont(new Font("Arial", Font.BOLD, 40));
                FontMetrics fontMetrics = g.getFontMetrics();
                g.drawString("GAME OVER", (FIELD_WIDTH * POINT_RADIUS + FIELD_DX - fontMetrics.stringWidth("GAME OVER")) / 2,
                        (FIELD_HEIGHT * POINT_RADIUS + FIELD_DY) / 2);
            }
        }
    }

    class Snake {

        ArrayList<Point> snake = new ArrayList<>();
        int direction;

        Snake(int x, int y, int length, int direction) {
            for (int i = 0; i < length; i++) {
                Point point = new Point(x - i, y);
                snake.add(point);
            }
            this.direction = direction;

        }

        void paint(Graphics g) {
            for (Point point : snake) {
                point.paint(g);
            }
        }

        void move() {
            int x = snake.get(0).getX();
            int y = snake.get(0).getY();
            if (direction == LEFT) x--;
            if (direction == RIGHT) x++;
            if (direction == UP) y--;
            if (direction == DOWN) y++;
            if (x > FIELD_WIDTH - 1) x = 0;
            if (x < 0) x = FIELD_WIDTH - 1;
            if (y > FIELD_HEIGHT) y = 0;
            if (y < 0) y = FIELD_HEIGHT - 1;
            gameOver = isInsideSnake(x, y);
            snake.add(0, new Point(x, y));
            if (isFood(food)) {
                food.eat();
            } else snake.remove(snake.size() - 1);

        }

        void setDirection(int direction) {
            if ((direction >= LEFT) && (direction <= DOWN)) {
                if (Math.abs(this.direction - direction) != 2) {
                    this.direction = direction;
                }
            }
        }

        boolean isFood(Point food) {
            return ((snake.get(0).getX() == food.getX()) && snake.get(0).getY() == food.getY());
        }

        boolean isInsideSnake(int x, int y) {
            for (Point point : snake) {
                if ((point.getX() == x) && (point.getY() == y)) {
                    return true;
                }
            }
            return false;
        }
    }

    class Food extends Point {

        public Food() {
            super(-1, -1);
            this.color = FOOD_COLOR;
        }

        void eat() {
            this.setXY(-1, -1);
        }

        boolean isEaten() {
            return this.getX() == -1;
        }

        void next() {
            int x, y;
            do {
                x = random.nextInt(FIELD_WIDTH);
                y = random.nextInt(FIELD_HEIGHT);
            } while (snake.isInsideSnake(x, y));
            this.setXY(x, y);
        }
    }
}