package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TabbedAppTest {

    TabbedApp app;

    @BeforeEach
    void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            app = new TabbedApp();
        });
    }

    @AfterEach
    void tearDown() {
        app.frame.dispose();
    }

    @Test
    void createFrame() {
        assertNotNull(app.frame);
        assertEquals("Tabbed Pane Application", app.frame.getTitle());
        assertEquals(600, app.frame.getWidth());
        assertEquals(400, app.frame.getHeight());
    }

    @Test
    public void testFrameProperties() {
        assertAll("Frame Properties",
                () -> assertNotNull(app.frame),
                () -> assertEquals("Tabbed Pane Application", app.frame.getTitle()),
                () -> assertSame(JFrame.EXIT_ON_CLOSE, app.frame.getDefaultCloseOperation())
        );
    }

    @Test
    public void testTabbedPaneExists() {
        assertNotNull(app.tabbedPane);

        assertEquals(5, app.tabbedPane.getTabCount());
    }

    @Test
    public void testTabTitles() {
        String[] expected = {"Form", "Text", "Buttons", "Options", "Selection"};
        String[] actual = new String[app.tabbedPane.getTabCount()];

        for (int i = 0; i < actual.length; i++) {
            actual[i] = app.tabbedPane.getTitleAt(i);
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    void addTabOne() {
        JPanel panel = (JPanel) app.tabbedPane.getComponentAt(0);
        assertEquals(5, panel.getComponentCount());

        assertInstanceOf(JLabel.class, panel.getComponent(0));
        assertInstanceOf(JTextField.class, panel.getComponent(1));
    }

    @Test
    void addTabTwo() {
        JPanel panel = (JPanel) app.tabbedPane.getComponentAt(1);
        JScrollPane scrollPane = (JScrollPane) panel.getComponent(0);
        JViewport viewport = scrollPane.getViewport();

        assertInstanceOf(JTextArea.class, viewport.getView());
    }

    @Test
    void addTabThree() {
        JPanel panel = (JPanel) app.tabbedPane.getComponentAt(2);

        assertNotNull(panel.getComponent(0));
        assertNotNull(panel.getComponent(1));

        assertAll(
                () -> assertInstanceOf(JButton.class, panel.getComponent(0)),
                () -> assertInstanceOf(JButton.class, panel.getComponent(1))
        );
    }

    @Test
    void addTabFour() {
        JPanel panel = (JPanel) app.tabbedPane.getComponentAt(3);

        assertEquals(3, panel.getComponentCount());
        assertTrue(panel.getComponent(0) instanceof JCheckBox);
    }

    @Test
    void addTabFive() {
        JPanel panel = (JPanel) app.tabbedPane.getComponentAt(4);

        boolean found = false;

        for (Component comp : panel.getComponents()) {
            if (comp instanceof JComboBox) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }
}