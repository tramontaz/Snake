import java.awt.*;

class Point extends ImagePanel {

    private int x, y;
    Color color = Color.BLACK;
    static final int POINT_RADIUS = 20;

    Point(String img) {
        super(img);
    }

    Point(Image img) {
        super(img);
    }

    Point(String img, int x, int y) {
        super(img);
        this.setXY(x, y);
    }

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.drawImage(img, x * 20, y * 20, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
