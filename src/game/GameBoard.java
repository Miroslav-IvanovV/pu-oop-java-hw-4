package game;

import squares.Square;

import java.awt.*;

public class GameBoard {

    private Square[][] squareCollection;
    private Square selectedSquare;

    public GameBoard(Square[][] squareCollection) {
        this.squareCollection = squareCollection;
    }

    public Square getSelectedSquare() {
        return selectedSquare;
    }

    public void setSelectedSquare(Square selectedSquare) {
        this.selectedSquare = selectedSquare;
    }

    public Square getSquare(int row, int col) {
        return this.squareCollection[row][col];
    }

    /**
        help rendering the game board
     */
    public void renderGameTile(Graphics g, int row, int col) {

        squareCollection[row][col].render(g);
    }

    /**
        checking if the move is valid
     */
    public boolean isMoveValid(int row, int col){
        if(isInBound(row - 1, col + 0) && amIHereChecker(row - 1, col + 0)) return true;
        if(isInBound(row + 0, col + 1) && amIHereChecker(row + 0, col + 1)) return true;
        if(isInBound(row + 1, col + 0) && amIHereChecker(row + 1, col + 0)) return true;
        if(isInBound(row + 0, col - 1) && amIHereChecker(row + 0, col - 1)) return true;

        return false;
    }

    /**
        after setting the new position this method erase the last position we were.
     */
    public void lastPositionRemover(int row, int col){
        if(isInBound(row - 1, col + 0)) squareCollection[row - 1][col + 0].setAmIHere(false);
        if(isInBound(row + 0, col + 1)) squareCollection[row + 0][col + 1].setAmIHere(false);
        if(isInBound(row + 1, col + 0)) squareCollection[row + 1][col + 0].setAmIHere(false);
        if(isInBound(row + 0, col - 1)) squareCollection[row + 0][col - 1].setAmIHere(false);
    }

    /**
        checking if we are in the bound of the array
     */
    public boolean isInBound(int row, int col){
        return(row >= 0 && row < 8 && col >= 0 && col < 8);
    }

    /**
        checking if we are in the square
     */
    public boolean amIHereChecker(int row, int col){
        return squareCollection[row][col].getAmIHere();
    }

    /**
        checking if we are trapped
     */
    public boolean amITrapped(int row, int col){
        if(     (!isInBound(row - 1, col + 0) || squareCollection[row - 1][col + 0].getColor() == Color.BLUE) &&
                (!isInBound(row + 0, col + 1) || squareCollection[row + 0][col + 1].getColor() == Color.BLUE) &&
                (!isInBound(row + 1, col + 0) || squareCollection[row + 1][col + 0].getColor() == Color.BLUE) &&
                (!isInBound(row + 0, col - 1) || squareCollection[row + 0][col - 1].getColor() == Color.BLUE)
        ) return true;

        return false;

    }

}
