import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Nuty {
    public JPanel nutyPanel, bottomPanel;
    public JButton btnMenu, btnCheck;
    public JLabel successInfo, plansza;
    static int x = 0;
    static int correctIndicator = 0;

    ImageIcon planszaImg = new ImageIcon("src/plansza.png");

    List<NutyElement> listOfElements = new ArrayList<NutyElement>();

    public Nuty () {

        plansza = new JLabel();
        plansza.setBounds(203,93,868,613);
        plansza.setIcon(planszaImg);

        nutyPanel = new JPanel();
        nutyPanel.setBounds(0,0,1280,800);
        nutyPanel.setLayout(null);



        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.green);
        bottomPanel.setBounds(0,800,1280,224);
        bottomPanel.setLayout(null);

        btnMenu = new JButton();
        btnMenu.setBounds(500,22,280,140);
        btnMenu.setText("Powrót do menu");
        bottomPanel.add(btnMenu);
    }

    public void placeElements(){
        for(; x < 6; x++){
            listOfElements.add(new NutyElement(nutyPanel, x));

            nutyPanel.add(plansza);
        }
    }

    public void drawNuty(JFrame f){
        f.add(nutyPanel);
        f.add(bottomPanel);
        f.repaint();
    }
    public void clearFrame(JFrame f){
        f.remove(nutyPanel);
        f.remove(bottomPanel);
        f.repaint();
    }
}
