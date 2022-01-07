import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Game{
    public JPanel gamePanel, bottomPanel;
    public JButton btnMenu;
    public JLabel player, failLabel, startLabel, metaLabel;
    int mouseX, mouseY;

    List<Tree> listOfTrees = new ArrayList<>();

    MoveListener moveListener;

    ImageIcon kaszub = new ImageIcon("src/kaszub.png");
    ImageIcon fail = new ImageIcon("src/fail.png");
    ImageIcon start = new ImageIcon("src/start.png");
    ImageIcon meta = new ImageIcon("src/meta.png");

    public Game() {

        player = new JLabel();
        player.setIcon(kaszub);
        player.setBounds(65,725,50,50);

        failLabel = new JLabel();
        failLabel.setIcon(fail);
        failLabel.setBounds(640, 0, 600, 224);

        startLabel = new JLabel();
        startLabel.setIcon(start);
       // startLabel.setBounds();

        gamePanel = new JPanel();
        gamePanel.setBounds(0,0,1280,800);
        gamePanel.setLayout(null);
        gamePanel.add(player);

        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.green);
        bottomPanel.setBounds(0,800,1280,224);
        bottomPanel.setLayout(null);

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

            //System.out.println(mouseX);

            for (Tree x : listOfTrees) {
                if((x.treeMap[x.mapY][x.mapX]) == 1){
                    //System.out.println("X " + (x.mapX * 100 + 40) + " - " + (x.mapX * 100 + 100 +40));
                    //System.out.println("Y " + (x.mapY * 100 ) + " - " + (x.mapY * 100+100));
                    if (((mouseX + 50) > (x.mapX * 100 + 40)) && ((mouseX) < (x.mapX * 100 + 100 +40)))
                    {
                        if(((mouseY + 50) > (x.mapY * 100)) && ((mouseY) < (x.mapY * 100 + 100))){
                            player.setBounds(65,725,50,50);
                            gamePanel.removeMouseMotionListener(moveListener);
                            bottomPanel.add(failLabel);
                            bottomPanel.repaint();



//                            if((mouseX) <= (x.mapX * 100 + 25 +40) ){
//                                player.setBounds((x.mapX * 100 + 40- 50),(mouseY -25),100,100);
//                            }
//                            if((mouseX) > (x.mapX * 100 + 25+40) ){
//                                player.setBounds((x.mapX * 100 + 100 +40),(mouseY -25),100,100);
//                            }


                        }

                    }
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
                        bottomPanel.remove(failLabel);
                        bottomPanel.repaint();
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
    }


    public void drawGame(JFrame f){
        f.add(bottomPanel);
        f.add(gamePanel);
        f.repaint();
    }
    public void clearFrame(JFrame f){
        f.remove(gamePanel);
        f.remove(bottomPanel);
        f.repaint();
    }
}

