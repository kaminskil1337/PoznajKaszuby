import javax.swing.*;
import java.awt.*;


public class Menu {
    public JPanel menuPanel;
    public JButton btnGame1, btnGame2, btnGame3, btnExit;

    public Menu() {
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.yellow);
        menuPanel.setBounds(0, 0, 1280, 1024);
        menuPanel.setLayout(null);

        btnGame1 = new JButton();
        btnGame2 = new JButton();
        btnGame3 = new JButton();
        btnExit = new JButton();

        btnGame1.setBounds(500, 100, 280, 140);
        btnGame2.setBounds(500, 300, 280, 140);
        btnGame3.setBounds(500, 500, 280, 140);
        btnExit.setBounds(500, 750, 280, 140);

        btnGame1.setText("Nuty");
        btnGame2.setText("Puzzle");
        btnGame3.setText("Gra");
        btnExit.setText("wyjscie");

        menuPanel.add(btnGame1);
        menuPanel.add(btnGame2);
        menuPanel.add(btnGame3);
        menuPanel.add(btnExit);

    }
    public void drawMenu(JFrame f){
        f.add(menuPanel);
        f.repaint();
    }

    public void clearFrame(JFrame f){
        f.remove(menuPanel);
        f.repaint();
    }
}
