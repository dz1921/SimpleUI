package shapes;

import shapes.Shape;

import java.awt.*;

public class Circle extends Shape {
    private int radius;


    public Circle(int radius, Point P, Color c) {
        super(P, c);
        this.radius = radius;
    }
    public Graphics draw(Graphics object) {
        object.setColor(c);
        object.fillOval(P.x, P.y, 2*radius, 2*radius);
        return object;
    }
}
