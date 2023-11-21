package shapes;

import java.awt.*;

public abstract class Shape implements Drawable {
    protected Point P;
    protected Color c;

    public Shape(Point P, Color c) {
        this.P = P;
        this.c = c;
    }

    //public abstract Graphics draw(Graphics object);
}
