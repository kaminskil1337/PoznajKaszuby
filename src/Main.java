import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static JFrame frame;
    public static Menu menu;
    public static Puzzle puzzle;
    public static Nuty nuty;
    public static Game game;
    public static char key;

    public static void main(String[ ] args) {
        ImageIcon icon = new ImageIcon("src/icon.png");
        menu = new Menu();
        puzzle = new Puzzle();
        frame = new JFrame();
        nuty = new Nuty();
        game = new Game();
        frame.setTitle("Poznaj Kaszuby!");
        frame.setSize(1280, 1024);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
        frame.getContentPane().setLayout(null);
        menu.drawMenu(frame);
        menu.btnExit.addActionListener(e -> System.exit(0));
        menu.btnGame1.addActionListener(e -> menuToNuty());
        menu.btnGame1Rules.addActionListener(e -> menuToRules1());
        menu.btnGame2.addActionListener(e -> menuToPuzzle());
        menu.btnGame3.addActionListener(e -> menuToGame());

    }


    public static void menuToNuty(){
        menu.clearFrame(frame);
        nuty.drawNuty(frame);
        nuty.placeElements();
        nuty.btnMenu.addActionListener(e -> nutyToMenu());
        nuty.btnCheck.addActionListener(e -> nuty.ifCorrect(frame));
        nuty.btnReset.addActionListener(e -> nuty.resetPuzzles(frame));
    }

    public static void menuToRules1(){
        menu.clearFrame(frame);
        nuty.drawRules(frame);
        nuty.btnMenuRules.addActionListener(e -> nutyToMenu());
    }

    public static void menuToPuzzle(){
        menu.clearFrame(frame);
        puzzle.drawPuzzle(frame);
        puzzle.placePuzzles();
        puzzle.btnMenu.addActionListener(e -> puzzleToMenu());
        puzzle.btnCheck.addActionListener(e -> puzzle.ifCorrect(frame));
        puzzle.btnReset.addActionListener(e -> puzzle.resetPuzzles(frame));
    }

    public static void menuToGame(){
        menu.clearFrame(frame);
        game.drawGame(frame);
        game.btnMenu.addActionListener(e -> gameToMenu());
        game.placeTrees();
    }

    public static void nutyToMenu(){
        nuty.clearFrame(frame);
        menu.drawMenu(frame);
        menu.btnExit.addActionListener(e -> System.exit(0));
        menu.btnGame1.addActionListener(e -> menuToNuty());
        menu.btnGame2.addActionListener(e -> menuToPuzzle());
        menu.btnGame3.addActionListener(e -> menuToGame());
    }

    public static void puzzleToMenu(){
        puzzle.clearFrame(frame);
        menu.drawMenu(frame);
        menu.btnExit.addActionListener(e -> System.exit(0));
        menu.btnGame1.addActionListener(e -> menuToNuty());
        menu.btnGame2.addActionListener(e -> menuToPuzzle());
        menu.btnGame3.addActionListener(e -> menuToGame());
    }

    public static void gameToMenu(){
        game.clearFrame(frame);
        menu.drawMenu(frame);
        menu.btnExit.addActionListener(e -> System.exit(0));
        menu.btnGame1.addActionListener(e -> menuToNuty());
        menu.btnGame2.addActionListener(e -> menuToPuzzle());
        menu.btnGame3.addActionListener(e -> menuToGame());
    }

}
