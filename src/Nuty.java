import javax.swing.*;
import java.awt.*;

public class Nuty {
    public JPanel nutyPanel, bottomPanel;
    public JButton btnMenu;

    public Nuty () {
        nutyPanel = new JPanel();
        nutyPanel.setBackground(Color.blue);
        nutyPanel.setBounds(0,0,1280,800);
        nutyPanel.setLayout(null);

        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.green);
        bottomPanel.setBounds(0,800,1280,224);
        bottomPanel.setLayout(null);

        btnMenu = new JButton();
        btnMenu.setBounds(500,22,280,140);
        btnMenu.setText("Powrót do menu");
        bottomPanel.add(btnMenu);
    }
    public void drawNuty(JFrame f){
        f.add(nutyPanel);
        f.add(bottomPanel);
        f.repaint();
    }
    public void clearFrame(JFrame f){
        f.remove(nutyPanel);
        f.remove(bottomPanel);
        f.repaint();
    }
}
