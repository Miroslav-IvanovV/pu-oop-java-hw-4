package game;

import squares.Square;

import java.awt.*;

public class GameBoard {

    private Square[][] squareCollection;

    public GameBoard(Square[][] squareCollection) {
        this.squareCollection = squareCollection;
    }

    public void renderGameTile(Graphics g, int row, int col) {

        squareCollection[row][col].render(g);
    }

}
