import java.awt.*;

class Point {
    private int x, y;
    Color color = Color.BLACK;

    Point(int x, int y) {
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

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
