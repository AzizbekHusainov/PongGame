import java.awt.*;

/**
 * The Paddle class represents the player in the Pong game.
 * It defines the paddle's position, size, movement behavior, and provides
 * methods to draw the paddle on the screen.
 */
public class Paddle {
    private int x; // X-coordinate of the paddle
    private int y; // Y-coordinate of the paddle
    private int width = 10; // Width of the paddle
    private int height = 80; // Height of the paddle
    private int yDirection = 0; // Current vertical movement direction
    private int speed = 5; // Speed of the paddle movement

    /**
     * Constructs a Paddle object at the specified coordinates.
     *
     * @param x the initial X-coordinate of the paddle
     * @param y the initial Y-coordinate of the paddle
     */
    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setYDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    /**
     * Updates the paddle's position based on the current movement direction
     * and speed. Ensures that the paddle stays within the game boundaries.
     */
    public void animate() {
        y += yDirection * speed;

        if (y < 15) {
            y = 15;
        }
        if (y + height > 475) {
            y = 475 - height;
        }
    }

    /**
     * Draws a white paddle on the game screen using the graphics object.
     *
     * @param g the object used for drawing the paddle
     */
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
