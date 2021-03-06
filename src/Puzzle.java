import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Puzzle{
    Boolean solved = false;
    public JPanel puzzlePanel, bottomPanel, successPanel, rulesPanel;
    public JButton btnMenu, btnCheck, btnReset, btnMenuRules;
    public JLabel successInfo, plansza, rules;
    static int x = 0;
    static int correctIndicator = 0;

    ImageIcon rulesImg = new ImageIcon("images/rules2Img.png");
    ImageIcon planszaImg = new ImageIcon("images/background.png");
    ImageIcon info = new ImageIcon("images/infoZamek.png");

    List<PuzzleElement> listOfElements = new ArrayList<>();

    public Puzzle () {

        plansza = new JLabel();
        plansza.setBounds(0,0,1280,800);
        plansza.setIcon(planszaImg);

        rules = new JLabel();
        rules.setBounds(0,0,1280,1024);
        rules.setIcon(rulesImg);

        puzzlePanel = new JPanel();
        puzzlePanel.setBounds(0,0,1280,800);
        puzzlePanel.setLayout(null);

        rulesPanel = new JPanel();
        rulesPanel.setBounds(0,0,1280,1024);
        rulesPanel.setLayout(null);

        bottomPanel = new JPanel();
        bottomPanel.setBounds(0,800,1280,224);
        bottomPanel.setLayout(null);

        btnMenu = new JButton();
        btnMenu.setBounds(240,22,280,140);
        btnMenu.setText("Powrot do menu");
        bottomPanel.add(btnMenu);

        btnMenuRules = new JButton();
        btnMenuRules.setText("Powrot do menu");
        btnMenuRules.setBounds(500, 750, 280, 140);
        rulesPanel.add(btnMenuRules);
        rulesPanel.add(rules);

        btnCheck = new JButton();
        btnCheck.setBounds(760, 22, 280, 140);
        btnCheck.setText("Sprawdz");
        bottomPanel.add(btnCheck);

        successInfo = new JLabel();
        successInfo.setBounds(0,0,1280,1024);
        successInfo.setIcon(info);

        btnReset = new JButton();
        btnReset.setBounds(760,22,280,140);
        btnReset.setText("Reset");

        successPanel = new JPanel();
        successPanel.setBounds(0,0,1280,800);
        successPanel.setLayout(null);
        successPanel.add(successInfo);

    }

    /** U??o??enie puzzli na planszy */
    public void placePuzzles(){
        for(; x < 12; x++)
        {
            listOfElements.add(new PuzzleElement(puzzlePanel, x));

        }
        puzzlePanel.add(plansza);

    }

    /** Zresetowanie pozycji puzzli na planszy */
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

    /** Sprawdzenie poprawno??ci u??o??onych puzzli */
    public void ifCorrect(JFrame f){
        correctIndicator = 0;
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

    /** Wy??wietlenie gry "Puzzle" */
    public void drawPuzzle(JFrame f){
        f.add(puzzlePanel);
        f.add(bottomPanel);
        f.repaint();
    }

    /** Ukrycie wy??wietlonej zawarto??ci */
    public void clearFrame(JFrame f){
        f.remove(rulesPanel);
        f.remove(puzzlePanel);
        f.remove(successPanel);
        f.remove(bottomPanel);
        f.repaint();
    }

    /** Wy??wietlenie zasad gry "Puzzle" */
    public void drawRules(JFrame f){
        f.add(rulesPanel);
        f.repaint();
    }

}
