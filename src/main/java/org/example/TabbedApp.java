// Branch 2 - Tab 1 Home and Tab 2 Profile
// Created Home panel with welcome label
// Created Profile panel with JTextField and JButton
package org.example;
import javax.swing.*;
import java.awt.*;
public class TabbedApp {
    JFrame frame;
    JTabbedPane tabbedPane;
    public TabbedApp() {
        tabbedPane = new JTabbedPane();
        addTabOne();
        addTabTwo();
        addTabThree();
        addTabFour();
        addTabFive();
        if (!GraphicsEnvironment.isHeadless()) {
            createFrame();
        }
    }
    public void createFrame() {
        frame = new JFrame("Tabbed Pane Application");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tabbedPane);
        frame.setVisible(true);
    }
    public void addTabOne() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Email:"));
        panel.add(new JTextField());
        panel.add(new JButton("Submit"));
        tabbedPane.addTab("Form", panel);
    }
    public void addTabTwo() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea("Enter your text here...");
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        tabbedPane.addTab("Text", panel);
    }
    public void addTabThree() {
        JPanel panel = new JPanel();
        panel.add(new JButton("OK"));
        panel.add(new JButton("Cancel"));
        tabbedPane.addTab("Buttons", panel);
    }
    public void addTabFour() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(new JCheckBox("Option 1"));
        panel.add(new JCheckBox("Option 2"));
        panel.add(new JCheckBox("Option 3"));
        tabbedPane.addTab("Options", panel);
    }
    public void addTabFive() {
        JPanel panel = new JPanel();
        String[] items = {"Item 1", "Item 2", "Item 3"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        panel.add(new JLabel("Select Item:"));
        panel.add(comboBox);
        tabbedPane.addTab("Selection", panel);
    }
}
