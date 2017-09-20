import java.awt.*;
import java.util.ArrayList;

class Snake {


    private ArrayList<Point> snake = new ArrayList<>();
    private int direction;

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
        if (direction == GUI.LEFT) x--;
        if (direction == GUI.RIGHT) x++;
        if (direction == GUI.UP) y--;
        if (direction == GUI.DOWN) y++;
        if (x > GUI.FIELD_WIDTH - 1) x = 0;
        if (x < 0) x = GUI.FIELD_WIDTH - 1;
        if (y > GUI.FIELD_HEIGHT) y = 0;
        if (y < 0) y = GUI.FIELD_HEIGHT - 1;
        GUI.gameOver = isInsideSnake(x, y);
        snake.add(0, new Point(x, y));
        if (isFood(GUI.food)) {
            GUI.food.eat();
        } else snake.remove(snake.size() - 1);

    }

    void setDirection(int direction) {
        if ((direction >= GUI.LEFT) && (direction <= GUI.DOWN)) {
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
        } return false;
    }
}
