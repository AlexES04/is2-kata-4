package software.ulpgc.kata3.dirty;

import software.ulpgc.kata3.clean.control.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private final JFreeBarchartDisplay display;

    public MainFrame() {
        this.setTitle("Kata 3");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(BorderLayout.NORTH, menu());
        this.add(display = statsPanel());
        this.commands = new HashMap<>();
    }

    private Component menu() {
        JPanel panel = new JPanel();
        panel.add(toggle());
        return panel;
    }

    private Component toggle() {
        JButton button = new JButton("Toggle");
        button.addActionListener(e -> commands.get("Toggle").execute()); return button;
    }

    private JFreeBarchartDisplay statsPanel() {
        return new JFreeBarchartDisplay();
    }

    public JFreeBarchartDisplay getDisplay() {
        return display;
    }

    public Command put(String key, Command value) {return commands.put(key, value);}
}
