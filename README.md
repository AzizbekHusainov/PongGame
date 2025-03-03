# Pong Game

## Overview
This is a simple Pong game implemented in Java using Swing. The game features a paddle controlled by the player to bounce a ball, preventing it from touching the left boundary. The game increases in difficulty as the ball's speed gradually increases over time.

## Features
- Classic Pong-style gameplay
- Single-player mode against a wall
- Paddle controlled via arrow keys
- Increasing difficulty as ball speed increases
- Simple graphical interface using Java Swing
- Score tracking and game-over condition

## How to Play
1. Launch the game by running the `Driver` class.
2. Use the **Up Arrow** and **Down Arrow** keys to move the paddle.
3. Hit the ball with the paddle to keep it in play.
4. If the ball reaches the left boundary, the game is over.
5. The longer you play, the faster the ball moves!

## Controls
- **Up Arrow Key** - Move paddle up
- **Down Arrow Key** - Move paddle down

## Project Structure
```
Pong Game/
│-- Ball.java         # Handles ball movement and collision
│-- Driver.java       # Entry point of the program
│-- GamePanel.java    # Core game logic and animation loop
│-- MainWindow.java   # Main game window with start menu
│-- Paddle.java       # Controls paddle movement
```

## Installation & Running the Game
1. Ensure you have **Java 8+** installed on your system.
2. Clone or download this repository.
3. Compile the project using:
   ```sh
   javac *.java
   ```
4. Run the game with:
   ```sh
   java Driver
   ```

## Future Improvements
- Implement AI for a second paddle for two-player mode.
- Add sound effects for collisions.
- Improve the UI with better graphics.
- Add a start menu with difficulty selection.

