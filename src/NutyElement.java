import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class NutyElement {
    int elementId, elementX, elementY, elementW, elementH;
    JLabel element;
    Random rand = new Random();
    Point prevPt, elementCorner;
    int[] correctElementX = {352,256,386,496,770,525};
    int[] correctElementY = {98,305,305,239,238,440};
    ImageIcon element1 = new ImageIcon("src/stoleca.png");
    ImageIcon element2 = new ImageIcon("src/proste.png");
    ImageIcon element3 = new ImageIcon("src/kolo.png");
    ImageIcon element4 = new ImageIcon("src/base.png");
    ImageIcon element5 = new ImageIcon("src/ridel.png");
    ImageIcon element6 = new ImageIcon("src/hoczi.png");
    ImageIcon[] elements = {element1, element2, element3, element4, element5, element6 };


    NutyElement(JPanel p, int id){
        elementId = id;
        elementX = 45;
        elementY = rand.nextInt(600);
        elementW = elements[id].getIconWidth();
        elementH = elements[id].getIconHeight();
        elementCorner = new Point(elementX, elementY);
        element = new JLabel();
        element.setIcon(elements[id]);
        element.setBounds(elementX,elementY,elements[id].getIconWidth(),elements[id].getIconHeight());
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        ReleaseListener releaseListener = new ReleaseListener();
        element.addMouseListener(clickListener);
        element.addMouseMotionListener(dragListener);
        element.addMouseListener(releaseListener);
        p.add(element);
    }

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e){
            prevPt = e.getPoint();
        }
    }

    private class DragListener extends MouseAdapter{

        public void mouseDragged(MouseEvent e) {
            Point currentPt = e.getPoint();
            elementCorner.translate((int)(currentPt.getX() - prevPt.getX()), (int)(currentPt.getY() - prevPt.getY()));
            element.setBounds((int)elementCorner.getX(),(int)elementCorner.getY(),elementW,elementH);
        }
    }

    private class ReleaseListener extends MouseAdapter {
        public void mouseReleased(MouseEvent e) {
            if(elementId <= 2)
            {
                if((correctElementX[elementId] < ((int)elementCorner.getX() + 65)) && (((int)elementCorner.getX() + 65) < (correctElementX[elementId] + 130))){
                    if((correctElementY[elementId] < ((int)elementCorner.getY() + 65)) && (((int)elementCorner.getY() + 65) < (correctElementY[elementId] + 130))){
                        elementCorner.setLocation(correctElementX[elementId],correctElementY[elementId]);
                        element.setBounds((int)elementCorner.getX(),(int)elementCorner.getY(),130,130);
                    }
                }
            }
            else {
                if((correctElementX[elementId] < ((int)elementCorner.getX() + 65)) && (((int)elementCorner.getX() + 65) < (correctElementX[elementId] + 130))){
                    if((correctElementY[elementId] < ((int)elementCorner.getY() + 25)) && (((int)elementCorner.getY() + 25) < (correctElementY[elementId] + 130))){
                        elementCorner.setLocation(correctElementX[elementId],correctElementY[elementId]);
                        element.setBounds((int)elementCorner.getX(),(int)elementCorner.getY(),130,50);
                    }
                }
            }
        }
    }







}
