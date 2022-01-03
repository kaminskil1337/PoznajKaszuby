import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle{
    public JPanel puzzlePanel, bottomPanel, backgroundPanel;
    public JButton btnMenu;
    static int x = 0;

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
        btnMenu.setBounds(500,22,280,140);
        btnMenu.setText("Powrót do menu");
        bottomPanel.add(btnMenu);

        for(; x < 12; x++)
        {

            listOfElements.add(new PuzzleElement(puzzlePanel, x));

        }
        for (PuzzleElement x : listOfElements
        ) {
            System.out.println(x.puzzleId);
        }



    }

    public void drawPuzzle(JFrame f){
        f.add(puzzlePanel);
        f.add(bottomPanel);
        f.repaint();
    }
    public void clearFrame(JFrame f){
        f.remove(puzzlePanel);
        f.remove(bottomPanel);
        f.repaint();
    }

}
