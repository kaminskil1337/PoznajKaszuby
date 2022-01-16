package poznajKaszuby;

import javax.swing.*;

public class Tree {

    JLabel treeElement;
    int mapX, mapY;

    /** Macierz określająca w jakim miejscu ma być wyświetlone drzewo */
    int[][] treeMap = {
            {0,0,0,0,0,0,0,1,0,0,0,0},
            {0,1,1,0,1,1,0,1,0,1,1,1},
            {0,0,1,0,1,0,0,1,0,0,1,0},
            {1,0,1,0,1,0,1,1,1,0,0,0},
            {1,1,1,0,1,0,1,0,0,0,1,1},
            {0,0,0,0,1,0,1,0,1,0,0,1},
            {0,1,1,0,1,0,1,1,1,1,0,1},
            {0,1,0,0,1,0,0,0,0,0,0,1}};

    ImageIcon treeImg = new ImageIcon("src/images/tree.png");

    Tree(JPanel p, int id){
        mapY = id / 12;
        mapX = id % 12;

        if(treeMap[mapY][mapX] == 1){
            treeElement = new JLabel();
            treeElement.setIcon(treeImg);
            treeElement.setBounds(mapX*100+40,mapY*100,100,100);
            p.add(treeElement);
        }
    }
}
