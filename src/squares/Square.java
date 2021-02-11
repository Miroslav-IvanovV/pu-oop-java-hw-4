package squares;

import java.awt.*;

public class Square {

    protected int row;
    protected int col;
    protected Color color;
    protected String id;

    public Square(int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    public Color getColor(){
        return color;
    }
}
