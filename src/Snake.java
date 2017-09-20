import java.awt.*;
import java.util.ArrayList;

class Snake {

    private static final int LEFT = 37;
    private static final int UP = 38;
    static final int RIGHT = 39;
    private static final int DOWN = 40;
    private ArrayList<Point> snake = new ArrayList<>();
    private int direction;

    Snake(int x, int y, int length, int direction) {
        for (int i = 0; i < length; i++) {
            Point point = new Point("images/snake_body2.png" ,x - i, y);
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
        if (x > StartNewGame.FIELD_WIDTH - 1) x = 0;
        if (x < 0) x = StartNewGame.FIELD_WIDTH - 1;
        if (y > StartNewGame.FIELD_HEIGHT) y = 0;
        if (y < 0) y = StartNewGame.FIELD_HEIGHT - 1;
        StartNewGame.gameOver = isInsideSnake(x, y);
        snake.add(0, new Point("images/snake_body2.png" ,x, y));
        if (isFood(StartNewGame.food)) {
            StartNewGame.food.eat();
        } else snake.remove(snake.size() - 1);

    }

    void setDirection(int direction) {
        if ((direction >= Snake.LEFT) && (direction <= Snake.DOWN)) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    private boolean isFood(Point food) {
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
