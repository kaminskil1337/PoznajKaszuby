import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Puzzle{
    Boolean solved = false;
    public JPanel puzzlePanel, bottomPanel, successPanel;
    public JButton btnMenu, btnCheck, btnReset;
    public JLabel successInfo, plansza;
    static int x = 0;
    static int correctIndicator = 0;

    ImageIcon planszaImg = new ImageIcon("src/background.png");

    List<PuzzleElement> listOfElements = new ArrayList<>();

    public Puzzle () {

        plansza = new JLabel();
        plansza.setBounds(0,0,1280,800);
        plansza.setIcon(planszaImg);

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

        btnReset = new JButton();
        btnReset.setBounds(760,22,280,140);
        btnReset.setText("Reset");

        successPanel = new JPanel();
        successPanel.setBounds(0,0,1280,800);
        successPanel.setLayout(null);
        successPanel.add(successInfo);

    }

    public void resetPuzzles(JFrame f){
        correctIndicator = 0;
        for (PuzzleElement el : listOfElements) {
            el.puzzleIcon.setBounds(el.puzzleX,el.puzzleY,250,250);
            el.puzzleCorner = new Point(el.puzzleX, el.puzzleY);
        }
        f.remove(successPanel);
        f.add(puzzlePanel);
        bottomPanel.remove(btnReset);
        bottomPanel.add(btnCheck);
        btnCheck.addActionListener(e -> ifCorrect(f));
        solved = false;
        f.repaint();
    }

    public void placePuzzles(){
        for(; x < 12; x++)
        {
            listOfElements.add(new PuzzleElement(puzzlePanel, x));

        }
        puzzlePanel.add(plansza);

    }

    public void ifCorrect(JFrame f){
        correctIndicator = 0;
        System.out.println(System.nanoTime()/100000000/60);
        for (PuzzleElement x : listOfElements) {
            if((x.puzzleCorner.getX() == x.correctPuzzlePlacesX[x.puzzleId]) && (x.puzzleCorner.getY() == x.correctPuzzlePlacesY[x.puzzleId])){
                correctIndicator ++;
            }
        }
        if(correctIndicator == 12){
            solved = true;
            bottomPanel.remove(btnCheck);
            bottomPanel.add(btnReset);
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
