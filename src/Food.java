import java.awt.*;
import java.util.Random;

class Food extends Point {
    private Random random = new Random();

    Food() {
        super(-1, -1);
        this.color = Color.GREEN;
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
            x = random.nextInt(StartNewGame.FIELD_WIDTH);
            y = random.nextInt(StartNewGame.FIELD_HEIGHT);
        } while (StartNewGame.snake.isInsideSnake(x, y));
        this.setXY(x, y);
    }
}
