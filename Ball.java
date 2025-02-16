import java.awt.*;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 * The Ball class represents a moving ball within a game panel.
 * It handles the ball's movement, collisions,
 * and updates the score based on its interactions.
 */
public class Ball {
    private int x; // X-coordinate of the ball
    private int y; // Y-coordinate of the ball
    private int deltaX; // Horizontal movement step
    private int deltaY; // Vertical movement step
    private int size; // Diameter of the ball
    private double speed; // Movement speed of the ball

    private double speedIncrement = .0001; // Variable to increase ball speed gradually
    private GamePanel gamePanel; // Reference to GamePanel for score updating

    /**
     * Constructs a Ball with the specified position, direction, size, speed,
     * and a reference to the game panel.
     *
     * @param x         the initial x-coordinate of the ball
     * @param y         the initial y-coordinate of the ball
     * @param deltaX    the initial horizontal step size
     * @param deltaY    the initial vertical step size
     * @param size      the diameter of the ball
     * @param speed     the initial speed of the ball
     * @param gamePanel the {@code GamePanel} object to manage the game's score
     */
    public Ball(int x, int y, int size, double speed, GamePanel gamePanel) {
        Random rng = new Random();
        this.x = x;
        this.y = y;
        this.deltaX = rng.nextInt(2, 4); // Random horizontal step size between 2 and 3
        this.deltaY = rng.nextInt(1, 3); // Random vertical step size between 1 and 2
        this.size = size;
        this.speed = speed;
        this.gamePanel = gamePanel;
        System.out.println(deltaX);
        System.out.println(deltaY);
    }

    /**
     * Paints the ball
     *
     * @param g object to draw the ball on
     */
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, size, size);
    }

    /**
     * Animates the ball's movement, handles collision detection with the paddle,
     * updates the score, and checks for boundary conditions.
     *
     * @param paddle The object to check for collisions
     */
    public void animate(Paddle paddle) {
        x += deltaX * speed;
        y += deltaY * speed;

        if (x <= paddle.getX() + paddle.getWidth() && y + size >= paddle.getY()
                && y <= paddle.getY() + paddle.getHeight()) {
            deltaX *= -1; // Reverse horizontal direction
            x = paddle.getX() + paddle.getWidth();
        }

        // Ball touches left side
        if (x <= 0) {
            JOptionPane.showMessageDialog(null, "Game Over! Final Score: " + gamePanel.getScore());
            gamePanel.setScore(0);
            System.exit(0);
        }

        // Ball touches right side
        if ((x + size) >= 825) {
            deltaX *= -1;
            gamePanel.setScore(gamePanel.getScore() + 1);
        }

        // Ball touches the top or bottom
        if (y <= 15 || (y + size) >= 475) {
            deltaY *= -1;
        }

        if (speed < 100) {
            speed += speedIncrement;
        }
    }
}
