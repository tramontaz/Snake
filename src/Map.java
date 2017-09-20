import java.awt.*;

class Map extends ImagePanel {

    private Image img;

    Map(String img) {
        super(img);
    }

    Map(Image img) {
        super(img);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        StartNewGame.snake.paint(g);
        StartNewGame.food.paint(g);
        if (StartNewGame.gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fontMetrics = g.getFontMetrics();
            g.drawString("GAME OVER", (StartNewGame.FIELD_WIDTH * Point.POINT_RADIUS + StartNewGame.FIELD_DX - fontMetrics.stringWidth("GAME OVER")) / 2,
                    (StartNewGame.FIELD_HEIGHT * Point.POINT_RADIUS + StartNewGame.FIELD_DY) / 2);
        }
    }
}