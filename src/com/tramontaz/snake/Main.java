package com.tramontaz.snake;

import com.tramontaz.snake.main_menu.MenuWindow;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuWindow::new);
    }
}
