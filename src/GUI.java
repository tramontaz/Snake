import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI extends JFrame implements ActionListener {

    static final int START_LOCATION = 200;
    static final String WINDOW_TITLE = "Snake";

    private JButton btnNewGame = new JButton("New Game");
    private JButton btnExit = new JButton("Exit");
    private JPanel jPanelForButton = new JPanel();
    private ImagePanel grassPanel;
    static final int SHOW_DELAY = 100;
    static JFrame newGameWindow;


    GUI() {
        newGameWindow = new JFrame(WINDOW_TITLE);
        newGameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        newGameWindow.setSize(640, 480);
        newGameWindow.setLocation(START_LOCATION, START_LOCATION);
        newGameWindow.setResizable(false);

        grassPanel = new ImagePanel(new ImageIcon("images/Snake4.jpg").getImage());
        newGameWindow.getContentPane().add(grassPanel);

        jPanelForButton.setLayout(new GridLayout());
        jPanelForButton.add(btnNewGame);
        jPanelForButton.add(btnExit);
        btnNewGame.addActionListener(this);
        btnExit.addActionListener(this);
        newGameWindow.add(jPanelForButton, BorderLayout.SOUTH);
        newGameWindow.setVisible(true);
    }

//    private void startNewGame() {
//        newGameWindow.setVisible(false);
//        frame = new JFrame(WINDOW_TITLE);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
//        frame.setLocation(START_LOCATION, START_LOCATION);
//        frame.setResizable(false);
//
//        map = new Map();
//        map.setBackground(Color.WHITE);
//        frame.getContentPane().add(BorderLayout.CENTER, map);
//        frame.addKeyListener(keyAdapter);
//
//        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
//        food = new Food();
//
//        frame.setVisible(true);
//
//        while (!gameOver) {
//            snake.move();
//            if (food.isEaten()) {
//                food.next();
//            }
//            map.repaint();
//
//            try {
//                Thread.sleep(SHOW_DELAY);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnNewGame) new StartNewGame();
        else if (src == btnExit) System.exit(EXIT_ON_CLOSE);
        else throw new RuntimeException("Неизвестный src = " + src);
    }
}