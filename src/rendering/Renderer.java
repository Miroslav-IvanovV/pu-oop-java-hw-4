package rendering;

import UI.Modal;
import game.GameBoard;
import loader.SquareLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static loader.SquareLoader.randomGenerator;

public class Renderer extends JFrame implements MouseListener {

    GameBoard gameBoardLogic;

    /**
        set the board parameters
     */
    public Renderer(GameBoard gameBoardLogic) {

        // Reference to game logic
        this.gameBoardLogic = gameBoardLogic;

        // Reference to UI logic
        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = e.getY() / 100;
        int col = e.getX() / 100;

        if(gameBoardLogic.isMoveValid(row, col)){
            if(gameBoardLogic.amITrapped(row, col)){
                new Modal(this, "Youre trapped", "Youre trapped");
            }
            this.gameBoardLogic.setSelectedSquare(this.gameBoardLogic.getSquare(row, col));
            if(gameBoardLogic.getSelectedSquare().getColor() == Color.RED){
                if(1 == randomGenerator(5)){
                    gameBoardLogic.getSelectedSquare().setColor(Color.BLUE);
                    repaint();
                    return;
                } else {
                    gameBoardLogic.getSelectedSquare().setColor(Color.YELLOW);
                    gameBoardLogic.getSelectedSquare().setAmIHere(true);
                }
            }

            if(gameBoardLogic.getSelectedSquare().getColor() == Color.YELLOW){
                gameBoardLogic.getSelectedSquare().setAmIHere(true);
            }

            if(gameBoardLogic.getSelectedSquare().getColor() == Color.GREEN){
                if(gameBoardLogic.getSelectedSquare().getIsBabyYagaThere()) {
                    new Modal(this, "Congrats", "You won",true);
                    gameBoardLogic.getSelectedSquare().setAmIHere(true);
                    SquareLoader loader     = new SquareLoader();
                    GameBoard gameBoard     = new GameBoard(loader.load());
                    Renderer renderer       = new Renderer(gameBoard);
                    return;
                } else {
                    new Modal(this, "Baba yaga is not here", "Baba yaga is not here keep searching");
                    gameBoardLogic.getSelectedSquare().setAmIHere(true);
                }

            }
            if(gameBoardLogic.getSelectedSquare().getColor() == Color.BLUE){
                new Modal(this, "Cant go there", "You Cant go there");
                return;
            }

            gameBoardLogic.lastPositionRemover(row, col);
            repaint();

        } else {
            new Modal(this, "Wrong input", "Incorrect move, please try again");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void paint(Graphics g) {

        /**
            render the board
         */
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {

                gameBoardLogic.renderGameTile(g,row,col);
            }
        }
    }
}
