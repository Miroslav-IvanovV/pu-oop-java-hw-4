package squares;

import java.awt.*;

public class Square {

    protected int row;
    protected int col;
    protected Color color;
    protected boolean amIHere;
    protected boolean isBabaYagaThere;

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

    public void setAmIHere(boolean newPosition) {
        this.amIHere = newPosition;
    }

    public boolean getAmIHere(){
        return amIHere;
    }

    public void setIsBabaYagaThere(boolean setIsBabaYagaThere){
        this.isBabaYagaThere = setIsBabaYagaThere;
    }

    public boolean getIsBabyYagaThere(){return isBabaYagaThere;}

    public void render(Graphics g){
        g.setColor(this.color);
        g.fill3DRect(col * 100,row * 100,100,100,true);

        if(amIHere == true){
            g.setColor(Color.BLACK);
            g.fillOval(this.col * 100 + 25,this.row * 100 + 25,50,50);
        }

    }
}
