import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image img;

    ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(
                img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
