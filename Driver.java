import javax.swing.*;

public class Driver {
    public static void main(String[] args) {
        MainWindow window = new MainWindow("Pong Game");
        window.setSize(858, 525); // Hard coded to these dimensions because pong on atari had these dimensions
        window.setResizable(false);
        window.setLocation(200, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);
    }
}