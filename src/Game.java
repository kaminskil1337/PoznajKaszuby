import javax.swing.*;
import java.awt.*;

public class Game {
    public JPanel gamePanel, bottomPanel;
    public JButton btnMenu;

    public Game () {
        gamePanel = new JPanel();
        gamePanel.setBounds(0,0,1280,800);
        gamePanel.setLayout(null);

        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.green);
        bottomPanel.setBounds(0,800,1280,224);
        bottomPanel.setLayout(null);

        btnMenu = new JButton();
        btnMenu.setBounds(500,22,280,140);
        btnMenu.setText("Powrót do menu");
        bottomPanel.add(btnMenu);
    }
    public void drawGame(JFrame f){
        f.add(gamePanel);
        f.add(bottomPanel);
        f.repaint();
    }
    public void clearFrame(JFrame f){
        f.remove(gamePanel);
        f.remove(bottomPanel);
        f.repaint();
    }
}
