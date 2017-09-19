//import java.awt.*;
//import java.util.Random;
//
//public class Food extends Point {
//    private final Color FOOD_COLOR = Color.GREEN;
//    private final int FIELD_WIDTH = 30;
//    private final int FIELD_HEIGHT = 20;
//    Snake snake;
//
//    Random random = new Random();
//
//    public Food() {
//        super(-1, -1);
//        this.color = FOOD_COLOR;
//    }
//
//    void eat() {
//        this.setXY(-1, -1);
//    }
//
//    boolean isEaten() {
//        return this.getX() == -1;
//    }
//
//    void next() {
//        int x, y;
//        do {
//            x = random.nextInt(FIELD_WIDTH);
//            y = random.nextInt(FIELD_HEIGHT);
//        } while (snake.isInsideSnake(x, y));
//        this.setXY(x, y);
//    }
//}
