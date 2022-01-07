import javax.swing.*;

public class Tree {

    JLabel treeElement;
    int mapX, mapY;
    int treeMap[][] = {
            {0,0,0,0,0,0,0,1,0,0,0,0},
            {0,1,1,0,1,1,0,1,0,1,1,1},
            {0,0,1,0,1,0,0,1,0,0,1,0},
            {1,0,1,0,1,0,1,1,1,0,0,0},
            {1,1,1,0,1,0,1,0,0,0,1,1},
            {0,0,0,0,1,0,1,0,1,0,0,1},
            {0,1,1,0,1,0,1,1,1,1,0,1},
            {0,1,0,0,1,0,0,0,0,0,0,1}};

    ImageIcon treeImg = new ImageIcon("src/tree.png");

    Tree(JPanel p, int id, int x, int y){
        mapY = id / 12;
        mapX = id % 12;



        if(treeMap[mapY][mapX] == 1){
            treeElement = new JLabel();
            treeElement.setIcon(treeImg);
            System.out.println(mapX+ " " + mapY);
            treeElement.setBounds(mapX*100+40,mapY*100,100,100);
            p.add(treeElement);
        }
    }
}
