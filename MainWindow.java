import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MainWindow class represents the main window for the Pong game.
 * It contains a welcome screen with instructions, start and exit buttons,
 * and transitions to the game panel when the user starts the game.
 */
public class MainWindow extends JFrame {

    /**
     * Constructs a MainWindow object with the specified title, initializes
     * the welcome panel with instructions, and sets up action listeners for the
     * start and exit buttons.
     *
     * @param title the title of the window
     */
    public MainWindow(String title) {
        super(title);
        JPanel welcomePanel = new JPanel(); // Welcome screen
        GamePanel gamePanel = new GamePanel(); // Game panel containing all game components

        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Welcome to my Pong Game!");
        JTextField instructions = new JTextField();
        JButton startButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");

        instructions.setText("Instructions: Use arrow keys to move the paddle verically and try to hit the ball. As time goes on, the ball speeds up. If you miss its Game Over!");

        // Add an action listener to the start button to transition to the game panel
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(gamePanel);
                revalidate();
                repaint(); // Repaint the window
                gamePanel.requestFocusInWindow(); // Could not get this code to work also got help from an online
                                                  // discord group
                new Thread(gamePanel::animate).start(); // Start the game loop
            }
        });

        // Add an action listener to the exit button to close the application
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        welcomePanel.add(titleLabel);
        welcomePanel.add(instructions);
        welcomePanel.add(startButton);
        welcomePanel.add(exitButton);

        this.setContentPane(welcomePanel);
        System.out.println("Im done");
    }
}