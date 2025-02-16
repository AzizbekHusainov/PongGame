import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * The GamePanel class represents the main game area for a Pong game.
 * It manages the ball, paddle, player score, and handles the animation loop 
 * and keyboard input for paddle movement.
 */
public class GamePanel extends JPanel implements KeyListener {
    private Ball pongBall; // Ball object used in the game
    private Paddle playerPaddle; // Paddle object for the player
    private int score; // Player's score

    /**
     * Constructs a GamePanel object that initializes the game components, 
     * sets up the background, and adds a key listener for paddle movement.
     */
    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true); // Searched this up
        addKeyListener(this);

        // Initialize ball and paddle
        pongBall = new Ball(858 / 2, 475/2, 10, 1.5, this);
        playerPaddle = new Paddle(30, 475/2); // Position paddle on the left
        score = 0;
    }

    /**
     * Overrides the {@code paintComponent} method to draw the game components, 
     * including the walls, ball, paddle, and score.
     *
     * @param g the object to draw on
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawWalls(g);
        pongBall.paint(g); // Draw the ball
        playerPaddle.draw(g); // Draw the paddle
        g.drawString("Score: " + score, 350, 30);
    }

    /**
     * Draws the walls of the game area on the provided panel.
     *
     * @param g the object to draw on
     */
    private void drawWalls(Graphics g) {
        // Draw top wall
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 858, 15);  

        // Draw bottom wall
        g.fillRect(0, 475, 858, 15);

        // Draw right wall
        g.fillRect(830, 0, 15, 525); 
    }

    /**
     * Starts the animation loop for the game, moving both the ball and the paddle.
     * Continuously invalidates and repaints the game panel to animate.
     */
    public void animate() {
        while (true) {
            pongBall.animate(playerPaddle);
            playerPaddle.animate(); 

            invalidate();
            repaint(); 

            // Took from Professor Raymer's class code
            try {
                Thread.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Took from Professor Raymer's class code
        }
    }

    /**
     * Handles key press events to move the paddle up or down.
     *
     * @param e the KeyEvent representing the key press
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            playerPaddle.setYDirection(-1);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            playerPaddle.setYDirection(1);
        }
    }

    /**
     * Handles key release events, stopping the paddle when no key is pressed.
     *
     * @param e the KeyEvent representing the key release
     */
    @Override
    public void keyReleased(KeyEvent e) {
        playerPaddle.setYDirection(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used but forced to implement
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
