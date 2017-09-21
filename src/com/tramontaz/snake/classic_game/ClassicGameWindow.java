package com.tramontaz.snake.classic_game;

import com.tramontaz.snake.main_menu.MenuWindow;

import javax.swing.*;

public class ClassicGameWindow extends JFrame {

    private final MenuWindow menuWindow;

    public ClassicGameWindow(MenuWindow menuWindow) {
        this.menuWindow = menuWindow;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                menuWindow.setVisible(true);
            }
        });
    }
}
