package main;


import java.awt.*;

public class Tag {
    private Point point;
    private final Integer r;
    private boolean isSelected;

    public Tag(int x, int y, int r, boolean isSelected) {
        point = new Point(x, y);
        this.r = r;
        this.isSelected = isSelected;
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }

    public int getR() {
        return r;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected() {
        this.isSelected = !this.isSelected;
    }

    public boolean isInTag(int x, int y){
        //return point.distance(x, y) <= (double)this.r/2;

        return ((Math.sqrt(Math.pow(x - this.point.x - (double)r/2, 2) + Math.pow(y - this.point.y - (double)r/2, 2))) <= (double) this.r/2);
    }

}