import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Circle
{
    private Point center;
    private int radius;
    private String color;
    public Circle() {
        center = new Point();
        radius = 10;
        color = "black";
        draw();
    }

    public Circle(int x, int y, int rad) {
        center = new Point(x,y);
        radius = rad;
        color = "black";
        draw();
    }

    public Circle(Point center, int rad) {
        center = center;
        radius = rad;
        color = "black";
        draw();
    }

    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }

    public int perimeter() {
        return (int) (2 * Math.PI * radius);
    }

    public int area() {
        return (int) (Math.PI * Math.pow(radius, 2));
    }

    public Point top() {
        Point top = new Point(center.getX(), center.getY() + radius);
        return top;
    }

    public Point bottom() {
        Point bottom = new Point(center.getX(), center.getY() - radius);
        return center;
    }

    public Point left() {
        Point left = new Point(center.getX() - radius, center.getY());
        return center;
    }

    public Point right() {
        Point right = new Point(center.getX() + radius, center.getY());
        return center;
    }
    
    public boolean overlaps(Circle other) {
        if(center.distance(other.getCenter()) < (radius + other.getRadius())) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean verticalShadow(Circle other) {
        if(other.right().getX() > left().getX() || other.left().getX() < right().getX()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean horizontalShadow(Circle other) {
        if(other.bottom().getY() < top().getY() || other.top().getY() > bottom().getY()){
            return true;
        }
        else {
            return false;
        }
    }
    public String toString() {
        return "Center: (" + center.getX() + "," + center.getY() + "). Radius: " + radius;
    }

    public void move(int dx, int dy) {
        erase();
        center.move(dx, dy);
        draw();
    }

    public void grow(int scale) {
        erase();
        if(scale > 0) {
            radius *= scale;
        }
        draw();
    }

    public void shrink(int scale) {
        erase();
        int test = radius / scale;
        if(test != 0) {
            radius /= scale;
        }
        draw();
    }

    public void setColor(String col) {
        erase();
        color = col;
        draw();
    }

    public void reCenter(Circle other) {
        erase();
        center = other.getCenter();
        draw();
    }

    /**
     * The two methods below draw and erase the circle from the Canvas.
     * You don't need to change these at all, just call them from your modifier methods.
     */
    public void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, color, new Ellipse2D.Double(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2));
        canvas.wait(10);
    }

    public void erase() {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(this);
    }
}
