import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Nuty {
    Boolean solved = false;
    public JPanel nutyPanel, bottomPanel, successPanel;
    public JButton btnMenu, btnCheck, btnReset;
    public JLabel successInfo, plansza;
    static int x = 0;
    static int correctIndicator = 0;

    ImageIcon planszaImg = new ImageIcon("src/plansza2.png");

    List<NutyElement> listOfElements = new ArrayList<>();

    public Nuty () {

        plansza = new JLabel();
        plansza.setBounds(0,0,1280,800);
        plansza.setIcon(planszaImg);

        nutyPanel = new JPanel();
        nutyPanel.setBounds(0,0,1280,800);
        nutyPanel.setLayout(null);

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
        for (NutyElement el : listOfElements) {
            el.element.setBounds(el.elementX,el.elementY,el.elementW,el.elementH);
            el.elementCorner = new Point(el.elementX, el.elementY);
        }
        f.remove(successPanel);
        f.add(nutyPanel);
        bottomPanel.remove(btnReset);
        bottomPanel.add(btnCheck);
        btnCheck.addActionListener(e -> ifCorrect(f));
        solved = false;
        f.repaint();

    }

    public void placeElements(){
        for(; x < 6; x++){
            listOfElements.add(new NutyElement(nutyPanel, x));

        }
        nutyPanel.add(plansza);
    }

    public void ifCorrect(JFrame f){
        for (NutyElement x : listOfElements) {
            if ((x.elementCorner.getX() == x.correctElementX[x.elementId]) && (x.elementCorner.getY() == x.correctElementY[x.elementId])) {
                correctIndicator++;
            }
        }
        System.out.println(correctIndicator);
        if(correctIndicator == 6){
            solved = true;
            bottomPanel.remove(btnCheck);
            bottomPanel.add(btnReset);
            f.remove(nutyPanel);
            f.add(successPanel);
            f.repaint();
        }
    }

    public void drawNuty(JFrame f){
        f.add(nutyPanel);
        f.add(bottomPanel);
        f.repaint();
    }

    public void clearFrame(JFrame f){
        f.remove(nutyPanel);
        f.remove(successPanel);
        f.remove(bottomPanel);
        f.repaint();
    }
}
