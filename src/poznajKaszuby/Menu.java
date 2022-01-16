package poznajKaszuby;

import javax.swing.*;

public class Menu {
    public JPanel menuPanel;
    public JButton btnGame1, btnGame1Rules, btnGame2, btnGame2Rules, btnGame3, btnGame3Rules, btnExit;
    public JLabel background;

    ImageIcon backgroundImg = new ImageIcon("src/images/menuBackground.png");

    public Menu() {
        menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 1280, 1024);
        menuPanel.setLayout(null);

        background = new JLabel();
        background.setIcon(backgroundImg);
        background.setBounds(0,0,1280,1024);

        btnGame1 = new JButton();
        btnGame1Rules = new JButton();
        btnGame2 = new JButton();
        btnGame2Rules = new JButton();
        btnGame3 = new JButton();
        btnGame3Rules = new JButton();
        btnExit = new JButton();

        btnGame1.setBounds(500, 100, 280, 100);
        btnGame1Rules.setBounds(500,200,280,40);
        btnGame2.setBounds(500, 300, 280, 100);
        btnGame2Rules.setBounds(500,400,280,40);
        btnGame3.setBounds(500, 500, 280, 100);
        btnGame3Rules.setBounds(500,600,280,40);
        btnExit.setBounds(500, 750, 280, 140);

        btnGame1.setText("Kaszubskie Nuty");
        btnGame1Rules.setText("Zasady");
        btnGame2.setText("Puzzle");
        btnGame2Rules.setText("Zasady");
        btnGame3.setText("Tabakierki");
        btnGame3Rules.setText("Zasady");
        btnExit.setText("wyjscie");

        menuPanel.add(btnGame1);
        menuPanel.add(btnGame2);
        menuPanel.add(btnGame3);
        menuPanel.add(btnGame1Rules);
        menuPanel.add(btnGame2Rules);
        menuPanel.add(btnGame3Rules);
        menuPanel.add(btnExit);
        menuPanel.add(background);

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
