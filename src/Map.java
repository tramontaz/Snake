import javax.swing.*;
import java.awt.*;

class Map extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        StartNewGame.snake.paint(g);
        StartNewGame.food.paint(g);
        if (StartNewGame.gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fontMetrics = g.getFontMetrics();
            g.drawString("GAME OVER", (GUI.FIELD_WIDTH * GUI.POINT_RADIUS + GUI.FIELD_DX - fontMetrics.stringWidth("GAME OVER")) / 2,
                    (GUI.FIELD_HEIGHT * GUI.POINT_RADIUS + GUI.FIELD_DY) / 2);
        }
    }
}