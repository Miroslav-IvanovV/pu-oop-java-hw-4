package UI;

import game.GameBoard;
import loader.SquareLoader;
import rendering.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Modal extends JDialog {

    public Modal(JFrame parent, String title, String message){
        super(parent, title, true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);

        panel.add(label);
        getContentPane().add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public Modal(JFrame parent, String title, String message, boolean b){
        super(parent, title, true);
        JButton button = new JButton("CLOSE");
        JButton button1 = new JButton("Restart");

        button.setBounds(50, 375, 250, 50);
        button1.setBounds(50, 375, 250, 50);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                parent.dispose();
                SquareLoader loader     = new SquareLoader();
                GameBoard gameBoard     = new GameBoard(loader.load());
                rendering.Renderer renderer       = new Renderer(gameBoard);
            }
        });

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);

        panel.add(label);
        panel.add(button);
        panel.add(button1);
        getContentPane().add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

