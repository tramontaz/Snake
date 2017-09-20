import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI extends JFrame implements ActionListener {

    static final int START_LOCATION = 200;
    static final String WINDOW_TITLE = "Snake";

    private JButton btnNewGame = new JButton("New Game");
    private JButton btnExit = new JButton("Exit");
    private JPanel jPanelForButton = new JPanel();
    static final int SHOW_DELAY = 100;
    static JFrame newGameWindow;

    static final int LEFT = 37;
    static final int UP = 38;
    static final int RIGHT = 39;
    static final int DOWN = 40;
    static final int POINT_RADIUS = 20; // in pix
    static final int FIELD_WIDTH = 30; // in point
    static final int FIELD_HEIGHT = 20;
    static final int FIELD_DX = 6;
    static final int FIELD_DY = 28;


    GUI() {
        newGameWindow = new JFrame(WINDOW_TITLE);
        newGameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        newGameWindow.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
        newGameWindow.setLocation(START_LOCATION, START_LOCATION);
        newGameWindow.setResizable(false);

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