import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/** Klasa gry "Nuty" */
public class Nuty {
    Boolean solved = false;
    public JPanel nutyPanel, bottomPanel, successPanel, rulesPanel;
    public JButton btnMenu, btnCheck, btnReset, btnMenuRules;
    public JLabel successInfo, plansza, rules;
    static int x = 0;
    static int correctIndicator = 0;

    ImageIcon planszaImg = new ImageIcon("src/images/plansza2.png");
    ImageIcon rulesImg = new ImageIcon("src/images/rules1Img.png");
    ImageIcon info = new ImageIcon("src/images/infoNuty.png");

    List<NutyElement> listOfElements = new ArrayList<>();

    public Nuty () {

        plansza = new JLabel();
        plansza.setBounds(0,0,1280,800);
        plansza.setIcon(planszaImg);

        rules = new JLabel();
        rules.setBounds(0,0,1280,1024);
        rules.setIcon(rulesImg);

        nutyPanel = new JPanel();
        nutyPanel.setBounds(0,0,1280,800);
        nutyPanel.setLayout(null);

        rulesPanel = new JPanel();
        rulesPanel.setBounds(0,0,1280,1024);
        rulesPanel.setLayout(null);

        bottomPanel = new JPanel();
        bottomPanel.setBounds(0,800,1280,224);
        bottomPanel.setLayout(null);

        btnMenu = new JButton();
        btnMenu.setText("Powrót do menu");
        btnMenu.setBounds(240,22,280,140);
        bottomPanel.add(btnMenu);

        btnMenuRules = new JButton();
        btnMenuRules.setText("Powrót do menu");
        btnMenuRules.setBounds(500, 750, 280, 140);
        rulesPanel.add(btnMenuRules);
        rulesPanel.add(rules);

        btnCheck = new JButton();
        btnCheck.setBounds(760, 22, 280, 140);
        btnCheck.setText("Sprawdź");
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

    /** Ułożenie elementów na planszy */
    public void placeElements(){
        for(; x < 6; x++){
            listOfElements.add(new NutyElement(nutyPanel, x));

        }
        nutyPanel.add(plansza);
    }

    /** Zresetowanie pozycji elementów na planszy */
    public void resetPuzzles(JFrame f){
        correctIndicator = 0;
        for (NutyElement el : listOfElements) {
            el.element.setBounds(el.elementX,el.elementY,el.elementW,el.elementH);
            el.elementCorner = new Point(el.elementX, el.elementY);
        }
        f.remove(successPanel);
        f.add(nutyPanel);
        bottomPanel.remove(btnReset);
        bottomPanel.add(btnCheck);
        bottomPanel.add(btnMenu);
        btnCheck.addActionListener(e -> ifCorrect(f));
        solved = false;
        f.repaint();

    }

    /** Sprawdzenie poprawności ułożonych elementów */
    public void ifCorrect(JFrame f){
        for (NutyElement x : listOfElements) {
            if ((x.elementCorner.getX() == x.correctElementX[x.elementId]) && (x.elementCorner.getY() == x.correctElementY[x.elementId])) {
                correctIndicator++;
            }
        }
        if(correctIndicator == 6){
            solved = true;
            bottomPanel.remove(btnCheck);
            bottomPanel.add(btnReset);
            f.remove(nutyPanel);
            f.add(successPanel);
            f.repaint();
        }
    }

    /** Wyświetlenie gry "Kaszubskie Nuty" */
    public void drawNuty(JFrame f){
        f.add(nutyPanel);
        f.add(bottomPanel);
        f.repaint();
    }

    /** Ukrycie wyświetlonej zawartości */
    public void clearFrame(JFrame f){
        f.remove(rulesPanel);
        f.remove(nutyPanel);
        f.remove(successPanel);
        f.remove(bottomPanel);
        f.repaint();
    }

    /** Wyświetlenie zasad gry "Kaszubskie Nuty" */
    public void drawRules(JFrame f){
        f.add(rulesPanel);
        f.repaint();
    }
}
