import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle{
    public JPanel puzzlePanel, bottomPanel, successPanel;
    public JButton btnMenu, btnCheck, btnReset;
    public JLabel successInfo;
    static int x = 0;
    static int correctIndicator = 0;

    List<PuzzleElement> listOfElements = new ArrayList<PuzzleElement>();

    public Puzzle () {

        puzzlePanel = new JPanel();
        puzzlePanel.setBounds(0,0,1280,800);
        puzzlePanel.setLayout(null);

        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.green);
        bottomPanel.setBounds(0,800,1280,224);
        bottomPanel.setLayout(null);

        btnMenu = new JButton();
        btnMenu.setBounds(240,22,280,140);
        btnMenu.setText("Powrót do menu");
        bottomPanel.add(btnMenu);

        btnCheck = new JButton();
        btnCheck.setBounds(760, 22, 280, 140);
        btnCheck.setText("Sprawdź");
        bottomPanel.add(btnCheck);

        successInfo = new JLabel();
        successInfo.setBounds(500,260,280,140);
        successInfo.setText("Gratulacje");

//        btnReset = new JButton();
//        btnReset.setBounds(760,22,280,140);
//        btnReset.setText("Reset");
//        btnReset.addActionListener(e -> resetPuzzles());

        successPanel = new JPanel();
        successPanel.setBounds(0,0,1280,800);
        successPanel.setLayout(null);
        successPanel.add(successInfo);

    }

//    public void resetPuzzles(){
//        x = 0;
//        for (PuzzleElement el : listOfElements) {
//            el = null;
//        }
//        placePuzzles();
//    }

    public void placePuzzles(){
        for(; x < 12; x++)
        {
            listOfElements.add(new PuzzleElement(puzzlePanel, x));

        }
    }

    public void ifCorrect(JFrame f){
        System.out.println("sprawdzam");
        System.out.println(correctIndicator);
        correctIndicator = 0;
        for (PuzzleElement x : listOfElements) {
            if((x.puzzleCorner.getX() == x.correctPuzzlePlacesX[x.puzzleId]) && (x.puzzleCorner.getY() == x.correctPuzzlePlacesY[x.puzzleId])){
                correctIndicator ++;
            }
        }
        if(correctIndicator == 12){
            System.out.println("siki");
            bottomPanel.remove(btnCheck);
            //bottomPanel.add(btnReset);
            f.remove(puzzlePanel);
            f.add(successPanel);
            f.repaint();
        }
    }

    public void drawPuzzle(JFrame f){
        f.add(puzzlePanel);
        f.add(bottomPanel);
        f.repaint();
    }
    public void clearFrame(JFrame f){
        f.remove(puzzlePanel);
        f.remove(successPanel);
        f.remove(bottomPanel);
        f.repaint();
    }

}
