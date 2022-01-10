import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Game{
    public JPanel gamePanel, bottomPanel, rulesPanel;
    public JButton btnMenu, btnMenuRules;
    public JLabel player, failLabel, startLabel, startMessageLabel,
            congratsLabel, tabakaLabel1, tabakaLabel2, tabakaLabel3,
            background, rules;
    int mouseX, mouseY;
    boolean tabaka1, tabaka2, tabaka3;



    List<Tree> listOfTrees = new ArrayList<>();

    MoveListener moveListener;

    ImageIcon congratsImg = new ImageIcon("src/congratsmessage.png");
    ImageIcon kaszub = new ImageIcon("src/kaszub.png");
    ImageIcon fail = new ImageIcon("src/fail.png");
    ImageIcon start = new ImageIcon("src/start.png");
    ImageIcon startMessage = new ImageIcon("src/startmessage.png");
    ImageIcon tabaka = new ImageIcon("src/tabaka.png");
    ImageIcon backgroundImg = new ImageIcon("src/gamebackground.png");
    ImageIcon rulesImg = new ImageIcon("src/rules3Img.png");


    public Game() {
        background = new JLabel();
        background.setIcon(backgroundImg);
        background.setBounds(0,0,1280,800);

        rules = new JLabel();
        rules.setBounds(0,0,1280,1024);
        rules.setIcon(rulesImg);

        rulesPanel = new JPanel();
        rulesPanel.setBounds(0,0,1280,1024);
        rulesPanel.setLayout(null);

        btnMenuRules = new JButton();
        btnMenuRules.setText("Powrót do menu");
        btnMenuRules.setBounds(500, 750, 280, 140);
        rulesPanel.add(btnMenuRules);
        rulesPanel.add(rules);

        tabakaLabel1 = new JLabel();
        tabakaLabel1.setIcon(tabaka);
        tabakaLabel1.setBounds(140,300,100,100);

        tabakaLabel2 = new JLabel();
        tabakaLabel2.setIcon(tabaka);
        tabakaLabel2.setBounds(740,500,100,100);

        tabakaLabel3 = new JLabel();
        tabakaLabel3.setIcon(tabaka);
        tabakaLabel3.setBounds(1140,0,100,100);

        player = new JLabel();
        player.setIcon(kaszub);
        player.setBounds(65,725,50,50);

        failLabel = new JLabel();
        failLabel.setIcon(fail);
        failLabel.setBounds(600, -20, 600, 224);

        startLabel = new JLabel();
        startLabel.setIcon(start);
        startLabel.setBounds(65,725,50,50);

        startMessageLabel = new JLabel();
        startMessageLabel.setIcon(startMessage);
        startMessageLabel.setBounds(680,-20,600,224);

        congratsLabel = new JLabel();
        congratsLabel.setIcon(congratsImg);
        congratsLabel.setBounds(640,-20,600,224);

        gamePanel = new JPanel();
        gamePanel.setBounds(0,0,1280,800);
        gamePanel.setLayout(null);
        gamePanel.add(player);
        gamePanel.add(startLabel);

        bottomPanel = new JPanel();
        bottomPanel.setBounds(0,800,1280,224);
        bottomPanel.setLayout(null);
        bottomPanel.add(startMessageLabel);

        btnMenu = new JButton();
        btnMenu.setBounds(240,22,280,140);
        btnMenu.setText("Powrót do menu");
        bottomPanel.add(btnMenu);

        ClickListener clickListener = new ClickListener();
        moveListener = new MoveListener();
        gamePanel.addMouseListener(clickListener);



    }

    private class MoveListener extends MouseAdapter {

        public void mouseMoved(MouseEvent e) {
            mouseX = (e.getX()) - 25;
            mouseY = (e.getY()) - 25;
            if (mouseX < 0) {
                mouseX = 0;
            }
            if (mouseY < 0) {
                mouseY = 0;
            }
            if (mouseX > 1230) {
                mouseX = 1230;
            }
            if (mouseY > 750) {
                mouseY = 750;
            }
            player.setBounds(mouseX, mouseY, 50, 50);

            for (Tree x : listOfTrees) {
                if((x.treeMap[x.mapY][x.mapX]) == 1){
                    if (((mouseX + 50) > (x.mapX * 100 + 40)) && ((mouseX) < (x.mapX * 100 + 100 +40)))
                    {
                        if(((mouseY + 50) > (x.mapY * 100)) && ((mouseY) < (x.mapY * 100 + 100))){
                            player.setBounds(65,725,50,50);
                            gamePanel.removeMouseMotionListener(moveListener);
                            bottomPanel.add(failLabel);
                            bottomPanel.repaint();

                        }

                    }
                }

                if ((mouseX) > 140 && (mouseX + 50) < 240){
                    if((mouseY) > 300 && (mouseY + 50) < 400){
                        tabaka1 = true;
                        gamePanel.remove(tabakaLabel1);
                        gamePanel.repaint();
                    }
                }

                if ((mouseX) > 740 && (mouseX + 50) < 840){
                    if((mouseY) > 500 && (mouseY + 50) < 600){
                        tabaka2 = true;
                        gamePanel.remove(tabakaLabel2);
                        gamePanel.repaint();
                    }
                }

                if ((mouseX) > 1140 && (mouseX + 50) < 1240){
                    if((mouseY) > 0 && (mouseY + 50) < 100){
                        tabaka3 = true;
                        gamePanel.remove(tabakaLabel3);
                        gamePanel.repaint();
                    }
                }

                if ((tabaka1 == true) && (tabaka2 == true) && (tabaka3 == true)){
                    player.setBounds(65,725,50,50);
                    gamePanel.removeMouseMotionListener(moveListener);
                    bottomPanel.add(congratsLabel);
                    bottomPanel.repaint();
                }
            }





        }
    }



        private class ClickListener extends MouseAdapter {

            public void mousePressed(MouseEvent e){
                Point click = e.getPoint();
                int x, y;
                x = (int)click.getX();
                y = (int)click.getY();
                if(x > 65 && x < 115){
                    if(y >725 && y <775){
                        gamePanel.addMouseMotionListener(moveListener);
                        gamePanel.remove(background);
                        gamePanel.add(tabakaLabel1);
                        gamePanel.add(tabakaLabel2);
                        gamePanel.add(tabakaLabel3);
                        gamePanel.add(background);
                        gamePanel.repaint();
                        bottomPanel.remove(failLabel);
                        bottomPanel.remove(congratsLabel);
                        bottomPanel.remove(startMessageLabel);
                        bottomPanel.repaint();
                        tabaka1 = false;
                        tabaka2 = false;
                        tabaka3 = false;
                    }
                }
            }
        }


    public void placeTrees(){
        int id = 0;
        for(int x = 0; x < 8; x++){
            for (int y = 0; y < 12; y++){
                listOfTrees.add(new Tree(gamePanel,id,x,y));
                id++;
            }
        }
        gamePanel.add(background);
    }


    public void drawGame(JFrame f){
        f.add(bottomPanel);
        f.add(gamePanel);
        f.repaint();
    }
    public void clearFrame(JFrame f){
        f.remove(rulesPanel);
        f.remove(gamePanel);
        f.remove(bottomPanel);
        f.repaint();
    }

    public void drawRules(JFrame f){
        f.add(rulesPanel);
        f.repaint();
    }
}

