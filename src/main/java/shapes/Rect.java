package shapes;

import shapes.Shape;

import java.awt.*;

public class Rect extends Shape {
    private int width;
    private int height;

    public Rect(Point P, int width, int height, Color c) {
        super(P, c);
        this.width = width;
        this.height = height;
    }
    public Graphics draw(Graphics object) {
        object.setColor(c);
        object.fillRect(P.x, P.y, width, height);
        return object;
    }
}
