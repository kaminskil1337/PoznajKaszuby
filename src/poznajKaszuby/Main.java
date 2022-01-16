package poznajKaszuby;

import javax.swing.*;


public class Main {
    public static JFrame frame;
    public static Menu menu;
    public static Puzzle puzzle;
    public static Nuty nuty;
    public static Game game;

    public static void main(String[ ] args) {
        ImageIcon icon = new ImageIcon("src/images/icon.png");
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
        menu.btnGame2Rules.addActionListener(e -> menuToRules2());
        menu.btnGame3.addActionListener(e -> menuToGame());
        menu.btnGame3Rules.addActionListener(e -> menuToRules3());

    }

    /** Przejście z menu do gry "Kaszubskie Nuty" */
    public static void menuToNuty(){
        menu.clearFrame(frame);
        nuty.drawNuty(frame);
        nuty.placeElements();
        nuty.btnMenu.addActionListener(e -> ToMenu());
        nuty.btnCheck.addActionListener(e -> nuty.ifCorrect(frame));
        nuty.btnReset.addActionListener(e -> nuty.resetPuzzles(frame));
    }

    /** Przejście z menu do zasad gry "Kaszubskie Nuty" */
    public static void menuToRules1(){
        menu.clearFrame(frame);
        nuty.drawRules(frame);
        nuty.btnMenuRules.addActionListener(e -> ToMenu());
    }

    /** Przejście z menu do gry "Puzzle" */
    public static void menuToPuzzle(){
        menu.clearFrame(frame);
        puzzle.drawPuzzle(frame);
        puzzle.placePuzzles();
        puzzle.btnMenu.addActionListener(e -> ToMenu());
        puzzle.btnCheck.addActionListener(e -> puzzle.ifCorrect(frame));
        puzzle.btnReset.addActionListener(e -> puzzle.resetPuzzles(frame));
    }

    /** Przejście z menu do zasad gry "Puzzle" */
    public static void menuToRules2(){
        menu.clearFrame(frame);
        puzzle.drawRules(frame);
        puzzle.btnMenuRules.addActionListener(e -> ToMenu());
    }

    /** Przejście z menu do gry "Tabakierki" */
    public static void menuToGame(){
        menu.clearFrame(frame);
        game.drawGame(frame);
        game.btnMenu.addActionListener(e -> ToMenu());
        game.placeTrees();
    }

    /** Przejście z menu do zasad gry "Tabakierki" */
    public static void menuToRules3(){
        menu.clearFrame(frame);
        game.drawRules(frame);
        game.btnMenuRules.addActionListener(e -> ToMenu());
    }

    /** Przejście do menu z dowolnej gry */
    public static void ToMenu(){
        puzzle.clearFrame(frame);
        nuty.clearFrame(frame);
        game.clearFrame(frame);
        menu.drawMenu(frame);
        menu.btnExit.addActionListener(e -> System.exit(0));
        menu.btnGame1.addActionListener(e -> menuToNuty());
        menu.btnGame2.addActionListener(e -> menuToPuzzle());
        menu.btnGame3.addActionListener(e -> menuToGame());
    }


}
