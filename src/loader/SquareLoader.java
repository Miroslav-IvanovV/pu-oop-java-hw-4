package loader;

import squares.Square;

import java.awt.*;
import java.util.Random;

public class SquareLoader {

    Square[][] squareCollection = new Square[8][8];

    public Square[][] load(){

        declaringRedSquares();
        declaringStartingSquare();
        declaringGreenSquares();
        declaringBlueSquares();

        return squareCollection;
    }

    private void declaringRedSquares(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                squareCollection[i][j] = new Square(i, j, Color.RED);
            }
        }
    }

    private void declaringStartingSquare(){
        int randomNumber = randomGenerator(4);

        if(randomNumber == 0){
            squareCollection[0][0].setColor(Color.YELLOW);
        }

        if(randomNumber == 1){
            squareCollection[7][7].setColor(Color.YELLOW);
        }

        if(randomNumber == 2){
            squareCollection[0][7].setColor(Color.YELLOW);
        }

        if(randomNumber == 0){
            squareCollection[7][0].setColor(Color.YELLOW);
        }
    }

    private void declaringGreenSquares(){
        int row, col;

        for(int i = 0; i < 8; i++){
            row = randomGenerator(8);
            col = randomGenerator(8);

            if(squareCollection[row][col].getColor() == Color.RED){
                squareCollection[row][col].setColor(Color.GREEN);
            } else {
                i--;
            }
        }
    }

    private void declaringBlueSquares(){
        int row, col;

        for(int i = 0; i < 5; i++){
            row = randomGenerator(8);
            col = randomGenerator(8);

            if(squareCollection[row][col].getColor() == Color.RED){
                squareCollection[row][col].setColor(Color.BLUE);
            } else {
                i--;
            }
        }
    }

    private int randomGenerator(int bound){
        Random rand = new Random();
        int random = rand.nextInt(bound);
        return random;
    }
}
