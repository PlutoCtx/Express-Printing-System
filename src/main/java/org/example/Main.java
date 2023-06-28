package org.example;

import org.example.view.LoginFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame thisClass = new LoginFrame();
            thisClass.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Toolkit toolkit = thisClass.getToolkit();
            Dimension dm = toolkit.getScreenSize();
            thisClass.setLocation((dm.width - thisClass.getWidth()) / 2, (dm.height - thisClass.getHeight()) / 2);
            thisClass.setVisible(true);
        });
    }
}
