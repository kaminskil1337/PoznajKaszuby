import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class PuzzleElement {

    Boolean correctPlace;
    int puzzleId;
    int  puzzleX, puzzleY;
    JLabel puzzleIcon;
    Random rand = new Random();
    Point prevPt, puzzleCorner;
    int[] correctPuzzlePlacesX = {140,390,640,890,140,390,640,890,140,390,640,890};
    int[] correctPuzzlePlacesY = {25,25,25,25,275,275,275,275,525,525,525,525};
    ImageIcon puzz1 = new ImageIcon("src/images/1.png");
    ImageIcon puzz2 = new ImageIcon("src/images/2.png");
    ImageIcon puzz3 = new ImageIcon("src/images/3.png");
    ImageIcon puzz4 = new ImageIcon("src/images/4.png");
    ImageIcon puzz5 = new ImageIcon("src/images/5.png");
    ImageIcon puzz6 = new ImageIcon("src/images/6.png");
    ImageIcon puzz7 = new ImageIcon("src/images/7.png");
    ImageIcon puzz8 = new ImageIcon("src/images/8.png");
    ImageIcon puzz9 = new ImageIcon("src/images/9.png");
    ImageIcon puzz10 = new ImageIcon("src/images/10.png");
    ImageIcon puzz11 = new ImageIcon("src/images/11.png");
    ImageIcon puzz12 = new ImageIcon("src/images/12.png");
    ImageIcon[] puzz = {puzz1, puzz2, puzz3, puzz4, puzz5, puzz6, puzz7, puzz8, puzz9, puzz10, puzz11, puzz12 };

    PuzzleElement(JPanel p, int id){
        correctPlace = false;
        puzzleId = id;
        puzzleX = rand.nextInt(1030);
        puzzleY = rand.nextInt(550);
        puzzleCorner = new Point(puzzleX, puzzleY);
        puzzleIcon = new JLabel();
        puzzleIcon.setIcon(puzz[id]);
        puzzleIcon.setBounds((int)puzzleCorner.getX(),(int)puzzleCorner.getY(),250,250);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        ReleaseListener releaseListener = new ReleaseListener();
        puzzleIcon.addMouseListener(clickListener);
        puzzleIcon.addMouseMotionListener(dragListener);
        puzzleIcon.addMouseListener(releaseListener);
        p.add(puzzleIcon);
    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e){
            prevPt = e.getPoint();
        }
    }

    private class DragListener extends MouseAdapter{

        public void mouseDragged(MouseEvent e) {
            Point currentPt = e.getPoint();
            puzzleCorner.translate((int)(currentPt.getX() - prevPt.getX()), (int)(currentPt.getY() - prevPt.getY()));
            puzzleIcon.setBounds((int)puzzleCorner.getX(),(int)puzzleCorner.getY(),250,250);
        }
    }

    private class ReleaseListener extends MouseAdapter {
        int[] arrX = {140,390,640,890};
        int[] arrY = {25,275,525};
        public void mouseReleased(MouseEvent e) {
            int x = ((int) puzzleCorner.getX() - 140 + 125) / 250;
            int y = ((int) puzzleCorner.getY() -25 + 125) / 250;

            int newX = arrX[x];
            int newY = arrY[y];

            puzzleCorner.setLocation(newX,newY);
            puzzleIcon.setBounds((int)puzzleCorner.getX(),(int)puzzleCorner.getY(),250,250);
        }
    }
}
