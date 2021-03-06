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
            x = random.nextInt(GUI.FIELD_WIDTH);
            y = random.nextInt(GUI.FIELD_HEIGHT);
        } while (GUI.snake.isInsideSnake(x, y));
        this.setXY(x, y);
    }
}
