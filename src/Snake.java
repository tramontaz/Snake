//import java.awt.*;
//import java.util.ArrayList;
//
//public class Snake {
//    private final int LEFT = 37;
//    private final int UP = 38;
//    private final int RIGHT = 39;
//    private final int DOWN = 40;
//
//    private final int FIELD_WIDTH = 30;
//    private final int FIELD_HEIGHT = 20;
//    Food food;
//
//    ArrayList<Point> snake = new ArrayList<>();
//    int direction;
//
//    Snake(int x, int y, int length, int direction) {
//        for (int i = 0; i < length; i++) {
//            Point point = new Point(x - i, y);
//            snake.add(point);
//        }
//        this.direction = direction;
//
//    }
//
//    void paint(Graphics g) {
//        for (Point point : snake) {
//            point.paint(g);
//        }
//    }
//
//    void move() {
//        int x = snake.get(0).getX();
//        int y = snake.get(0).getY();
//        if (direction == LEFT) x--;
//        if (direction == RIGHT) x++;
//        if (direction == UP) y--;
//        if (direction == DOWN) y++;
//        if (x > FIELD_WIDTH - 1) x = 0;
//        if (x < 0) x = FIELD_WIDTH - 1;
//        if (y > FIELD_HEIGHT) y = 0;
//        if (y < 0) y = FIELD_HEIGHT - 1;
//        snake.add(0, new Point(x, y));
//        if (isFood(food)) {
//            food.eat();
//        } else snake.remove(snake.size() - 1);
//
//    }
//
//    void setDirection(int direction) {
//        if ((direction >= LEFT) && (direction <=DOWN)) {
//            this.direction = direction;
//        }
//    }
//
//    boolean isFood(Point food) {
//        return ((snake.get(0).getX() == food.getX()) && snake.get(0).getY() == food.getY());
//    }
//
//    boolean isInsideSnake(int x, int y) {
//        for (Point point : snake) {
//            if ((point.getX() == x) && (point.getY() == y)) {
//                return true;
//            }
//        } return false;
//    }
//}
