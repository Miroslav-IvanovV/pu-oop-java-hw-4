package homework;

import game.GameBoard;
import loader.SquareLoader;
import rendering.Renderer;

public class Main {

    public static void main(String[] args) {
        SquareLoader loader     = new SquareLoader();
        GameBoard gameBoard     = new GameBoard(loader.load());
        Renderer renderer       = new Renderer(gameBoard);

    }
}
