import java.awt.*;

public class Point {
    int x, y;
    Color color = Color.BLACK;

    public Point(int x, int y) {
        this.setXY(x, y);
    }

    void setXY (int x, int y) {
        this.x = x;
        this.y = y;
    }

    void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x * 20, y * 20, 20, 20);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
